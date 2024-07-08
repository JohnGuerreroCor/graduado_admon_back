package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.GraduadosElecciones;

public class GraduadosEleccionesRowMapper implements RowMapper<GraduadosElecciones> {
	
	@Override
	public GraduadosElecciones mapRow(ResultSet rs, int rowNum) throws SQLException {
		GraduadosElecciones graduadosElecciones = new GraduadosElecciones();
		graduadosElecciones.setSede(rs.getString("sed_nombre"));
		graduadosElecciones.setFacultad(rs.getString("facultad"));
		graduadosElecciones.setNivelAcademico(rs.getString("nat_nombre"));
		graduadosElecciones.setNivelFormacion(rs.getString("nia_nombre"));
		graduadosElecciones.setPrograma(rs.getString("programa"));
		graduadosElecciones.setTipoIdentificacion(rs.getString("tii_nombre_corto"));
		graduadosElecciones.setIdentificacion(rs.getString("per_identificacion"));
		return graduadosElecciones;
	}
}
