package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.GrupoSanguineo;
import com.usco.edu.rowMapper.GrupoSanguineoRowMapper;

public class GrupoSanguineoSetExtractor implements ResultSetExtractor<List<GrupoSanguineo>>{

	@Override
	public List<GrupoSanguineo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<GrupoSanguineo> list = new ArrayList<GrupoSanguineo>();
		while (rs.next()) {
			list.add(new GrupoSanguineoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
