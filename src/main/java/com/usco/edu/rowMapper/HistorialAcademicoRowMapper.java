package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.HistorialAcademico;

public class HistorialAcademicoRowMapper implements RowMapper<HistorialAcademico> {
	
	@Override
	public HistorialAcademico mapRow(ResultSet rs, int rowNum) throws SQLException {
		HistorialAcademico historialAcademico = new HistorialAcademico();
		historialAcademico.setCodigo(rs.getInt("hia_codigo"));
		historialAcademico.setPerCodigo(rs.getInt("per_codigo"));
		historialAcademico.setPersonaNombre(rs.getString("per_nombre"));
		historialAcademico.setPersonaApellido(rs.getString("per_apellido"));
		historialAcademico.setTitulo(rs.getString("hia_titulo"));
		historialAcademico.setNivelAcademicoCodigo(rs.getInt("nia_codigo"));
		historialAcademico.setNivelAcademico(rs.getString("nia_nombre"));
		historialAcademico.setInstitucion(rs.getString("hia_institucion"));
		historialAcademico.setPaisCodigo(rs.getInt("pai_codigo"));
		historialAcademico.setPais(rs.getString("pai_nombre"));
		historialAcademico.setDepartamentoCodigo(rs.getInt("dep_codigo"));
		historialAcademico.setDepartamento(rs.getString("dep_nombre"));
		historialAcademico.setMunicipioCodigo(rs.getInt("mun_codigo"));
		historialAcademico.setMunicipio(rs.getString("mun_nombre"));
		historialAcademico.setFinalizado(rs.getInt("hia_finalizado"));
		historialAcademico.setFechaInicio(rs.getDate("hia_fecha_inicio"));
		historialAcademico.setFechaFin(rs.getDate("hia_fecha_fin"));
		historialAcademico.setEstado(rs.getInt("hia_estado"));
		return historialAcademico;
	}
}
