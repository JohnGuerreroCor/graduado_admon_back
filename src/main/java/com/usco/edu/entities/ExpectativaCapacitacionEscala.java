package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExpectativaCapacitacionEscala implements Serializable {
	
	private int codigo;
	private int preguntaCodigo;
	private String respuesta;
	private int estado;
	
	private static final long serialVersionUID = 1L;
}
