package com.usco.edu.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReporteExpectativaCapacitacion implements Serializable {
	
	private int personaCodigo;
	
	private String personaNombre;
	
	private String personaApellido;
	
	private Date fecha;
	
	private Map<String, String> columnas;

	private static final long serialVersionUID = 1L;
}
