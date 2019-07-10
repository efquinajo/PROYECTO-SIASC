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
@Table(name = "HABLA")
public class Habla implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HABLA")
    private Long idHabla;
    @JoinColumn(name = "ID_COLEGIADO", referencedColumnName = "ID_COLEGIADO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Colegiado idColegiado;
    @JoinColumn(name = "ID_IDIOMA", referencedColumnName = "ID_IDIOMA")
    @ManyToOne(fetch = FetchType.EAGER)
    private Idioma idIdioma;

    @Override
    public String toString() {
        return "Habla{" +
                "idHabla=" + idHabla +
                ", idColegiado=" + idColegiado +
                ", idIdioma=" + idIdioma +
                '}';
    }
}
