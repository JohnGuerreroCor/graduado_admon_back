package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EstudianteActivo implements Serializable {
	
	private String codigo;
	
	private static final long serialVersionUID = 1L;
}
