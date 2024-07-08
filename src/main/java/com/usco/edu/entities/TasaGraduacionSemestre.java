package com.usco.edu.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TasaGraduacionSemestre implements Serializable  {
	
	private String programaNombre;
	private String nivelAcademico;
	private String nivelFormacion;
	private Date programaFechaCreacion;
	private int programaSemestres;
	private int programPlanAcademico;
	
	private static final long serialVersionUID = 1L;
}
