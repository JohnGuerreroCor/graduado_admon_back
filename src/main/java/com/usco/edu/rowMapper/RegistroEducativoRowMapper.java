package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.RegistroEducativo;

public class RegistroEducativoRowMapper implements RowMapper<RegistroEducativo> {
	
	@Override
	public RegistroEducativo mapRow(ResultSet rs, int rowNum) throws SQLException {
		RegistroEducativo registroEducativo = new RegistroEducativo();
		registroEducativo.setCodigo(rs.getInt("ree_codigo"));
		registroEducativo.setPersonaCodigo(rs.getInt("per_codigo"));
		registroEducativo.setTitulo(rs.getString("ree_titulo"));
		registroEducativo.setNivelAcademicoCodigo(rs.getInt("nia_codigo"));;
		registroEducativo.setNivelAcademico(rs.getString("nia_nombre"));
		registroEducativo.setMunicipioCodigo(rs.getInt("mun_codigo"));
		registroEducativo.setMunicipio(rs.getString("mun_nombre"));
		registroEducativo.setInstitucion(rs.getString("ree_institucion"));
		registroEducativo.setFechaFin(rs.getDate("ree_fecha_fin"));
		registroEducativo.setFinalizado(rs.getInt("ree_finalizado"));
		registroEducativo.setEstado(rs.getInt("ree_estado"));
		return registroEducativo;
		
	}
}
