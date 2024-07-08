package com.usco.edu.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MencionReconocimiento implements Serializable {
	
	private int codigo;
	private int personaCodigo;
	private String personaNombre;
	private String personaApellido;
	private String institucion;
	private String tipo;
	private int ambitoCodigo;
	private String ambito;
	private String titulo;
	private String descripcion;
	private int municipioCodigo;
	private String municipio;
	private Date fecha;
	private int estado;
	
	private static final long serialVersionUID = 1L;
}
