package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.CompetenciaRespuesta;
import com.usco.edu.rowMapper.CompetenciaRespuestaRowMapper;

public class CompetenciaRespuestaSetExtractor implements ResultSetExtractor<List<CompetenciaRespuesta>> {
	
	@Override
	public List<CompetenciaRespuesta> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CompetenciaRespuesta> list = new ArrayList<CompetenciaRespuesta>();
		while (rs.next()) {
			list.add(new CompetenciaRespuestaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
