package com.comvetlp.bo.siasc.model;

import com.comvetlp.bo.siasc.enums.Estado;
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
@SuppressWarnings({ "rawtypes" })
@MappedSuperclass
@Getter
@Setter
public abstract class Generic< ID extends Serializable> implements Serializable, Comparable<Generic> {
    private static final long serialVersionUID = -4531912599739667627L;

    @Column(name = "ESTADO" , nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Column(name = "FECHA_ALTA" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "USUARIO_ALTA", nullable = false)
    private String usuarioAlta;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;
    @Column(name = "FECHA_BAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;
    @Column(name = "USUARIO_BAJA")
    private String usuarioBaja;

    public Generic(){
    }

    @Override
    public int compareTo(Generic other)
    {
        return 0;
    }

}
