package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Facultad;

public class FacultadRowMapper implements RowMapper<Facultad> {
	
	@Override
	public Facultad mapRow(ResultSet rs, int rowNum) throws SQLException {
		Facultad facultad = new Facultad();
		facultad.setCodigo(rs.getInt("uaa_codigo"));
		facultad.setNombre(rs.getString("uaa_nombre"));
		return facultad;
		
	}
}
