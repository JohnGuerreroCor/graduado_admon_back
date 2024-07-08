package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.ExpectativaCapacitacionEscala;
import com.usco.edu.rowMapper.ExpectativaCapacitacionEscalaRowMapper;

public class ExpectativaCapacitacionEscalaSetExtractor implements ResultSetExtractor<List<ExpectativaCapacitacionEscala>> {
	
	@Override
	public List<ExpectativaCapacitacionEscala> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<ExpectativaCapacitacionEscala> list = new ArrayList<ExpectativaCapacitacionEscala>();
		while (rs.next()) {
			list.add(new ExpectativaCapacitacionEscalaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
