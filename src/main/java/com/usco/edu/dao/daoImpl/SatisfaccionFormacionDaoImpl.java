package com.usco.edu.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.ISatisfaccionFormacionDao;
import com.usco.edu.dto.ReporteCompetencia;
import com.usco.edu.entities.CompetenciaRespuesta;
import com.usco.edu.resultSetExtractor.CompetenciaRespuestaSetExtractor;

@Repository
public class SatisfaccionFormacionDaoImpl implements ISatisfaccionFormacionDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<CompetenciaRespuesta> obtenerRespuestasTipoUnoIdentificacion(String id) {

		String sql = "select * from graduado.competencia_respuesta cr "
				+ "inner join persona p on cr.per_codigo = p.per_codigo "
				+ "inner join graduado.competencia_pregunta cp on cr.cop_codigo = cp.cop_codigo "
				+ "inner join graduado.competencia_escala ce on cr.coe_codigo = ce.coe_codigo "
				+ "where p.per_identificacion = '" + id + "' and cp.cot_codigo = 1 order by cp.cop_orden ";

		return jdbcTemplate.query(sql, new CompetenciaRespuestaSetExtractor());

	}

	@Override
	public List<CompetenciaRespuesta> obtenerRespuestasTipoDosIdentificacion(String id) {

		String sql = "select * from graduado.competencia_respuesta cr "
				+ "inner join persona p on cr.per_codigo = p.per_codigo "
				+ "inner join graduado.competencia_pregunta cp on cr.cop_codigo = cp.cop_codigo "
				+ "inner join graduado.competencia_escala ce on cr.coe_codigo = ce.coe_codigo "
				+ "where p.per_identificacion = '" + id + "' and cp.cot_codigo = 2 order by cp.cop_orden ";

		return jdbcTemplate.query(sql, new CompetenciaRespuestaSetExtractor());

	}

	@Override
	public List<CompetenciaRespuesta> obtenerRespuestasTipoTresIdentificacion(String id) {

		String sql = "select * from graduado.competencia_respuesta cr "
				+ "inner join persona p on cr.per_codigo = p.per_codigo "
				+ "inner join graduado.competencia_pregunta cp on cr.cop_codigo = cp.cop_codigo "
				+ "inner join graduado.competencia_escala ce on cr.coe_codigo = ce.coe_codigo "
				+ "where p.per_identificacion = '" + id + "' and cp.cot_codigo = 3 order by cp.cop_orden ";

		return jdbcTemplate.query(sql, new CompetenciaRespuestaSetExtractor());

	}

	@Override
	public List<ReporteCompetencia> obtenerRerporteCompetencia(String inicio, String fin) {

		String sql = "with resultado(per_codigo, per_nombre, per_apellido, cor_fecha,cop_codigo,coe_nombre)as( "
				+ "select p.per_codigo, p.per_nombre, p.per_apellido, cr.cor_fecha, cp.cop_codigo, ce.coe_nombre from persona p "
				+ "inner join graduado.competencia_respuesta cr on p.per_codigo = cr.per_codigo "
				+ "inner join graduado.competencia_pregunta cp on cr.cop_codigo = cp.cop_codigo "
				+ "inner join graduado.competencia_escala ce on cr.coe_codigo = ce.coe_codigo "
				+ "where convert(Date, cr.cor_fecha) BETWEEN '" + inicio + "' and '" + fin + "' "
				+ ") select * from resultado pivot(max(coe_nombre) for cop_codigo in ([1],[2],[3],[4],[5],[6],[7],[8],[9],[10],[11],[12],[13],[14],[15],[16],[17],[18],[19],[20],[21],[22],[23],[24],[25],[26],[27],[28]))as pvt "
				+ "order by cor_fecha desc ";

		List<ReporteCompetencia> lstReporteCompetencia = jdbcTemplate.query(sql, new RowMapper<ReporteCompetencia>() {

			@Override
			public ReporteCompetencia mapRow(ResultSet rs, int rowNum) throws SQLException {

				ReporteCompetencia ReporteCompetencia = new ReporteCompetencia();

				ReporteCompetencia.setFecha(rs.getDate("cor_fecha"));
				ReporteCompetencia.setPersonaCodigo(rs.getInt("per_codigo"));
				ReporteCompetencia.setPersonaNombre(rs.getString("per_nombre"));
				ReporteCompetencia.setPersonaApellido(rs.getString("per_apellido"));

				Map<String, String> columnas = new HashMap<>();

				for (int i = 0; i < 28; i++) {
					String columnName = "columna" + i;
					String columnValue = rs.getString((i + 1) + "");
					columnas.put(columnName, columnValue);
				}

				ReporteCompetencia.setColumnas(columnas);

				return ReporteCompetencia;
			}

		});

		return lstReporteCompetencia;

	}
}
