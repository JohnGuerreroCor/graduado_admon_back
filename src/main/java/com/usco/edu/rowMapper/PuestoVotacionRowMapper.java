package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.PuestoVotacion;

public class PuestoVotacionRowMapper implements RowMapper<PuestoVotacion> {
	
	@Override
	public PuestoVotacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		PuestoVotacion puestoVotacion = new PuestoVotacion();
		puestoVotacion.setCodigo(rs.getInt("per_codigo"));
		puestoVotacion.setIdentificacionTipo(rs.getString("tii_nombre_corto"));
		puestoVotacion.setIdentificacion(rs.getString("per_identificacion"));
		puestoVotacion.setApellido(rs.getString("per_apellido"));
		puestoVotacion.setNombre(rs.getString("per_nombre"));
		puestoVotacion.setPrograma(rs.getString("uaa_nombre"));
		puestoVotacion.setSede(rs.getString("sed_nombre"));
		puestoVotacion.setPuesto(rs.getString("vop_nombre"));
		return puestoVotacion;
	}
}
