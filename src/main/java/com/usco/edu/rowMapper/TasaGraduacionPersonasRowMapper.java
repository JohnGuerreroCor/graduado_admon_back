package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.TasaGraduacionPersonas;

public class TasaGraduacionPersonasRowMapper implements RowMapper<TasaGraduacionPersonas> {
	
	@Override
	public TasaGraduacionPersonas mapRow(ResultSet rs, int rowNum) throws SQLException {
		TasaGraduacionPersonas tasaGraduacionPersonas = new TasaGraduacionPersonas();
		tasaGraduacionPersonas.setPeriodo(rs.getString("per_nombre"));
		tasaGraduacionPersonas.setEstudianteCodigo(rs.getString("est_codigo"));
		return tasaGraduacionPersonas;
		
	}
}
