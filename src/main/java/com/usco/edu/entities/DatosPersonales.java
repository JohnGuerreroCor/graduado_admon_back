package com.usco.edu.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DatosPersonales implements Serializable {
	
	private int codigo;
	private int identificacionTipoCodigo;
	private String identificacionTipo;
	private String identificacion;
	private int paisExpedicionCodigo;
	private String paisExpedicion;
	private int departamentoExpedicionCodigo;
	private String departamentoExpedicion;
	private int municipioExpedicionCodigo;
	private String municipioExpedicion;
	private Date identificacionFechaExpedicion;
	private String urlAnexoExpedicion;
	private String apellido;
	private String nombre;
	private String genero;
	private int estadoCivilCodigo;
	private String estadoCivil;
	private int grupoSanguineoCodigo;
	private String grupoSanguineo;
	private Date fechaNacimiento;
	private int paisNacimientoCodigo;
	private String paisNacimiento;
	private int departamentoNacimientoCodigo;
	private String departamentoNacimiento;
	private int municipioNacimientoCodigo;
	private String municipioNacimiento;
	private String emailPersonal;
	private String paginaWeb;
	private String telefonoFijo;
	private String telefonoMovil;
	private int paisResidenciaCodigo;
	private String paisResidencia;
	private int departamentoResidenciaCodigo;
	private String departamentoResidencia;
	private int municipioResidenciaCodigo;
	private String municipioResidencia;
	private String barrio;
	private String direccion;
	
	private static final long serialVersionUID = 1L;
	
}
