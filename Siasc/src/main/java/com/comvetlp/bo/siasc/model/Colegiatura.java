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
@Table(name = "COLEGIATURA")
public class Colegiatura implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COLEGIATURA")
    private Long idColegiatura;
    @Column(name = "CUOTA")
    private double cuota;
    @Column(name = "MODALIDAD")
    private String modalidad;

    public void toUpperCase(){
    this.modalidad=this.modalidad.toUpperCase().trim();
    }

    @Override
    public String toString() {
        return "Colegiatura{" +
                "idColegiatura=" + idColegiatura +
                ", cuota='" + cuota + '\'' +
                ", modalidad='" + modalidad + '\'' +
                '}';
    }
}
