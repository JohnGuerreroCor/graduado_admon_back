package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Idioma implements Serializable {
	
	private int codigo;
	private int personaCodigo;
	private String personaNombre;
	private String personaApellido;
	private String nombre;
	private int conversacionCodigo;
	private String conversacion;
	private int escrituraCodigo;
	private String escritura;
	private int lecturaCodigo;
	private String lectura;
	private int estado;
	
	private static final long serialVersionUID = 1L;
}
