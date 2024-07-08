package com.usco.edu.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SoporteExpedicion implements Serializable {
	
	private int codigo;
	private int perCodigo;
	private String nombre;
	private String ruta;
	private Date fechaCreacion;
	private int estado;
	
	private static final long serialVersionUID = 1L;
}
