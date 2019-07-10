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
@Table(name = "DIRECTIVA")
public class Directiva extends Generic<String> implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIRECTIVA")
    private Long idDirectiva;
    @Column(name = "GESTION")
    private String gestion;
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public void toUpperCase(){
    this.descripcion=this.descripcion.toUpperCase().trim();
    }

    @Override
    public String toString() {
        return "Directiva{" +
                "idDirectiva=" + idDirectiva +
                ", gestion='" + gestion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
