package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.MencionReconocimiento;
import com.usco.edu.rowMapper.MencionReconocimientoRowMapper;

public class MencionReconocimientoSetExtractor implements ResultSetExtractor<List<MencionReconocimiento>> {
	
	@Override
	public List<MencionReconocimiento> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<MencionReconocimiento> list = new ArrayList<MencionReconocimiento>();
		while (rs.next()) {
			list.add(new MencionReconocimientoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
