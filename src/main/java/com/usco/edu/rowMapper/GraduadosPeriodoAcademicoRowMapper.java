package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.GraduadosPeriodoAcademico;

public class GraduadosPeriodoAcademicoRowMapper implements RowMapper<GraduadosPeriodoAcademico> {
	
	@Override
	public GraduadosPeriodoAcademico mapRow(ResultSet rs, int rowNum) throws SQLException {
		GraduadosPeriodoAcademico graduadosPeriodoAcademico = new GraduadosPeriodoAcademico();
		graduadosPeriodoAcademico.setPeriodoAcademico(rs.getString("per_nombre"));
		graduadosPeriodoAcademico.setCantidadGraduados(rs.getString("cantidad_graduados"));
		return graduadosPeriodoAcademico;
		
	}
}
