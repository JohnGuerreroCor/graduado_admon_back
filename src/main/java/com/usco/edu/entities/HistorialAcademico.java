package com.usco.edu.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HistorialAcademico implements Serializable {
	
	private int codigo;
	private int perCodigo;
	private String personaNombre;
	private String personaApellido;
	private String titulo;
	private int nivelAcademicoCodigo;
	private String nivelAcademico;
	private String institucion;
	private int paisCodigo;
	private String pais;
	private int departamentoCodigo;
	private String departamento;
	private int municipioCodigo;
	private String municipio;
	private int finalizado;
	private Date fechaInicio;
	private Date fechaFin;
	private int estado;
	
	private static final long serialVersionUID = 1L;
	
}
