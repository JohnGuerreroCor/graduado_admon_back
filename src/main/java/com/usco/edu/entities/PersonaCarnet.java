package com.usco.edu.entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaCarnet{
	
	private int codigo;
	private int tipoDocumento;
	private String tipoDocumentoAcronimo;
	private String documento;
	private String lugarExpedicion;
	private String identificacion;
	private String grupoSanguineo;
	private String genero;
	private Date fechaExpedicionDocumento;
	private Date fechaNacimiento;
	private String nombre;
	private String apellido;
	private String emailPersonal;
	private String emailInterno;
	private String telefonoFijo;
	private String telefonoMovil;

}
