package com.comvetlp.bo.siasc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */
@Getter
@Setter
@Entity
@Table(name = "ADMINISTRA")
public class Administra extends Generic<String> implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ADMINISTRA")
    private Long idAdministra;
    @JoinColumn(name = "ID_COLEGIADO", referencedColumnName = "ID_COLEGIADO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Colegiado idColegiado;
    @JoinColumn(name = "ID_DIRECTIVA", referencedColumnName = "ID_DIRECTIVA")
    @ManyToOne(fetch = FetchType.EAGER)
    private Directiva idDirectiva;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Override
    public String toString() {
        return "Administra{" +
                "idAdministra=" + idAdministra +
                ", idColegiado=" + idColegiado +
                ", idDirectiva=" + idDirectiva +
                ", fecha=" + fecha +
                '}';
    }
}
