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
@Table(name = "IDIOMA")
public class Idioma implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_IDIOMA")
    private Long idIdioma;
    @Column(name = "IDIOMA")
    private String idiomaa;

    @Override
    public String toString() {
        return "Idioma{" +
                "idIdioma=" + idIdioma +
                ", idioma='" + idiomaa + '\'' +
                '}';
    }
}
