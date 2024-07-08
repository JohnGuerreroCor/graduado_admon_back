package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.GraduadosPeriodoAcademico;
import com.usco.edu.rowMapper.GraduadosPeriodoAcademicoRowMapper;

public class GraduadosPeriodoAcademicoSetExtractor implements ResultSetExtractor<List<GraduadosPeriodoAcademico>> {
	
	@Override
	public List<GraduadosPeriodoAcademico> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<GraduadosPeriodoAcademico> list = new ArrayList<GraduadosPeriodoAcademico>();
		while (rs.next()) {
			list.add(new GraduadosPeriodoAcademicoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
