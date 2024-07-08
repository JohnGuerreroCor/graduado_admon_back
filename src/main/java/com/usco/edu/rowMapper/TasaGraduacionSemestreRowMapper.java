package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.TasaGraduacionSemestre;

public class TasaGraduacionSemestreRowMapper implements RowMapper<TasaGraduacionSemestre> {
	
	@Override
	public TasaGraduacionSemestre mapRow(ResultSet rs, int rowNum) throws SQLException {
		TasaGraduacionSemestre tasaGraduacionSemestre = new TasaGraduacionSemestre();
		tasaGraduacionSemestre.setProgramaNombre(rs.getString("uaa_nombre_corto"));
		tasaGraduacionSemestre.setNivelAcademico(rs.getString("nat_nombre"));
		tasaGraduacionSemestre.setNivelFormacion(rs.getString("nia_nombre"));
		tasaGraduacionSemestre.setProgramaFechaCreacion(rs.getDate("pro_fecha_creacion"));
		tasaGraduacionSemestre.setProgramaSemestres(rs.getInt("paa_semestre"));
		tasaGraduacionSemestre.setProgramPlanAcademico(rs.getInt("pla_codigo"));
		return tasaGraduacionSemestre;
		
	}
}
