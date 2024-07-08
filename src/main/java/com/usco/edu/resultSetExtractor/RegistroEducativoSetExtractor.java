package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.RegistroEducativo;
import com.usco.edu.rowMapper.RegistroEducativoRowMapper;

public class RegistroEducativoSetExtractor implements ResultSetExtractor<List<RegistroEducativo>> {
	
	@Override
	public List<RegistroEducativo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<RegistroEducativo> list = new ArrayList<RegistroEducativo>();
		while (rs.next()) {
			list.add(new RegistroEducativoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
