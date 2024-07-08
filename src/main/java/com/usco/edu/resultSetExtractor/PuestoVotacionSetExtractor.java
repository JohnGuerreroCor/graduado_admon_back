package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.PuestoVotacion;
import com.usco.edu.rowMapper.PuestoVotacionRowMapper;

public class PuestoVotacionSetExtractor implements ResultSetExtractor<List<PuestoVotacion>>{

	@Override
	public List<PuestoVotacion> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<PuestoVotacion> list = new ArrayList<PuestoVotacion>();
		while (rs.next()) {
			list.add(new PuestoVotacionRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
