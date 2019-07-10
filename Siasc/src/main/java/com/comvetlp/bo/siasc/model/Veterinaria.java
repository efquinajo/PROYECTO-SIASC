package com.comvetlp.bo.siasc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */
@Getter
@Setter
@Entity
@Table(name = "VETERINARIA")
public class Veterinaria implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VETERINARIA")
    private Long idVeterinaria;
    @Column(name = "VETERINARIA")
    private String veterinariaa;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ZONA")
    private String zona;
    @Column(name = "DIRECCION")
    private String direccion;
    @JoinColumn(name = "ID_COLEGIADO", referencedColumnName = "ID_COLEGIADO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Colegiado idColegiado;

    @Transient
    private List<TelefonoVeterinaria> trsListTelefonoVeterinaria;

    public void toUpperCase(){
        this.veterinariaa=this.veterinariaa.toUpperCase().trim();
        this.zona=this.zona.toUpperCase().trim();
        this.descripcion=this.descripcion.toUpperCase().trim();
        this.direccion=this.direccion.toUpperCase().trim();
    }

    @Override
    public String toString() {
        return "Veterinaria{" +
                "idVeterinaria=" + idVeterinaria +
                ", veterinaria='" + veterinariaa + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", zona='" + zona + '\'' +
                ", direccion='" + direccion + '\'' +
                ", idColegiado=" + idColegiado +
                '}';
    }
}
