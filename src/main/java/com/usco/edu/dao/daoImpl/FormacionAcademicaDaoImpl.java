package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IFormacionAcademicaDao;
import com.usco.edu.entities.HistorialAcademico;
import com.usco.edu.entities.NivelAcademico;
import com.usco.edu.resultSetExtractor.HistorialAcademicoSetExtractor;
import com.usco.edu.resultSetExtractor.NivelAcademicoSetExtractor;

@Repository
public class FormacionAcademicaDaoImpl implements IFormacionAcademicaDao{
	
	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<NivelAcademico> obtenerNivelesAcademicos() {
		
		String sql = "select * from dbo.nivel_academico na where na.nia_estado = 1";
		
		return jdbcTemplate.query(sql, new NivelAcademicoSetExtractor());
		
	}

	@Override
	public List<HistorialAcademico> obtenerHistorialAcademico(String id) {
		
		String sql = "select * from graduado.historial_academico ha "
				+ "inner join persona p on ha.per_codigo = p.per_codigo "
				+ "inner join nivel_academico na on ha.nia_codigo = na.nia_codigo "
				+ "left join municipio m on ha.mun_codigo = m.mun_codigo "
				+ "left join departamento d on m.dep_codigo = d.dep_codigo "
				+ "left join pais pa on d.pai_codigo = pa.pai_codigo "
				+ "where p.per_identificacion = '" + id + "'";
		
		return jdbcTemplate.query(sql, new HistorialAcademicoSetExtractor());
		
	}

	@Override
	public List<HistorialAcademico> obtenerReporteHistorialAcademico(String inicio, String fin) {
		
		String sql = "select * from graduado.historial_academico ha "
				+ "inner join persona p on ha.per_codigo = p.per_codigo "
				+ "inner join nivel_academico na on ha.nia_codigo = na.nia_codigo "
				+ "left join municipio m on ha.mun_codigo = m.mun_codigo "
				+ "left join departamento d on m.dep_codigo = d.dep_codigo "
				+ "left join pais pa on d.pai_codigo = pa.pai_codigo "
				+ "where convert(Date, ha.hia_fecha_fin) between '" + inicio + "' and '" + fin + "' ";
		
		return jdbcTemplate.query(sql, new HistorialAcademicoSetExtractor());
		
	}
}
