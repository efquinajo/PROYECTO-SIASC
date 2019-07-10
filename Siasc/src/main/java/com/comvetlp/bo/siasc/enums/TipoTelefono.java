package com.comvetlp.bo.siasc.enums;

import lombok.Getter;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */
@Getter
public enum TipoTelefono {

	CELULAR("Celular"),
	TELEFONO("Telefono");

	String descripcion;

	TipoTelefono(String descripcion) {
		this.descripcion = descripcion;
	}
}
