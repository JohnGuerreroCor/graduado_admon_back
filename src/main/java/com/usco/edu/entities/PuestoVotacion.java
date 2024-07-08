package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PuestoVotacion implements Serializable {
	
	private int codigo;
	private String identificacionTipo;
	private String identificacion;
	private String apellido;
	private String nombre;
	private String sede;
	private String programa;
	private String puesto;
	
	private static final long serialVersionUID = 1L;
	
}
