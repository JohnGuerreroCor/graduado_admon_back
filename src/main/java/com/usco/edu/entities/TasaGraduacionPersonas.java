package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TasaGraduacionPersonas implements Serializable  {
	
	private String periodo;
	private String estudianteCodigo;
	
	private static final long serialVersionUID = 1L;
}
