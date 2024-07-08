package com.usco.edu.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistroEducativo implements Serializable {
	
	private int codigo;
	private int personaCodigo;
	private String personaNombre;
	private String personaApellido;
	private String titulo;
	private int nivelAcademicoCodigo;
	private String nivelAcademico;
	private String institucion;
	private int municipioCodigo;
	private String municipio;
	private Date fechaFin;
	private int finalizadoCodigo;
	private int finalizado;
	private int estado;
	
	private static final long serialVersionUID = 1L;
}
