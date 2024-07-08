package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IMencionReconocimientoDao;
import com.usco.edu.entities.MencionReconocimiento;
import com.usco.edu.resultSetExtractor.MencionReconocimientoSetExtractor;

@Repository
public class MencionReconocimientoDaoImpl implements IMencionReconocimientoDao {
	

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<MencionReconocimiento> obtenerMencionesReconocimiento(String id) {
		
		String sql = "select * from graduado.mencion_reconocimiento mr "
				+ "inner join persona p on mr.per_codigo = p.per_codigo "
				+ "inner join graduado.ambito a on mr.amb_codigo = a.amb_codigo "
				+ "inner join municipio m on mr.mun_codigo = m.mun_codigo "
				+ "where p.per_identificacion = '" + id + "'";
		return jdbcTemplate.query(sql, new MencionReconocimientoSetExtractor());
		
	}

	@Override
	public List<MencionReconocimiento> obtenerReporteMencionesReconocimiento(String inicio, String fin) {
		
		String sql = "select * from graduado.mencion_reconocimiento mr "
				+ "inner join persona p on mr.per_codigo = p.per_codigo "
				+ "inner join graduado.ambito a on mr.amb_codigo = a.amb_codigo "
				+ "inner join municipio m on mr.mun_codigo = m.mun_codigo "
				+ "where convert(Date, mr.mer_fecha) between '" + inicio + "' and '" + fin + "' ";
		return jdbcTemplate.query(sql, new MencionReconocimientoSetExtractor());
		
	}

	
	
}
