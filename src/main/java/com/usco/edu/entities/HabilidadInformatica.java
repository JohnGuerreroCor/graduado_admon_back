package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HabilidadInformatica implements Serializable {
	
	private int codigo;
	private int personaCodigo;
	private String personaNombre;
	private String personaApellido;
	private String nombrePrograma;
	private int dominioCodigo;
	private String dominio;
	private int estado;
	
	private static final long serialVersionUID = 1L;
}
