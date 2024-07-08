package com.usco.edu.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SituacionLaboralRespuesta implements Serializable {
	
	private int codigo;
	private int personaCodigo;
	private int preguntaCodigo;
	private String pregunta;
	private int respuestaCodigo;
	private String respuesta;
	private Date fechaRespuesta;
	
	private static final long serialVersionUID = 1L;
	
}
