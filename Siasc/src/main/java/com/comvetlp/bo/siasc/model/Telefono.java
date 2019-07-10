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
@Table(name = "TELEFONO")
public class Telefono implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TELEFONO")
    private Long idTelefono;
    @Column(name = "TIPO", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTelefono tipo;
    @Column(name = "TELEFONO")
    private String telefonoa;
    @JoinColumn(name = "ID_COLEGIADO", referencedColumnName = "ID_COLEGIADO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Colegiado idColegiado;

    @Transient
    private String tipoString;

    public void toUpperCase(){

    }

    @Override
    public String toString() {
        return "Telefono{" +
                "idTelefono=" + idTelefono +
                ", tipo=" + tipo +
                ", telefonoa='" + telefonoa + '\'' +
                ", idColegiado=" + idColegiado +
                ", tipoString='" + tipoString + '\'' +
                '}';
    }
}
