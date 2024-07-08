package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.EstudianteActivo;

public class EstudianteActivoRowMapper implements RowMapper<EstudianteActivo>{

	@Override
	public EstudianteActivo mapRow(ResultSet rs, int rowNum) throws SQLException {
		EstudianteActivo activo = new EstudianteActivo();
		activo.setCodigo(rs.getString("per_codigo"));
		
		return activo;
	}
}
