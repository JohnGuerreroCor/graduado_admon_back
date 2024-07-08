package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.TasaGraduacionPeriodo;
import com.usco.edu.rowMapper.TasaGraduacionPeriodoRowMapper;

public class TasaGraduacionPeriodoSetExtractor implements ResultSetExtractor<List<TasaGraduacionPeriodo>> {
	
	@Override
	public List<TasaGraduacionPeriodo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<TasaGraduacionPeriodo> list = new ArrayList<TasaGraduacionPeriodo>();
		while (rs.next()) {
			list.add(new TasaGraduacionPeriodoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
