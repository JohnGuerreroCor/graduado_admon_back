package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.DatosComplementarios;
import com.usco.edu.rowMapper.DatosComplementariosRowMapper;

public class DatosComplementariosSetExtractor implements ResultSetExtractor<List<DatosComplementarios>> {
	
	@Override
	public List<DatosComplementarios> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<DatosComplementarios> list = new ArrayList<DatosComplementarios>();
		while (rs.next()) {
			list.add(new DatosComplementariosRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
