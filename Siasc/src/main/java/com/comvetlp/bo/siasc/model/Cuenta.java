package com.comvetlp.bo.siasc.model;

import com.comvetlp.bo.siasc.enums.TipoRol;
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
@Table(name = "CUENTA")
public class Cuenta extends Generic<String> implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CUENTA")
    private Long idCuenta;
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ROL", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoRol rol;
    @JoinColumn(name = "ID_COLEGIADO", referencedColumnName = "ID_COLEGIADO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Colegiado idColegiado;

    public void toUpperCase(){

    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "idCuenta=" + idCuenta +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                ", idColegiado=" + idColegiado +
                '}';
    }
}
