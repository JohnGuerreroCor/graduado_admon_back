package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.DatosPersonales;
import com.usco.edu.rowMapper.DatosPersonalesRowMapper;

public class DatosPersonalesSetExtractor implements ResultSetExtractor<List<DatosPersonales>> {

	@Override
	public List<DatosPersonales> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<DatosPersonales> list = new ArrayList<DatosPersonales>();
		while (rs.next()) {
			list.add(new DatosPersonalesRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
