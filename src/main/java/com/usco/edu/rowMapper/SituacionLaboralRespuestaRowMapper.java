package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.SituacionLaboralRespuesta;

public class SituacionLaboralRespuestaRowMapper implements RowMapper<SituacionLaboralRespuesta> {
	
	@Override
	public SituacionLaboralRespuesta mapRow(ResultSet rs, int rowNum) throws SQLException {
		SituacionLaboralRespuesta respuesta = new SituacionLaboralRespuesta();
		respuesta.setCodigo(rs.getInt("slr_codigo"));
		respuesta.setPersonaCodigo(rs.getInt("per_codigo"));
		respuesta.setPreguntaCodigo(rs.getInt("slp_codigo"));
		respuesta.setPregunta(rs.getString("slp_nombre"));
		respuesta.setRespuestaCodigo(rs.getInt("sle_codigo"));
		respuesta.setRespuesta(rs.getString("sle_respuesta"));
		respuesta.setFechaRespuesta(rs.getDate("slr_fecha"));
		return respuesta;
	}
}
