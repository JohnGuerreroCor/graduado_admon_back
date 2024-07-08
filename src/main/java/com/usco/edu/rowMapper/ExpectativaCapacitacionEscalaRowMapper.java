package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.ExpectativaCapacitacionEscala;

public class ExpectativaCapacitacionEscalaRowMapper implements RowMapper<ExpectativaCapacitacionEscala> {
	
	@Override
	public ExpectativaCapacitacionEscala mapRow(ResultSet rs, int rowNum) throws SQLException {
		ExpectativaCapacitacionEscala escala = new ExpectativaCapacitacionEscala();
		escala.setCodigo(rs.getInt("ece_codigo"));
		escala.setPreguntaCodigo(rs.getInt("ecp_codigo"));
		escala.setRespuesta(rs.getString("ece_respuesta"));
		escala.setEstado(rs.getInt("ece_estado"));
		return escala;
	}
}
