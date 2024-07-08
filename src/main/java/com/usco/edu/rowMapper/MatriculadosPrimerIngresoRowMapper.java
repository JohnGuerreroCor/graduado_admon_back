package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.MatriculadosPrimerIngreso;

public class MatriculadosPrimerIngresoRowMapper implements RowMapper<MatriculadosPrimerIngreso> {
	
	@Override
	public MatriculadosPrimerIngreso mapRow(ResultSet rs, int rowNum) throws SQLException {
		MatriculadosPrimerIngreso matriculadosPrimerIngreso = new MatriculadosPrimerIngreso();
		matriculadosPrimerIngreso.setPeriodoAcademico(rs.getString("per_nombre"));
		matriculadosPrimerIngreso.setCantidadEstudiantes(rs.getString("cantidad_estudiantes"));
		return matriculadosPrimerIngreso;
		
	}
}
