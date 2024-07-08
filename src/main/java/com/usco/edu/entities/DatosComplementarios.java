package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DatosComplementarios implements Serializable {
	
	private int codigo;
	private String estudianteCodigo;
	private String nombre;
	private String apellido;
	private String programa;
	private String modalidad;
	private String perfilProfesional;
	
	private static final long serialVersionUID = 1L;
}
