package com.comvetlp.bo.siasc.enums;

import lombok.Getter;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */
@Getter
public enum TipoEstudio {

	MAESTRIA("Maestria"),
	DIPLOMADO("Diplomado"),
	POSGRADO("Posgrado"),
	TITULO("Titulo"),
	ESPECIALIDAD("Especialidad");

	String descripcion;

	TipoEstudio(String descripcion) {
		this.descripcion = descripcion;
	}
}
