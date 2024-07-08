package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MatriculadosPrimerIngreso implements Serializable  {
	
	private String periodoAcademico;
	private String cantidadEstudiantes;
	
	private static final long serialVersionUID = 1L;
}
