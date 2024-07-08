package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IInformacionAcademicaDao;
import com.usco.edu.entities.DatosComplementarios;
import com.usco.edu.entities.HabilidadInformatica;
import com.usco.edu.entities.Idioma;
import com.usco.edu.entities.RegistroEducativo;
import com.usco.edu.resultSetExtractor.DatosComplementariosSetExtractor;
import com.usco.edu.resultSetExtractor.HabilidadInformaticaSetExtractor;
import com.usco.edu.resultSetExtractor.IdiomaSetExtractor;
import com.usco.edu.resultSetExtractor.RegistroEducativoSetExtractor;
import com.usco.edu.resultSetExtractor.ReporteDatosComplementariosSetExtractor;
import com.usco.edu.resultSetExtractor.ReporteHabilidadInformaticaSetExtractor;
import com.usco.edu.resultSetExtractor.ReporteIdiomaSetExtractor;
import com.usco.edu.resultSetExtractor.ReporteRegistroEducativoSetExtractor;

@Repository
public class InformacionAcademicaDaoImpl implements IInformacionAcademicaDao {
	
	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<HabilidadInformatica> obtenerListadoHabilidadesInformaticas(String id) {
		
		String sql = "select * from graduado.habilidad_informatica hi "
				+ "inner join persona p on hi.per_codigo = p.per_codigo "
				+ "inner join graduado.habilidad_informatica_dominio hid on hi.hid_codigo = hid.hid_codigo "
				+ "where p.per_identificacion = '" + id + "'";
		
		return jdbcTemplate.query(sql, new HabilidadInformaticaSetExtractor());
		
	}
	
	@Override
	public List<HabilidadInformatica> obtenerReporteHabilidadesInformaticas(String inicio, String fin) {
		
		String sql = "select * from graduado.habilidad_informatica hi "
				+ "inner join persona p on hi.per_codigo = p.per_codigo "
				+ "inner join estudiante e on p.per_codigo = e.per_codigo "
				+ "inner join graduado.datos_complementarios dc on e.est_codigo = dc.est_codigo "
				+ "inner join graduado.habilidad_informatica_dominio hid on hi.hid_codigo = hid.hid_codigo "
				+ "where convert(Date, dc.dac_fecha) BETWEEN '" + inicio + "' AND '" + fin + "' "
				+ "order by p.per_codigo ";
		
		return jdbcTemplate.query(sql, new ReporteHabilidadInformaticaSetExtractor());
		
	}

	@Override
	public List<Idioma> obtenerListadoIdiomas(String id) {
		
		String sql = "select i.idi_codigo, p.per_codigo, i.idi_idioma, idc.idd_codigo as conversacionCodigo, idc.idd_nombre as conversacion, ide.idd_codigo as escrituraCodigo, ide.idd_nombre as escritura, idl.idd_codigo as lecturaCodigo, idl.idd_nombre as lectura, i.idi_estado from graduado.idioma i "
				+ "inner join persona p on i.per_codigo = p.per_codigo "
				+ "inner join graduado.idioma_dominio idc on i.idi_conversacion = idc.idd_codigo "
				+ "inner join graduado.idioma_dominio ide on i.idi_escritura = ide.idd_codigo "
				+ "inner join graduado.idioma_dominio idl on i.idi_lectura = idl.idd_codigo "
				+ "where p.per_identificacion = '" + id + "'";
		
		return jdbcTemplate.query(sql, new IdiomaSetExtractor());
		
	}
	
	@Override
	public List<Idioma> obtenerReporteIdiomas(String inicio, String fin) {
		
		String sql = "select i.idi_codigo, p.per_codigo, p.per_nombre, p.per_apellido, i.idi_idioma, idc.idd_codigo as conversacionCodigo, idc.idd_nombre as conversacion, ide.idd_codigo as escrituraCodigo, ide.idd_nombre as escritura, idl.idd_codigo as lecturaCodigo, idl.idd_nombre as lectura, i.idi_estado from graduado.idioma i "
				+ "inner join persona p on i.per_codigo = p.per_codigo "
				+ "inner join estudiante e on p.per_codigo = e.per_codigo "
				+ "inner join graduado.datos_complementarios dc on e.est_codigo = dc.est_codigo "
				+ "inner join graduado.idioma_dominio idc on i.idi_conversacion = idc.idd_codigo "
				+ "inner join graduado.idioma_dominio ide on i.idi_escritura = ide.idd_codigo "
				+ "inner join graduado.idioma_dominio idl on i.idi_lectura = idl.idd_codigo "
				+ "where convert(Date, dc.dac_fecha) BETWEEN '" + inicio + "' AND '" + fin + "' "
				+ "order by p.per_codigo ";
		
		return jdbcTemplate.query(sql, new ReporteIdiomaSetExtractor());
		
	}

	@Override
	public List<RegistroEducativo> obtenerListadoRegistroEducativo(String id) {
		
		String sql = "select * from graduado.registro_educativo re "
				+ "inner join persona p on re.per_codigo = p.per_codigo "
				+ "inner join nivel_academico na on re.nia_codigo = na.nia_codigo "
				+ "inner join municipio m on re.mun_codigo = m.mun_codigo "
				+ "where p.per_identificacion = '" + id + "' order by re.ree_fecha_fin desc";
		
		return jdbcTemplate.query(sql, new RegistroEducativoSetExtractor());
		
	}
	
	@Override
	public List<RegistroEducativo> obtenerReporteRegistroEducativo(String inicio, String fin) {
		
		String sql = "select * from graduado.registro_educativo re "
				+ "inner join persona p on re.per_codigo = p.per_codigo "
				+ "inner join estudiante e on p.per_codigo = e.per_codigo "
				+ "inner join graduado.datos_complementarios dc on e.est_codigo = dc.est_codigo "
				+ "inner join nivel_academico na on re.nia_codigo = na.nia_codigo "
				+ "inner join municipio m on re.mun_codigo = m.mun_codigo "
				+ "where convert(Date, dc.dac_fecha) between '" + inicio + "' and '" + fin + "' "
				+ "order by p.per_codigo, re.ree_fecha_fin desc";
		
		return jdbcTemplate.query(sql, new ReporteRegistroEducativoSetExtractor());
		
	}

	@Override
	public List<DatosComplementarios> obtenerListadoDatosComplementarios(String id) {
		
		String sql = "select top 1 * from graduado.datos_complementarios dc "
				+ "inner join estudiante e on dc.est_codigo = e.est_codigo "
				+ "inner join persona p on e.per_codigo = p.per_codigo "
				+ "where p.per_identificacion = '" + id + "' order by e.est_codigo desc";
		
		return jdbcTemplate.query(sql, new DatosComplementariosSetExtractor());
		
	}

	@Override
	public List<DatosComplementarios> obtenerReporteDatosComplementarios(String inicio, String fin) {
		
		String sql = "select * from graduado.datos_complementarios dc "
				+ "inner join estudiante e on dc.est_codigo = e.est_codigo "
				+ "inner join persona p on e.per_codigo = p.per_codigo "
				+ "inner join programa po on e.pro_codigo = po.pro_codigo "
				+ "inner join uaa u on po.uaa_codigo = u.uaa_codigo "
				+ "where convert(Date, dc.dac_fecha) BETWEEN '" + inicio + "' AND '" + fin + "'";
		
		return jdbcTemplate.query(sql, new ReporteDatosComplementariosSetExtractor());
		
	}

}
