package com.comvetlp.bo.siasc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */
@Getter
@Setter
@Entity
@Table(name = "ADQUIERE")
public class Adquiere extends Generic<String> implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ADQUIERE")
    private Long idAdquiere;
    @JoinColumn(name = "ID_COLEGIADO", referencedColumnName = "ID_COLEGIADO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Colegiado idColegiado;
    @JoinColumn(name = "ID_CERTIFICADO", referencedColumnName = "ID_CERTIFICADO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Certificado idCertificado;
    @Column(name = "CANTIDAD")
    private int cantidad;

    @Transient
    private double trsTotal;

    @Override
    public String toString() {
        return "Adquiere{" +
                "idAdquiere=" + idAdquiere +
                ", idColegiado=" + idColegiado +
                ", idCertificado=" + idCertificado +
                ", cantidad=" + cantidad +
                '}';
    }
}
