package com.comvetlp.bo.siasc.bean;

import com.comvetlp.bo.siasc.enums.Estado;
import com.comvetlp.bo.siasc.enums.EstadoColegiado;
import com.comvetlp.bo.siasc.enums.TipoGenero;
import com.comvetlp.bo.siasc.enums.TipoTelefono;
import com.comvetlp.bo.siasc.model.Colegiado;
import com.comvetlp.bo.siasc.model.Habla;
import com.comvetlp.bo.siasc.model.Idioma;
import com.comvetlp.bo.siasc.model.Telefono;
import com.comvetlp.bo.siasc.repositories.ColegiadoRepository;
import com.comvetlp.bo.siasc.repositories.IdiomaRepository;
import com.comvetlp.bo.siasc.util.StringUtil;
import com.comvetlp.bo.siasc.util.SysMessage;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * MC4
 * La Paz - Bolivia
 * EDV - JBPM
 * 10/06/2018 - 3:44 PM
 * Created by: equinajo
 */

@Component
@Scope("view")
@Getter
@Setter
public class ColegiadosBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(ColegiadosBean.class);

    @Autowired
    private ColegiadoRepository colegiadoRepository;
    @Autowired
    private IdiomaRepository idiomaRepository;

    /* Variables para lista de colegiado*/

    //Datos del colegiado
    private Colegiado colegiado;
    private Colegiado selectColegiado;
    private List<Colegiado> listColegiado;
    //Variables de busqueda
    private Date fechaIni;
    private Date fechaFin;
    private String criterioBusqueda;
    private String estado;
    private List<SelectItem> listEstado;

    /* Variables para registro de colegiado*/

    //Datos select idioma
    private String tipoIdioma;
    private List<SelectItem> listTipoIdioma;
    //Datos habla
    private List<Habla> listHabla;
    //Datos select genero
    private TipoGenero tipoGenero;
    //Datos telefono
    private TipoTelefono tipoTelefono;
    private Telefono telefono;
    private List<Telefono> listTelefono;

    //Variables para la visualizacion de ventanas
    private boolean listaColegiadoForm;
    private boolean registroColegiadoForm;

    //Constructor del Bean
    @PostConstruct
    public void init() {
        cargar();
    }

    /**
     * Carga los componentes necesarios
     */
    public void cargar() {
        try {
            //Inicializando variables
            listColegiado = new ArrayList<Colegiado>();
            colegiado = new Colegiado();
            selectColegiado = null;
            cargarEstados();
            //Recuperando listado de colegiados
            listColegiado = colegiadoRepository.findAll();
            //Vista de formularios
            listaColegiadoForm = true;
            registroColegiadoForm = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarEstados() {
        listEstado = new ArrayList<>();
        listEstado.add(new SelectItem(EstadoColegiado.ACTIVO, EstadoColegiado.ACTIVO.getDescripcion()));
        listEstado.add(new SelectItem(EstadoColegiado.PASIVO, EstadoColegiado.PASIVO.getDescripcion()));
        listEstado.add(new SelectItem(EstadoColegiado.INSCRITO, EstadoColegiado.INSCRITO.getDescripcion()));
        estado = null;
    }

    /**
     * Registrar nuevo colegiado
     */
    public void nuevo() {
        listaColegiadoForm = false;
        registroColegiadoForm = true;

        //Incializando variables
        cargarIdiomas();
        listHabla = new ArrayList<>();
        listTelefono = new ArrayList<>();
    }

    public void cargarIdiomas() {
        List<Idioma> listIdioma = idiomaRepository.findAll();
        listTipoIdioma = new ArrayList<>();
        for (Idioma idioma : listIdioma) {
            listTipoIdioma.add(new SelectItem(idioma.getIdIdioma(), idioma.getIdiomaa()));
        }
        tipoIdioma = null;
    }


    /**
     * Muestra formulario de registro idioma
     */
    public void showFormRegistrarIdioma() {
        tipoIdioma = null;
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlgRegistraIdioma').show();");
    }

    /**
     * Registra idioma
     */
    public void registrarIdioma() {
        try {

            if (StringUtil.isEmptyOrNull(tipoIdioma)) {
                //throw new IllegalArgumentException("Debe seleccionar un idioma");
                SysMessage.warn("Debe seleccionar un idioma");
                return;
            }
            Idioma idioma = idiomaRepository.findOne(new Long(tipoIdioma));
            for (Habla habla : listHabla) {
                if (habla.getIdIdioma().getIdIdioma() == idioma.getIdIdioma()) {
                    //throw new IllegalArgumentException("Ya se encuentra registrado el idioma seleccionado");
                    SysMessage.warn("Ya se encuentra registrado el idioma seleccionado");
                    return;
                }
            }
            Habla habla = new Habla();
            habla.setIdIdioma(idioma);
            listHabla.add(habla);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgRegistraIdioma').hide();");
        } catch (Exception e) {
            SysMessage.error(e.getMessage());
        }
    }

    /**
     * Muestra formulario de registro telefono
     */
    public void showFormRegistrarTelefono() {
        telefono = new Telefono();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlgRegistraTelefono').show();");
    }

    /**
     * Registra telefono
     */
    public void registrarTelefono() {
        try {
            if (StringUtil.isEmptyOrNull(telefono.getTelefonoa())) {
                //throw new IllegalArgumentException("Debe seleccionar un idioma");
                SysMessage.warn("Debe completar el campo telefono");
                return;
            }
            if (telefono.getTelefonoa().length() < 8 || telefono.getTelefonoa().length() > 15) {
                //throw new IllegalArgumentException("Debe seleccionar un idioma");
                SysMessage.warn("La longitud del telefono debe ser mayor igual a 8 caracteres ni mayor a 15 caracteres");
                return;
            }
            for (Telefono telefonoR : listTelefono) {
                if (telefonoR.getTelefonoa().equals(telefono.getTelefonoa())) {
                    //throw new IllegalArgumentException("Ya se encuentra registrado el idioma seleccionado");
                    SysMessage.warn("Ya se encuentra registrado el telefono introducido");
                    return;
                }
            }
            telefono.setTipo(TipoTelefono.valueOf(telefono.getTipoString()));
            listTelefono.add(telefono);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgRegistraTelefono').hide();");
        } catch (Exception e) {
            SysMessage.error(e.getMessage());
        }
    }
}
