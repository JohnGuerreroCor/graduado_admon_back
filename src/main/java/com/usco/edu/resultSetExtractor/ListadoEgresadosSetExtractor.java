package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.ListadoEgresados;
import com.usco.edu.rowMapper.ListadoEgresadosRowMapper;

public class ListadoEgresadosSetExtractor implements ResultSetExtractor<List<ListadoEgresados>> {
	
	@Override
	public List<ListadoEgresados> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<ListadoEgresados> list = new ArrayList<ListadoEgresados>();
		while (rs.next()) {
			list.add(new ListadoEgresadosRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
