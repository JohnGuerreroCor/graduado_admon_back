package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.CompetenciaRespuesta;

public class CompetenciaRespuestaRowMapper implements RowMapper<CompetenciaRespuesta> {
	
	@Override
	public CompetenciaRespuesta mapRow(ResultSet rs, int rowNum) throws SQLException {
		CompetenciaRespuesta respuesta = new CompetenciaRespuesta();
		respuesta.setCodigo(rs.getInt("cor_codigo"));
		respuesta.setPersonaCodigo(rs.getInt("per_codigo"));
		respuesta.setPreguntaCodigo(rs.getInt("cop_codigo"));
		respuesta.setPregunta(rs.getString("cop_nombre"));
		respuesta.setRespuestaCodigo(rs.getInt("coe_codigo"));
		respuesta.setRespuesta(rs.getString("coe_nombre"));
		respuesta.setFechaRespuesta(rs.getDate("cor_fecha"));
		return respuesta;
	}
}
