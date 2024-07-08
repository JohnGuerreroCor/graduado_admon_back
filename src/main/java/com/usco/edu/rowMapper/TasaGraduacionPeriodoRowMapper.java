package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.TasaGraduacionPeriodo;

public class TasaGraduacionPeriodoRowMapper implements RowMapper<TasaGraduacionPeriodo> {
	
	@Override
	public TasaGraduacionPeriodo mapRow(ResultSet rs, int rowNum) throws SQLException {
		TasaGraduacionPeriodo tasaGraduacionPeriodo = new TasaGraduacionPeriodo();
		tasaGraduacionPeriodo.setPeriodo(rs.getString("per_nombre"));
		tasaGraduacionPeriodo.setCantidadMatriculados(rs.getString("matriculados"));
		return tasaGraduacionPeriodo;
		
	}
}
