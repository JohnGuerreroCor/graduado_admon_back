package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GraduadosPeriodoAcademico implements Serializable  {
	
	private String periodoAcademico;
	private String cantidadGraduados;
	
	private static final long serialVersionUID = 1L;
}
