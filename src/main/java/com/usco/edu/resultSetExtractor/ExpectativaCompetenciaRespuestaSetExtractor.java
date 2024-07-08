package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.ExpectativaCompetenciaRespuesta;
import com.usco.edu.rowMapper.ExpectativaCompetenciaRespuestaRowMapper;

public class ExpectativaCompetenciaRespuestaSetExtractor implements ResultSetExtractor<List<ExpectativaCompetenciaRespuesta>> {
	
	@Override
	public List<ExpectativaCompetenciaRespuesta> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<ExpectativaCompetenciaRespuesta> list = new ArrayList<ExpectativaCompetenciaRespuesta>();
		while (rs.next()) {
			list.add(new ExpectativaCompetenciaRespuestaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
