package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Departamento implements Serializable {
	
	private int codigo;
	private String nombre;
	private String acronimo;
	private Pais pais;
	
	private static final long serialVersionUID = 1L;
	
}
