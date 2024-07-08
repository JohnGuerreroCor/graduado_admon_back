package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.ProgramaGeneral;
import com.usco.edu.rowMapper.ProgramaGeneralRowMapper;

public class ProgramaGeneralSetExtractor implements ResultSetExtractor<List<ProgramaGeneral>> {
	
	@Override
	public List<ProgramaGeneral> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<ProgramaGeneral> list = new ArrayList<ProgramaGeneral>();
		while (rs.next()) {
			list.add(new ProgramaGeneralRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
