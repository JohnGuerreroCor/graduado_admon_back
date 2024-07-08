package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.HistorialLaboral;
import com.usco.edu.rowMapper.ReporteHistorialLaboralRowMapper;

public class ReporteHistorialLaboralSetExtractor implements ResultSetExtractor<List<HistorialLaboral>> {
	
	@Override
	public List<HistorialLaboral> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<HistorialLaboral> list = new ArrayList<HistorialLaboral>();
		while (rs.next()) {
			list.add(new ReporteHistorialLaboralRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
