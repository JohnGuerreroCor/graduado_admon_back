package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IGraduadoDao;
import com.usco.edu.entities.EstudianteActivo;
import com.usco.edu.entities.Graduado;
import com.usco.edu.resultSetExtractor.EstudianteActivoSetExtractor;
import com.usco.edu.resultSetExtractor.GraduadoSetExtractor;

@Repository
public class GraduadoDaoImpl implements IGraduadoDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<Graduado> buscarGraduadoPorIdentificacion(String id, String userdb) {

		String sql = "DECLARE @personaCodigo TABLE (per_codigo INT,per_identificacion varchar(100)) insert into @personaCodigo (per_codigo, per_identificacion) "
				+ "select top 1 p.per_codigo, p.per_identificacion from persona p "
				+ "inner join estudiante e on p.per_codigo = e.per_codigo "
				+ "left join graduado g on e.est_codigo = g.est_codigo " + "where (e.est_codigo = '" + id
				+ "' or p.per_identificacion  = '" + id + "') " + "select * from persona p "
				+ "INNER JOIN @personaCodigo pc on p.per_codigo = pc.per_codigo "
				+ "INNER JOIN estudiante e on p.per_codigo = e.per_codigo "
				+ "left join grupo_sanguineo gs on p.grs_codigo = gs.grs_codigo "
				+ "left join tipo_id ti on p.tii_codigo = ti.tii_codigo "
				+ "INNER JOIN programa po on e.pro_codigo = po.pro_codigo "
				+ "INNER JOIN nivel_academico na on po.nia_codigo = na.nia_codigo "
				+ "INNER JOIN nivel_academico_tipo nat on na.nat_codigo = nat.nat_codigo and nat.nat_codigo in (1,2) "
				+ "left join uaa u on po.uaa_codigo = u.uaa_codigo "
				+ "left join sede s on po.sed_codigo = s.sed_codigo "
				+ "left join municipio m on p.per_lugar_expedicion = m.mun_codigo "
				+ "LEFT JOIN graduado g on e.est_codigo = g.est_codigo order by g.gra_fecha desc ";

		return jdbcTemplate.query(sql, new GraduadoSetExtractor());

	}

	@Override
	public List<EstudianteActivo> buscarGraduadoEstudianteActivo(int codigo, String userdb) {

		String sql = "SELECT * FROM dbo.matricula m " + "INNER JOIN dbo.estudiante e on m.est_codigo = e.est_codigo "
				+ "INNER JOIN dbo.persona pe on e.per_codigo = pe.per_codigo "
				+ "INNER JOIN dbo.calendario c ON c.cal_codigo = m.cal_codigo "
				+ "inner join dbo.programa pr on e.pro_codigo = pr.pro_codigo "
				+ "inner join dbo.nivel_academico na on pr.nia_codigo = na.nia_codigo "
				+ "inner join dbo.nivel_academico_tipo nat on na.nat_codigo = nat.nat_codigo "
				+ "INNER JOIN dbo.periodo p ON p.per_codigo = c.per_codigo WHERE pe.per_codigo = ? AND convert(Date, GETDATE()) BETWEEN p.per_fecha_inicio AND p.per_fecha_fin and nat.nat_codigo in (1,2);";

		return jdbcTemplate.query(sql, new Object[] { codigo }, new EstudianteActivoSetExtractor());

	}

}
