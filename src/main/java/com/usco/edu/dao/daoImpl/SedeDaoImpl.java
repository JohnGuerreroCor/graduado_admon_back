package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.ISedeDao;
import com.usco.edu.entities.SedeCarnet;
import com.usco.edu.resultSetExtractor.SedeCarnetSetExtractor;

@Repository
public class SedeDaoImpl implements ISedeDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<SedeCarnet> sedesAll() {

		String sql = "SELECT * FROM sede s WHERE s.sed_estado = 1";

		return jdbcTemplate.query(sql, new SedeCarnetSetExtractor());
	}

}
