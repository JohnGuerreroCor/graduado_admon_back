package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Pais;

public class PaisRowMapper implements RowMapper<Pais> {
	
	@Override
	public Pais mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pais pais = new Pais();
		pais.setCodigo(rs.getInt("pai_codigo"));
		pais.setNombre(rs.getString("pai_nombre"));
		pais.setAcronimo(rs.getString("pai_acronimo"));
		return pais;
	}
}
