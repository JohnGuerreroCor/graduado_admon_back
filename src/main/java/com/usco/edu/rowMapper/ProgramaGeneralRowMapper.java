package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.ProgramaGeneral;

public class ProgramaGeneralRowMapper implements RowMapper<ProgramaGeneral> {
	
	@Override
	public ProgramaGeneral mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProgramaGeneral programa = new ProgramaGeneral();
		programa.setCodigo(rs.getInt("pro_codigo"));
		programa.setNombre(rs.getString("uaa_nombre"));
		programa.setNombreCorto(rs.getString("uaa_nombre_corto"));
		programa.setDependenciaCodigo(rs.getInt("uaa_dependencia"));
		programa.setDependencia(rs.getString("facultad"));
		programa.setSede(rs.getString("sed_nombre"));
		programa.setSedeCodigo(rs.getInt("sed_codigo"));
		return programa;
	}
}
