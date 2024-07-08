package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.GraduadosElecciones;
import com.usco.edu.rowMapper.GraduadosEleccionesRowMapper;

public class GraduadosEleccionesSetExtractor implements ResultSetExtractor<List<GraduadosElecciones>> {
	
	@Override
	public List<GraduadosElecciones> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<GraduadosElecciones> list = new ArrayList<GraduadosElecciones>();
		while (rs.next()) {
			list.add(new GraduadosEleccionesRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
