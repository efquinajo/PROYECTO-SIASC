package com.comvetlp.bo.siasc.enums;

import lombok.Getter;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */
@Getter
public enum Estado {

	H("Habilitado"),
	D("Deshabilitado"),
	P("Pendiente"),
	E("Eliminado");

	String descripcion;

	Estado(String descripcion) {
		this.descripcion = descripcion;
	}
}
