package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.EstudianteActivo;
import com.usco.edu.rowMapper.EstudianteActivoRowMapper;

public class EstudianteActivoSetExtractor implements ResultSetExtractor<List<EstudianteActivo>>{

	@Override
	public List<EstudianteActivo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<EstudianteActivo> list = new ArrayList<EstudianteActivo>();
		while (rs.next()) {
			list.add(new EstudianteActivoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
