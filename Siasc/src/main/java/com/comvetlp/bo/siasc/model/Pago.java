package com.comvetlp.bo.siasc.model;

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
@Table(name = "PAGO")
public class Pago extends Generic<String> implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGO")
    private Long idPago;
    @JoinColumn(name = "ID_COLEGIADO", referencedColumnName = "ID_COLEGIADO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Colegiado idColegiado;
    @JoinColumn(name = "ID_COLEGIATURA", referencedColumnName = "ID_COLEGIATURA")
    @ManyToOne(fetch = FetchType.EAGER)
    private Colegiatura idColegiatura;
    @Column(name = "VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vigencia;
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Override
    public String toString() {
        return "Pago{" +
                "idPago=" + idPago +
                ", idColegiado=" + idColegiado +
                ", idColegiatura=" + idColegiatura +
                ", vigencia=" + vigencia +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
