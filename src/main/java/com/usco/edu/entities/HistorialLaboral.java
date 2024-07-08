package com.usco.edu.entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HistorialLaboral {
	
	private int codigo;
	private int personaCodigo;
	private String nombre;
	private String apellido;
	private String cargo;
	private String funcion;
	private String empresa;
	private Date fechaInicio;
	private Date fechaFin;
	private int estado;

}
