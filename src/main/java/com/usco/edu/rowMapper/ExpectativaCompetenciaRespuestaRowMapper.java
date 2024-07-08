package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.ExpectativaCompetenciaRespuesta;

public class ExpectativaCompetenciaRespuestaRowMapper implements RowMapper<ExpectativaCompetenciaRespuesta> {
	
	@Override
	public ExpectativaCompetenciaRespuesta mapRow(ResultSet rs, int rowNum) throws SQLException {
		ExpectativaCompetenciaRespuesta respuesta = new ExpectativaCompetenciaRespuesta();
		respuesta.setCodigo(rs.getInt("ecr_codigo"));
		respuesta.setPersonaCodigo(rs.getInt("per_codigo"));
		respuesta.setPreguntaCodigo(rs.getInt("ecp_codigo"));
		respuesta.setPregunta(rs.getString("ecp_nombre"));
		respuesta.setRespuestaCodigo(rs.getInt("ece_codigo"));
		respuesta.setRespuesta(rs.getString("ece_respuesta"));
		respuesta.setFechaRespuesta(rs.getDate("ecr_fecha"));
		return respuesta;
	}
}
