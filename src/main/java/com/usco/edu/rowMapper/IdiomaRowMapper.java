package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Idioma;

public class IdiomaRowMapper implements RowMapper<Idioma> {
	
	@Override
	public Idioma mapRow(ResultSet rs, int rowNum) throws SQLException {
		Idioma idioma = new Idioma();
		idioma.setCodigo(rs.getInt("idi_codigo"));
		idioma.setPersonaCodigo(rs.getInt("per_codigo"));
		idioma.setNombre(rs.getString("idi_idioma"));
		idioma.setConversacionCodigo(rs.getInt("conversacionCodigo"));
		idioma.setConversacion(rs.getString("conversacion"));
		idioma.setEscrituraCodigo(rs.getInt("escrituraCodigo"));
		idioma.setEscritura(rs.getString("escritura"));
		idioma.setLecturaCodigo(rs.getInt("lecturaCodigo"));
		idioma.setLectura(rs.getString("lectura"));
		idioma.setEstado(rs.getInt("idi_estado"));
		
		return idioma;
		
	}
}
