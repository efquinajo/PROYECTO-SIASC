package com.comvetlp.bo.siasc.model;

import com.comvetlp.bo.siasc.enums.TipoAcumulado;
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
@Table(name = "ACUMULADO")
public class Acumulado extends Generic<String> implements Serializable {

    private static final long serialVersionUID = 2685362649181270568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ACUMULADO")
    private Long idAcumulado;
    @Column(name = "TIPO", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoAcumulado tipo;
    @Column(name = "MONTO")
    private Long monto;
    @Column(name = "DETALLE")
    private String detalle;
    @Column(name = "FACTURA")
    private String factura;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "ID_DIRECTIVA", referencedColumnName = "ID_DIRECTIVA")
    @ManyToOne(fetch = FetchType.EAGER)
    private Directiva idDirectiva;

    public void toUpperCase(){
    this.detalle=this.detalle.toUpperCase().trim();
    this.factura=this.factura.toUpperCase().trim();
    this.observaciones=this.observaciones.toUpperCase().trim();
    }

    @Override
    public String toString() {
        return "Acumulado{" +
                "idAcumulado=" + idAcumulado +
                ", tipo='" + tipo + '\'' +
                ", monto=" + monto +
                ", detalle='" + detalle + '\'' +
                ", factura='" + factura + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", idDirectiva=" + idDirectiva +
                '}';
    }
}
