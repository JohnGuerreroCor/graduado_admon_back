package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.Facultad;
import com.usco.edu.rowMapper.FacultadRowMapper;

public class FacultadSetExtractor implements ResultSetExtractor<List<Facultad>> {
	
	@Override
	public List<Facultad> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Facultad> list = new ArrayList<Facultad>();
		while (rs.next()) {
			list.add(new FacultadRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
