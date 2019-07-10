package com.comvetlp.bo.siasc.servicesImpl;

import com.comvetlp.bo.siasc.model.Adquiere;
import com.comvetlp.bo.siasc.repositories.AdquiereRepository;
import com.comvetlp.bo.siasc.services.AdquiereService;
import com.comvetlp.bo.siasc.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */

@Service
@Transactional(readOnly = true)
public class AdquiereServicelmpl extends GenericServiceImpl<AdquiereRepository> implements AdquiereService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private AdquiereRepository adquiereRepository;

    @Override
    public AdquiereRepository getRepository() {
        return adquiereRepository;
    }

    @Override
    public Double getCertificadosByIdColegiadoByFecha(Long idColegiado, Date fechaIni, Date fechaFin) {

        Double totalCertificado=new Double(0);

        if (fechaIni != null || fechaFin != null) {
            return totalCertificado;
        }
        if (fechaIni.after(fechaFin)) {
            return totalCertificado;
        }

        fechaIni = DateUtil.cambiarPrimeraHora(fechaIni);
        fechaFin = DateUtil.cambiarUltimaHora(fechaFin);

        List<Adquiere> listAdquiere = adquiereRepository.listCertificadosByIdColegiadoByFecha(idColegiado, fechaIni, fechaFin);

        Date primeraVigencia = DateUtil.fechaMinima();

        //Obteniendo maxima fecha
        for (Adquiere adquiere: listAdquiere) {
            totalCertificado=totalCertificado+(adquiere.getCantidad()*adquiere.getIdCertificado().getPrecio());
        }

        return totalCertificado;
    }

}
