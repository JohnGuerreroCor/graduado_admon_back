package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.PersonaCarnet;

public class PersonaCarnetRowMapper implements RowMapper<PersonaCarnet> {
	
	@Override
	public PersonaCarnet mapRow(ResultSet rs, int rowNum) throws SQLException {
		PersonaCarnet persona = new PersonaCarnet();
		persona.setCodigo(rs.getInt("per_codigo"));
		persona.setTipoDocumento(rs.getInt("tii_codigo"));
		persona.setTipoDocumentoAcronimo(rs.getString("snies_codigo"));
		persona.setFechaExpedicionDocumento(rs.getDate("per_fecha_expedicion"));
		persona.setLugarExpedicion(rs.getString("mun_nombre"));
		persona.setDocumento(rs.getString("tii_nombre"));
		persona.setIdentificacion(rs.getString("per_identificacion"));
		persona.setGrupoSanguineo(rs.getString("grs_nombre"));
		persona.setGenero(rs.getString("per_genero"));
		persona.setFechaNacimiento(rs.getDate("per_fecha_nacimiento"));
		persona.setNombre(rs.getString("per_nombre"));
		persona.setApellido(rs.getString("per_apellido"));
		persona.setEmailPersonal(rs.getString("per_email"));
		persona.setEmailInterno(rs.getString("per_email_interno"));
		persona.setTelefonoFijo(rs.getString("per_telefono_fijo"));
		persona.setTelefonoMovil(rs.getString("per_telefono_movil"));
		return persona;
	}

}