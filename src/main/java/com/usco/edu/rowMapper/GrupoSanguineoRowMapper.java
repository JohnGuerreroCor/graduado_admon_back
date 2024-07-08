package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.GrupoSanguineo;

public class GrupoSanguineoRowMapper implements RowMapper<GrupoSanguineo> {
	
	@Override
	public GrupoSanguineo mapRow(ResultSet rs, int rowNum) throws SQLException {
		GrupoSanguineo grupoSanguineo = new GrupoSanguineo();
		grupoSanguineo.setCodigo(rs.getInt("grs_codigo"));
		grupoSanguineo.setNombre(rs.getString("grs_nombre"));
		return grupoSanguineo;
	}
}
