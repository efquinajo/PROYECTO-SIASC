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
@Table(name = "CERTIFICADO")
public class Certificado implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CERTIFICADO")
    private Long idCertificado;
    @Column(name = "CERTIFICADO")
    private String certificadoa;
    @Column(name = "PRECIO")
    private double precio;

    @Transient
    private double trsTotal;

    public void toUpperCase(){
        this.certificadoa=this.certificadoa.toUpperCase().trim();
    }

    @Override
    public String toString() {
        return "Certificado{" +
                "idCertificado=" + idCertificado +
                ", certificado='" + certificadoa + '\'' +
                ", precio=" + precio +
                '}';
    }
}
