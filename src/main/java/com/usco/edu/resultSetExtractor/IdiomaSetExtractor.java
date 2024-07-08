package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.Idioma;
import com.usco.edu.rowMapper.IdiomaRowMapper;

public class IdiomaSetExtractor implements ResultSetExtractor<List<Idioma>> {
	
	@Override
	public List<Idioma> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Idioma> list = new ArrayList<Idioma>();
		while (rs.next()) {
			list.add(new IdiomaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
