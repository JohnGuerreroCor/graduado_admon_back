package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.ListadoEgresados;

public class ListadoEgresadosRowMapper implements RowMapper<ListadoEgresados> {
	
	@Override
	public ListadoEgresados mapRow(ResultSet rs, int rowNum) throws SQLException {
		ListadoEgresados listadoEgresados = new ListadoEgresados();
		listadoEgresados.setPeriodo(rs.getString("periodo"));
		listadoEgresados.setSede(rs.getString("sed_nombre"));
		listadoEgresados.setNivelFormacion(rs.getString("nat_nombre"));
		listadoEgresados.setNivelAcademico(rs.getString("nia_nombre"));
		listadoEgresados.setDependencia(rs.getString("dependencia"));
		listadoEgresados.setPrograma(rs.getString("uaa_nombre"));
		listadoEgresados.setEstudianteCodigo(rs.getString("est_codigo"));
		listadoEgresados.setEstudianteNombre(rs.getString("per_nombre"));
		listadoEgresados.setEstudianteApellido(rs.getString("per_apellido"));
		listadoEgresados.setPersonaIdentificacion(rs.getString("per_identificacion"));
		listadoEgresados.setMatriculaTipo(rs.getString("mti_nombre"));
		return listadoEgresados;
	}
}
