package com.comvetlp.bo.siasc.enums;

import lombok.Getter;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */
@Getter
public enum EstadoColegiado {

	ACTIVO("Activo"),
	PASIVO("Pasivo"),
	INSCRITO("Inscrito");

	String descripcion;

	EstadoColegiado(String descripcion) {
		this.descripcion = descripcion;
	}
}
