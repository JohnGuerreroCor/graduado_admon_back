package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.HistorialAcademico;
import com.usco.edu.rowMapper.HistorialAcademicoRowMapper;

public class HistorialAcademicoSetExtractor implements ResultSetExtractor<List<HistorialAcademico>>{

	@Override
	public List<HistorialAcademico> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<HistorialAcademico> list = new ArrayList<HistorialAcademico>();
		while (rs.next()) {
			list.add(new HistorialAcademicoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
