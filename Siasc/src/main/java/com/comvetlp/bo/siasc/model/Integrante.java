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
@Table(name = "INTEGRANTE")
public class Integrante extends Generic<String> implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INTEGRANTE")
    private Long idIntegrante;
    @Column(name = "INTEGRANTE")
    private String integrantea;
    @Column(name = "CARGO")
    private String cargo;
    @JoinColumn(name = "ID_DIRECTIVA", referencedColumnName = "ID_DIRECTIVA")
    @ManyToOne(fetch = FetchType.EAGER)
    private Directiva idDirectiva;
    @JoinColumn(name = "ID_COLEGIADO", referencedColumnName = "ID_COLEGIADO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Colegiado idColegiado;

    public void toUpperCase(){
    this.integrantea=this.integrantea.toUpperCase().trim();
    this.cargo=this.cargo.toUpperCase().trim();
    }

    @Override
    public String toString() {
        return "Integrante{" +
                "idIntegrante=" + idIntegrante +
                ", integrantea='" + integrantea + '\'' +
                ", cargo='" + cargo + '\'' +
                ", idDirectiva=" + idDirectiva +
                ", idColegiado=" + idColegiado +
                '}';
    }
}
