package com.comvetlp.bo.siasc.enums;

import lombok.Getter;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */
@Getter
public enum TipoRol {

	ADMINISTRADOR("Administrador"),
	MANAGER("Manager"),
	SOPORTE("Soporte"),
	USUARIO("Usuario");

	String descripcion;

	TipoRol(String descripcion) {
		this.descripcion = descripcion;
	}
}
