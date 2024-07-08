package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListadoEgresados implements Serializable {
	
	private String periodo;
	private String sede;
	private String nivelFormacion;
	private String nivelAcademico;
	private String dependencia;
	private String programa;
	private String estudianteCodigo;
	private String estudianteNombre;
	private String estudianteApellido;
	private String personaIdentificacion;
	private String matriculaTipo;
	
	private static final long serialVersionUID = 1L;
}
