package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.HabilidadInformatica;
import com.usco.edu.rowMapper.ReporteHabilidadInformaticaRowMapper;

public class ReporteHabilidadInformaticaSetExtractor implements ResultSetExtractor<List<HabilidadInformatica>> {
	
	@Override
	public List<HabilidadInformatica> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<HabilidadInformatica> list = new ArrayList<HabilidadInformatica>();
		while (rs.next()) {
			list.add(new ReporteHabilidadInformaticaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
