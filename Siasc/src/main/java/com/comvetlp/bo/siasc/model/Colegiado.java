package com.comvetlp.bo.siasc.model;

import com.comvetlp.bo.siasc.enums.TipoGenero;
import com.comvetlp.bo.siasc.util.DateUtil;
import com.comvetlp.bo.siasc.util.StringUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */
@Getter
@Setter
@Entity
@Table(name = "COLEGIADO")
public class Colegiado extends Generic<String> implements Serializable {

    private static final long serialVersionUID = -4611815928732870812L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COLEGIADO")
    private Long idColegiado;
    @Column(name = "CI")
    private String ci;
    @Column(name = "EXPEDIDO")
    private String expedido;
    @Column(name = "MATRICULA")
    private String matricula;
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Column(name = "PATERNO")
    private String paterno;
    @Column(name = "MATERNO")
    private String materno;
    @Column(name = "GENERO", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoGenero genero;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Column(name = "GRUPO_SANGUINEO")
    private String grupoSanguineo;
    @Column(name = "FOTO")
    private String foto;
    @Column(name = "FECHA_INGRESO_COMVETLP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngresoComvetlp;
    @Column(name = "UNIVERSIDAD_EGRESO")
    private String universidadEgreso;
    @Column(name = "DOMICILIO")
    private String domicilio;
    @Column(name = "COSTO_INSCRIPCION")
    private double costoInscripcion;
    @Column(name = "EXAMEN_TESIS")
    private double examenTesis;

    @Transient
    private String trsNombreCompleto;

    @Transient
    private Double trsCuotas;
    @Transient
    private String trsVigenciaPago;
    @Transient
    private Double trsCertificados;
    @Transient
    private Double trsTotal;

    //Convierte a mayusculas
    public void trimToUpperCase() {
        this.matricula = StringUtil.toTrimUpperCase(this.matricula);
        this.primerNombre = StringUtil.toTrimUpperCase(this.primerNombre);
        this.segundoNombre = StringUtil.toTrimUpperCase(this.primerNombre);
        this.paterno = StringUtil.toTrimUpperCase(this.paterno);
        this.materno = StringUtil.toTrimUpperCase(this.materno);
        this.grupoSanguineo = StringUtil.toTrimUpperCase(this.grupoSanguineo);
        this.universidadEgreso = StringUtil.toTrimUpperCase(this.universidadEgreso);
        this.domicilio = StringUtil.toTrimUpperCase(this.domicilio);
    }

    //Obtiene el nombre completo
    public String getNombreCompleto() {
        StringBuilder sb = new StringBuilder();
        if (!StringUtil.isEmptyOrNull(paterno)) {
            sb.append(paterno);
        }

        if (!StringUtil.isEmptyOrNull(materno)) {
            sb.append(" ");
            sb.append(materno);
        }

        if (!StringUtil.isEmptyOrNull(primerNombre)) {
            sb.append(" ");
            sb.append(primerNombre);
        }

        if (!StringUtil.isEmptyOrNull(segundoNombre)) {
            sb.append(" ");
            sb.append(segundoNombre);
        }

       return this.trsNombreCompleto = sb.toString().trim();
    }

    @Override
    public String toString() {
        return "Colegiado{" +
                "idColegiado=" + idColegiado +
                ", ci='" + ci + '\'' +
                ", expedido='" + expedido + '\'' +
                ", matricula='" + matricula + '\'' +
                ", primerNombre='" + primerNombre + '\'' +
                ", segundoNombre='" + segundoNombre + '\'' +
                ", paterno='" + paterno + '\'' +
                ", materno='" + materno + '\'' +
                ", genero='" + genero + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                ", foto='" + foto + '\'' +
                ", fechaIngresoComvetlp=" + fechaIngresoComvetlp +
                ", universidadEgreso='" + universidadEgreso + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", costoInscripcion=" + costoInscripcion +
                ", examenTesis=" + examenTesis +
                '}';
    }
}
