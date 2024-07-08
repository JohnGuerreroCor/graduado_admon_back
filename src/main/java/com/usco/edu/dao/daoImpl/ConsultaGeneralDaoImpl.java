package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IConsultaGeneralDao;
import com.usco.edu.entities.Facultad;
import com.usco.edu.entities.NivelAcademico;
import com.usco.edu.entities.Periodo;
import com.usco.edu.entities.ProgramaGeneral;
import com.usco.edu.resultSetExtractor.FacultadSetExtractor;
import com.usco.edu.resultSetExtractor.NivelAcademicoSetExtractor;
import com.usco.edu.resultSetExtractor.PeriodoSetExtractor;
import com.usco.edu.resultSetExtractor.ProgramaGeneralSetExtractor;

@Repository
public class ConsultaGeneralDaoImpl implements IConsultaGeneralDao {
	

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<Periodo> obtenerPeriodos() {
		
		String sql = "select top 20 * from periodo p order by p.per_codigo desc";
		return jdbcTemplate.query(sql, new PeriodoSetExtractor());
		
	}

	@Override
	public List<Facultad> obtenerFacultades() {
		
		String sql = "select * from uaa u where u.uaa_nombre like '%facultad%' and u.uaa_dependencia = 385";
		return jdbcTemplate.query(sql, new FacultadSetExtractor());
		
	}

	@Override
	public List<ProgramaGeneral> obtenerProgramasFacultad(int sedeCodigo, int nivelAcademicoCodigo, int dependenciaCodigo) {
		
		String sql = "select p.pro_codigo, u.uaa_nombre, u.uaa_nombre_corto, u.uaa_dependencia, u2.uaa_nombre as facultad, p.sed_codigo, s.sed_nombre from programa p "
				+ "inner join uaa u on p.uaa_codigo = u.uaa_codigo "
				+ "inner join uaa u2 on u.uaa_dependencia = u2.uaa_codigo "
				+ "inner join sede s on p.sed_codigo = s.sed_codigo "
				+ "where s.sed_codigo = " + sedeCodigo + " and p.nia_codigo = " + nivelAcademicoCodigo + " and u2.uaa_codigo = " + dependenciaCodigo + " and p.pro_estado = 1 and p.pro_registro_snies is not null and p.pro_registro_snies != '' order by u.uaa_nombre asc";
		return jdbcTemplate.query(sql, new ProgramaGeneralSetExtractor());
		
	}

	@Override
	public List<NivelAcademico> obtenerNivelesAcademicos(int nivelFormacionCodigo) {
		
		String sql = "select * from dbo.nivel_academico na where na.nia_estado = 1 and na.nat_codigo = " + nivelFormacionCodigo + " order by na.nia_codigo desc";
		return jdbcTemplate.query(sql, new NivelAcademicoSetExtractor());
		
	}
	
}
