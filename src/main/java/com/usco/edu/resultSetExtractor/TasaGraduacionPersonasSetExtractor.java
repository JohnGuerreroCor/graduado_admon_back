package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.TasaGraduacionPersonas;
import com.usco.edu.rowMapper.TasaGraduacionPersonasRowMapper;

public class TasaGraduacionPersonasSetExtractor implements ResultSetExtractor<List<TasaGraduacionPersonas>> {
	
	@Override
	public List<TasaGraduacionPersonas> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<TasaGraduacionPersonas> list = new ArrayList<TasaGraduacionPersonas>();
		while (rs.next()) {
			list.add(new TasaGraduacionPersonasRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
		
	}
}
