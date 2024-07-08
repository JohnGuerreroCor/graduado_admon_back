package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.TasaGraduacionSemestre;
import com.usco.edu.rowMapper.TasaGraduacionSemestreRowMapper;

public class TasaGraduacionSemestreSetExtractor implements ResultSetExtractor<List<TasaGraduacionSemestre>> {
	
	@Override
	public List<TasaGraduacionSemestre> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<TasaGraduacionSemestre> list = new ArrayList<TasaGraduacionSemestre>();
		while (rs.next()) {
			list.add(new TasaGraduacionSemestreRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
