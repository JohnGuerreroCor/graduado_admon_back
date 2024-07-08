package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.HabilidadInformatica;

public class HabilidadInformaticaRowMapper implements RowMapper<HabilidadInformatica> {
	
	@Override
	public HabilidadInformatica mapRow(ResultSet rs, int rowNum) throws SQLException {
		HabilidadInformatica habilidad = new HabilidadInformatica();
		habilidad.setCodigo(rs.getInt("hai_codigo"));
		habilidad.setPersonaCodigo(rs.getInt("per_codigo"));
		habilidad.setNombrePrograma(rs.getString("hai_nombre_programa"));
		habilidad.setDominioCodigo(rs.getInt("hid_codigo"));
		habilidad.setDominio(rs.getString("hid_nombre"));
		habilidad.setEstado(rs.getInt("hai_estado"));
		return habilidad;
	}
}
