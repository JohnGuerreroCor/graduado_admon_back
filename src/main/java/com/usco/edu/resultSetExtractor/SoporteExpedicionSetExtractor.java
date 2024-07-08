package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.SoporteExpedicion;
import com.usco.edu.rowMapper.SoporteExpedicionRowMapper;

public class SoporteExpedicionSetExtractor implements ResultSetExtractor<List<SoporteExpedicion>>{

	@Override
	public List<SoporteExpedicion> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<SoporteExpedicion> list = new ArrayList<SoporteExpedicion>();
		while (rs.next()) {
			list.add(new SoporteExpedicionRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
