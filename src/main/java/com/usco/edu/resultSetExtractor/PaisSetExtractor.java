package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.Pais;
import com.usco.edu.rowMapper.PaisRowMapper;

public class PaisSetExtractor implements ResultSetExtractor<List<Pais>>{

	@Override
	public List<Pais> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Pais> list = new ArrayList<Pais>();
		while (rs.next()) {
			list.add(new PaisRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
