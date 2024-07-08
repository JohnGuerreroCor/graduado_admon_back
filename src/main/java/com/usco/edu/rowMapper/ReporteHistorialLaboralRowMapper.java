package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.HistorialLaboral;

public class ReporteHistorialLaboralRowMapper implements RowMapper<HistorialLaboral> {
	
	@Override
	public HistorialLaboral mapRow(ResultSet rs, int rowNum) throws SQLException {
		HistorialLaboral historialLaboral = new HistorialLaboral();
		historialLaboral.setCodigo(rs.getInt("hil_codigo"));
		historialLaboral.setPersonaCodigo(rs.getInt("per_codigo"));
		historialLaboral.setCargo(rs.getString("hil_cargo"));
		historialLaboral.setNombre(rs.getString("per_nombre"));
		historialLaboral.setApellido(rs.getString("per_apellido"));
		historialLaboral.setFuncion(rs.getString("hil_funcion"));
		historialLaboral.setEmpresa(rs.getString("hil_empresa"));
		historialLaboral.setFechaInicio(rs.getDate("hil_fecha_inicio"));
		historialLaboral.setFechaFin(rs.getDate("hil_fecha_fin"));
		historialLaboral.setEstado(rs.getInt("hil_estado"));
		return historialLaboral;
	}
}
