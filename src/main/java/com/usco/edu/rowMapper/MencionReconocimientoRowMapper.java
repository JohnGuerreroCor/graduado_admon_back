package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.MencionReconocimiento;

public class MencionReconocimientoRowMapper implements RowMapper<MencionReconocimiento> {
	
	@Override
	public MencionReconocimiento mapRow(ResultSet rs, int rowNum) throws SQLException {
		MencionReconocimiento mencion = new MencionReconocimiento();
		mencion.setCodigo(rs.getInt("mer_codigo"));
		mencion.setPersonaCodigo(rs.getInt("per_codigo"));
		mencion.setPersonaNombre(rs.getString("per_nombre"));
		mencion.setPersonaApellido(rs.getString("per_apellido"));
		mencion.setInstitucion(rs.getString("mer_institucion"));
		mencion.setTipo(rs.getString("mer_tipo"));
		mencion.setAmbitoCodigo(rs.getInt("amb_codigo"));
		mencion.setAmbito(rs.getString("amb_nombre"));
		mencion.setTitulo(rs.getString("mer_titulo"));
		mencion.setDescripcion(rs.getString("mer_descripcion"));
		mencion.setMunicipioCodigo(rs.getInt("mun_codigo"));
		mencion.setMunicipio(rs.getString("mun_nombre"));
		mencion.setFecha(rs.getDate("mer_fecha"));
		mencion.setEstado(rs.getInt("mer_estado"));
		return mencion;
	}
}
