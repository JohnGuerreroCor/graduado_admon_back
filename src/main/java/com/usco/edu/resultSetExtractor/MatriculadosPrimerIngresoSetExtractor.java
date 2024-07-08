package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.MatriculadosPrimerIngreso;
import com.usco.edu.rowMapper.MatriculadosPrimerIngresoRowMapper;

public class MatriculadosPrimerIngresoSetExtractor implements ResultSetExtractor<List<MatriculadosPrimerIngreso>> {
	
	@Override
	public List<MatriculadosPrimerIngreso> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<MatriculadosPrimerIngreso> list = new ArrayList<MatriculadosPrimerIngreso>();
		while (rs.next()) {
			list.add(new MatriculadosPrimerIngresoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
