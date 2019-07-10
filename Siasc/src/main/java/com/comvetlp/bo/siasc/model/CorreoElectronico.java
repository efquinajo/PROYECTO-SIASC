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
@Table(name = "CORREO_ELECTRONICO")
public class CorreoElectronico implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CORREO_ELECTRONICO")
    private Long idCorreoElectronico;
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronicoa;
    @JoinColumn(name = "ID_COLEGIADO", referencedColumnName = "ID_COLEGIADO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Colegiado idColegiado;

    public void toLowerCase() {
    this.correoElectronicoa=correoElectronicoa.toLowerCase().trim();
    }

    @Override
    public String toString() {
        return "CorreoElectronico{" +
                "idCorreoElectronico=" + idCorreoElectronico +
                ", correoElectronico='" + correoElectronicoa + '\'' +
                ", idColegiado=" + idColegiado +
                '}';
    }
}
