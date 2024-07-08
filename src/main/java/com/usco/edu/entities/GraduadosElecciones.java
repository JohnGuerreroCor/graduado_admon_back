package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GraduadosElecciones implements Serializable  {
	
	private String sede;
	private String facultad;
	private String nivelAcademico;
	private String nivelFormacion;
	private String programa;
	private String tipoIdentificacion;
	private String identificacion;
	
	private static final long serialVersionUID = 1L;
}
