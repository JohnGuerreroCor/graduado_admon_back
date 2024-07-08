package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.SoporteExpedicion;

public class SoporteExpedicionRowMapper implements RowMapper<SoporteExpedicion>{

	@Override
	public SoporteExpedicion mapRow(ResultSet rs, int rowNum) throws SQLException {
		SoporteExpedicion soporte = new SoporteExpedicion();
		soporte.setCodigo(rs.getInt("sfe_codigo"));
		soporte.setPerCodigo(rs.getInt("per_codigo"));
		soporte.setNombre(rs.getString("sfe_nombre"));
		soporte.setRuta(rs.getString("sfe_ruta_archivo"));
		soporte.setFechaCreacion(rs.getDate("sde_fecha_creacion"));
		soporte.setEstado(rs.getInt("sfe_estado"));
		return soporte;
	}
}
