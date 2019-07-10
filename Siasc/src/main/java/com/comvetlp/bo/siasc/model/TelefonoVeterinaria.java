package com.comvetlp.bo.siasc.model;

import com.comvetlp.bo.siasc.enums.TipoTelefono;
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
@Table(name = "TELEFONO_VETERINARIA")
public class TelefonoVeterinaria implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TELEFONO_VETERINARIA")
    private Long idTelefonoVeterinaria;
    @Column(name = "TIPO", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTelefono tipo;
    @Column(name = "TELEFONO")
    private String telefono;
    @JoinColumn(name = "ID_VETERINARIA", referencedColumnName = "ID_VETERINARIA")
    @ManyToOne(fetch = FetchType.EAGER)
    private Veterinaria idVeterinaria;

    public void toUpperCase(){

    }

    @Override
    public String toString() {
        return "Telefono{" +
                "idTelefonoVeterinaria=" + idTelefonoVeterinaria +
                ", tipo='" + tipo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", idVeterinaria=" + idVeterinaria +
                '}';
    }
}
