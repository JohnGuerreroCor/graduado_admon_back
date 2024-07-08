package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.EstadoCivil;
import com.usco.edu.rowMapper.EstadoCivilRowMapper;

public class EstadoCivilSetExtractor implements ResultSetExtractor<List<EstadoCivil>>{

	@Override
	public List<EstadoCivil> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<EstadoCivil> list = new ArrayList<EstadoCivil>();
		while (rs.next()) {
			list.add(new EstadoCivilRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
