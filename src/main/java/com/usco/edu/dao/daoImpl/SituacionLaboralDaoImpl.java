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

import com.usco.edu.dao.ISituacionLaboralDao;
import com.usco.edu.dto.ReporteSituacionLaboral;
import com.usco.edu.entities.SituacionLaboralRespuesta;
import com.usco.edu.resultSetExtractor.SituacionLaboralRespuestaSetExtractor;

@Repository
public class SituacionLaboralDaoImpl implements ISituacionLaboralDao {
	
	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<SituacionLaboralRespuesta> obtenerRespuestasIdentificacion(String id) {
		
		String sql = "select slr.slr_codigo, slr.per_codigo, slr.slp_codigo, slp.slp_nombre, slr.sle_codigo, sle.sle_respuesta, slr.slr_fecha from graduado.situacion_laboral_respuesta slr "
				+ "left join persona p on slr.per_codigo = p.per_codigo "
				+ "left join graduado.situacion_laboral_pregunta slp on slr.slp_codigo = slp.slp_codigo "
				+ "left join graduado.situacion_laboral_escala sle on slr.sle_codigo = sle.sle_codigo  "
				+ "where p.per_identificacion = '" + id + "'";
		return jdbcTemplate.query(sql, new SituacionLaboralRespuestaSetExtractor());
		
	}

	@Override
	public List<ReporteSituacionLaboral> obtenerRerporteSituacionLaboral(String inicio, String fin) {
		
		String sql = "with resultado(per_codigo, per_nombre, per_apellido, slr_fecha,slp_codigo,sle_nombre)as( "
				+ "select p.per_codigo,p.per_nombre, p.per_apellido, slr.slr_fecha,slp.slp_codigo, sle.sle_respuesta from persona p "
				+ "inner join graduado.situacion_laboral_respuesta slr on p.per_codigo = slr.per_codigo "
				+ "inner join graduado.situacion_laboral_pregunta slp on slr.slp_codigo = slp.slp_codigo "
				+ "inner join graduado.situacion_laboral_escala sle on slr.sle_codigo = sle.sle_codigo "
				+ "where convert(Date, slr.slr_fecha) BETWEEN '" + inicio + "' and '" + fin + "' "
				+ ") select * from resultado pivot(max(sle_nombre) for slp_codigo in ([1],[2],[3],[4],[5],[6],[7],[8],[9],[10]))as pvt "
				+ "order by slr_fecha asc ";
		
		List<ReporteSituacionLaboral> lstReporteSituacionLaboral = jdbcTemplate.query(sql, new RowMapper<ReporteSituacionLaboral>() {

			@Override
			public ReporteSituacionLaboral mapRow(ResultSet rs, int rowNum) throws SQLException {


				ReporteSituacionLaboral ReporteSituacionLaboral = new ReporteSituacionLaboral();
				
				
				ReporteSituacionLaboral.setFecha(rs.getDate("slr_fecha"));
				ReporteSituacionLaboral.setPersonaCodigo(rs.getInt("per_codigo"));
				ReporteSituacionLaboral.setPersonaNombre(rs.getString("per_nombre"));
				ReporteSituacionLaboral.setPersonaApellido(rs.getString("per_apellido"));
				
				 Map<String, String> columnas = new HashMap<>();

	                
	                for (int i = 0; i < 10; i++) {
	                    String columnName = "columna" + i;
	                    String columnValue = rs.getString((i+1)+"");
	                    columnas.put(columnName, columnValue);
	                }

	                ReporteSituacionLaboral.setColumnas(columnas);


				

				return ReporteSituacionLaboral;
			}

		});

		return lstReporteSituacionLaboral;
		
	}
}
