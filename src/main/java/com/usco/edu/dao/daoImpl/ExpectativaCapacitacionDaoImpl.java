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

import com.usco.edu.dao.IExpectativaCapacitacionDao;
import com.usco.edu.dto.ReporteExpectativaCapacitacion;
import com.usco.edu.entities.ExpectativaCapacitacionEscala;
import com.usco.edu.entities.ExpectativaCompetenciaRespuesta;
import com.usco.edu.resultSetExtractor.ExpectativaCapacitacionEscalaSetExtractor;
import com.usco.edu.resultSetExtractor.ExpectativaCompetenciaRespuestaSetExtractor;

@Repository
public class ExpectativaCapacitacionDaoImpl implements IExpectativaCapacitacionDao {
	

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<ExpectativaCapacitacionEscala> obtenerEscalaPregunta(int preguntaCodigo) {
		
		String sql = "select * from graduado.expectativas_capacitacion_escala ece where ece.ecp_codigo = " + preguntaCodigo +" and ece.ece_estado = 1";
		return jdbcTemplate.query(sql, new ExpectativaCapacitacionEscalaSetExtractor());
		
	}

	@Override
	public List<ExpectativaCompetenciaRespuesta> obtenerRespuestasIdentificacion(String id) {
		
		String sql = "select ecr.ecr_codigo, ecr.per_codigo, ecr.ecp_codigo, ecp.ecp_nombre, ecr.ece_codigo, ece.ece_respuesta, ecr.ecr_fecha from graduado.expectativas_capacitacion_respuesta ecr  "
				+ "left join persona p on ecr.per_codigo = p.per_codigo "
				+ "left join graduado.expectativas_capacitacion_pregunta ecp on ecr.ecp_codigo = ecp.ecp_codigo "
				+ "left join graduado.expectativas_capacitacion_escala ece on ecr.ece_codigo = ece.ece_codigo "
				+ "where p.per_identificacion = '" + id + "'";
		return jdbcTemplate.query(sql, new ExpectativaCompetenciaRespuestaSetExtractor());
		
	}

	@Override
	public List<ReporteExpectativaCapacitacion> obtenerRerporteExpectativaCapacitacion(String inicio, String fin) {
		
		String sql = "with resultado(per_codigo, per_nombre, per_apellido, ecr_fecha, ecp_codigo, ece_respuesta)as( "
				+ "select p.per_codigo,p.per_nombre, p.per_apellido, ecr.ecr_fecha, ecp.ecp_codigo, ece.ece_respuesta from persona p "
				+ "inner join graduado.expectativas_capacitacion_respuesta ecr on p.per_codigo = ecr.per_codigo "
				+ "inner join graduado.expectativas_capacitacion_pregunta ecp on ecr.ecp_codigo = ecp.ecp_codigo "
				+ "inner join graduado.expectativas_capacitacion_escala ece on ecr.ece_codigo = ece.ece_codigo "
				+ "where convert(Date, ecr.ecr_fecha) BETWEEN '" + inicio + "' and '" + fin + "' "
				+ ") select * from resultado pivot(max(ece_respuesta) for ecp_codigo in ([1],[2],[3]))as pvt "
				+ "order by ecr_fecha desc";
		
		List<ReporteExpectativaCapacitacion> lstReporteExpectativaCapacitacion = jdbcTemplate.query(sql, new RowMapper<ReporteExpectativaCapacitacion>() {

			@Override
			public ReporteExpectativaCapacitacion mapRow(ResultSet rs, int rowNum) throws SQLException {


				ReporteExpectativaCapacitacion ReporteExpectativaCapacitacion = new ReporteExpectativaCapacitacion();
				
				
				ReporteExpectativaCapacitacion.setFecha(rs.getDate("ecr_fecha"));
				ReporteExpectativaCapacitacion.setPersonaCodigo(rs.getInt("per_codigo"));
				ReporteExpectativaCapacitacion.setPersonaNombre(rs.getString("per_nombre"));
				ReporteExpectativaCapacitacion.setPersonaApellido(rs.getString("per_apellido"));
				
				 Map<String, String> columnas = new HashMap<>();

	                
	                for (int i = 0; i < 3; i++) {
	                    String columnName = "columna" + i;
	                    String columnValue = rs.getString((i+1)+"");
	                    columnas.put(columnName, columnValue);
	                }

	                ReporteExpectativaCapacitacion.setColumnas(columnas);


				

				return ReporteExpectativaCapacitacion;
			}

		});

		return lstReporteExpectativaCapacitacion;
		
	}
}
