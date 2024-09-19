package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IHistorialLaboralDao;
import com.usco.edu.entities.HistorialLaboral;
import com.usco.edu.resultSetExtractor.HistorialLaboralSetExtractor;
import com.usco.edu.resultSetExtractor.ReporteHistorialLaboralSetExtractor;

@Repository
public class HistorialLaboralDaoImpl implements IHistorialLaboralDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<HistorialLaboral> obtenerHistorialLaboral(String id) {

		String sql = "select * from graduado.historial_laboral hl "
				+ "inner join persona p on hl.per_codigo = p.per_codigo "
				+ "where hl.hil_estado = 1 and p.per_identificacion = '" + id + "'";

		return jdbcTemplate.query(sql, new HistorialLaboralSetExtractor());

	}

	@Override
	public List<HistorialLaboral> obtenerReporteHistorialLaboral(String inicio, String fin) {

		String sql = "select * from graduado.historial_laboral hl "
				+ "inner join persona p on hl.per_codigo = p.per_codigo "
				+ "inner join estudiante e on p.per_codigo = e.per_codigo "
				+ "inner join graduado.datos_complementarios dc on e.est_codigo = dc.est_codigo "
				+ "where hl.hil_estado = 1 and convert(Date, dc.dac_fecha) BETWEEN '" + inicio + "' AND '" + fin + "'";

		return jdbcTemplate.query(sql, new ReporteHistorialLaboralSetExtractor());

	}

}
