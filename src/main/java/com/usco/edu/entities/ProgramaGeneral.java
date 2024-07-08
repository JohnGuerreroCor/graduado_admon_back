package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProgramaGeneral implements Serializable {
	
	private int codigo;
	private String nombre;
	private String nombreCorto;
	private int dependenciaCodigo;
	private String dependencia;
	private int sedeCodigo;
	private String sede;
	
	private static final long serialVersionUID = 1L;
}
