package com.usco.edu.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Periodo implements Serializable  {
	
	private int codigo;
	private String nombre;
	private int anio;
	private int periodo;
	private Date inicio;
	private Date fin;
	
	private static final long serialVersionUID = 1L;
}
