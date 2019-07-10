package com.comvetlp.bo.siasc.model;

import com.comvetlp.bo.siasc.enums.TipoEstudio;
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
@Table(name = "ESTUDIO")
public class Estudio implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTUDIO")
    private Long idEstudio;
    @Column(name = "TIPO", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEstudio tipo;
    @Column(name = "ESTUDIO")
    private String estudioa;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "FECHA_REALIZADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRealizada;
    @JoinColumn(name = "ID_COLEGIADO", referencedColumnName = "ID_COLEGIADO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Colegiado idColegiado;

    public void toUpperCase(){
    this.estudioa=this.estudioa.toUpperCase().trim();
    this.descripcion=this.descripcion.toUpperCase().trim();
    }

    @Override
    public String toString() {
        return "Estudio{" +
                "idEstudio=" + idEstudio +
                ", tipo='" + tipo + '\'' +
                ", estudio='" + estudioa + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaRealizada=" + fechaRealizada +
                ", idColegiado=" + idColegiado +
                '}';
    }
}
