package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.SituacionLaboralRespuesta;
import com.usco.edu.rowMapper.SituacionLaboralRespuestaRowMapper;

public class SituacionLaboralRespuestaSetExtractor implements ResultSetExtractor<List<SituacionLaboralRespuesta>> {
	
	@Override
	public List<SituacionLaboralRespuesta> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<SituacionLaboralRespuesta> list = new ArrayList<SituacionLaboralRespuesta>();
		while (rs.next()) {
			list.add(new SituacionLaboralRespuestaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
		
	}
	
}
