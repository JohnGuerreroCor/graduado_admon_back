package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.ITasaGraduacionDao;
import com.usco.edu.entities.GraduadosPeriodoAcademico;
import com.usco.edu.entities.MatriculadosPrimerIngreso;
import com.usco.edu.entities.TasaGraduacionPeriodo;
import com.usco.edu.entities.TasaGraduacionPersonas;
import com.usco.edu.entities.TasaGraduacionSemestre;
import com.usco.edu.resultSetExtractor.GraduadosPeriodoAcademicoSetExtractor;
import com.usco.edu.resultSetExtractor.MatriculadosPrimerIngresoSetExtractor;
import com.usco.edu.resultSetExtractor.TasaGraduacionPeriodoSetExtractor;
import com.usco.edu.resultSetExtractor.TasaGraduacionPersonasSetExtractor;
import com.usco.edu.resultSetExtractor.TasaGraduacionSemestreSetExtractor;

@Repository
public class TasaGraduacionDaoImpl implements ITasaGraduacionDao{
	
	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<TasaGraduacionSemestre> obtenerInformacionPrograma(int programaCodigo) {
		
		String sql = "select top 1 u.uaa_nombre_corto, nat.nat_nombre, na.nia_nombre, p.pro_fecha_creacion, paa.paa_semestre, paa.pla_codigo from plan_academico_asignatura paa "
				+ "inner join plan_academico pa on paa.pla_codigo = pa.pla_codigo "
				+ "inner join programa p on pa.pro_codigo = p.pro_codigo "
				+ "inner join uaa u on p.uaa_codigo = u.uaa_codigo "
				+ "inner join nivel_academico na on p.nia_codigo = na.nia_codigo "
				+ "inner join nivel_academico_tipo nat on na.nat_codigo = nat.nat_codigo "
				+ "where p.pro_codigo = " + programaCodigo + " "
				+ "group by u.uaa_nombre_corto, nat.nat_nombre, na.nia_nombre, p.pro_fecha_creacion, paa.paa_semestre, paa.pla_codigo "
				+ "order by paa.paa_semestre desc ";
		
		return jdbcTemplate.query(sql, new TasaGraduacionSemestreSetExtractor());
		
	}
	
	@Override
	public List<MatriculadosPrimerIngreso> obtenerMatriculadosPrimerIngreso(int programaCodigo) {
		
		String sql = "DECLARE @matriculados TABLE (per_nombre nvarchar(100),est_codigo nvarchar(100)) insert into @matriculados (per_nombre, est_codigo) "
				+ "SELECT pe.per_nombre, est.est_codigo FROM matricula mat WITH (NOLOCK) "
				+ "INNER JOIN estudiante est WITH (NOLOCK) ON mat.est_codigo = est.est_codigo "
				+ "INNER JOIN calendario cal WITH (NOLOCK) ON mat.cal_codigo = cal.cal_codigo "
				+ "INNER JOIN periodo pe WITH (NOLOCK) ON cal.per_codigo = pe.per_codigo "
				+ "INNER JOIN programa pro WITH (NOLOCK) ON est.pro_codigo = pro.pro_codigo "
				+ "INNER JOIN persona per WITH (NOLOCK) ON est.per_codigo = per.per_codigo "
				+ "WHERE pro.pro_codigo IN(SELECT * FROM dbo.Split(" + programaCodigo + ",',')) AND (mat.mat_estado != 'I') "
				+ "AND pro.pro_codigo IN(SELECT * FROM dbo.Split(" + programaCodigo + ",',')) AND (mat.mat_estado != 'I') "
				+ "AND (mat_observacion like 'Matricula Automatica%' OR mat_observacion like 'Matricula Posgrados%' or mat_cliente like 'MATRICULA_PRIMIPAROS%' "
				+ "OR SUBSTRING(est.est_codigo, 1, 5) in (SELECT pe.per_nombre FROM periodo WHERE pe.per_nombre BETWEEN '19701' AND '20241')) "
				+ "GROUP by pe.per_nombre, est.est_codigo "
				+ "ORDER BY pe.per_nombre asc; "
				+ "SELECT per_nombre, COUNT(est_codigo) AS cantidad_estudiantes "
				+ "FROM @matriculados "
				+ "GROUP BY per_nombre;";
		
		return jdbcTemplate.query(sql, new MatriculadosPrimerIngresoSetExtractor());
		
	}

	@Override
	public List<GraduadosPeriodoAcademico> obtenerGraduadosPeriodoAcademico(int programaCodigo) {
		
		String sql = "DECLARE @graduados TABLE (per_nombre nvarchar(100),gra_codigo nvarchar(100)) insert into @graduados (per_nombre, gra_codigo) "
				+ "select pe.per_nombre, g.est_codigo from graduado g "
				+ "inner join estudiante e on g.est_codigo = e.est_codigo "
				+ "inner join programa p on e.pro_codigo = p.pro_codigo "
				+ "inner join uaa u on p.uaa_codigo = u.uaa_codigo "
				+ "join periodo pe on g.gra_fecha >= pe.per_fecha_inicio and g.gra_fecha <= pe.per_fecha_fin "
				+ "where p.pro_codigo = " + programaCodigo + " "
				+ "ORDER BY pe.per_nombre desc; "
				+ "SELECT per_nombre, COUNT(gra_codigo) AS cantidad_graduados "
				+ "FROM @graduados "
				+ "GROUP BY per_nombre;";
		
		return jdbcTemplate.query(sql, new GraduadosPeriodoAcademicoSetExtractor());
		
	}

	@Override
	public List<TasaGraduacionPeriodo> obtenerPeriodosMatriculados(int programaCodigo) {
		
		String sql = "SELECT pe.per_nombre, count(*) as matriculados FROM matricula mat WITH (NOLOCK) "
				+ "INNER JOIN estudiante est WITH (NOLOCK) ON mat.est_codigo = est.est_codigo "
				+ "INNER JOIN calendario cal WITH (NOLOCK) ON mat.cal_codigo = cal.cal_codigo "
				+ "INNER JOIN periodo pe WITH (NOLOCK) ON cal.per_codigo = pe.per_codigo "
				+ "INNER JOIN programa pro WITH (NOLOCK) ON est.pro_codigo = pro.pro_codigo "
				+ "INNER JOIN uaa u WITH (NOLOCK) ON pro.uaa_codigo = u.uaa_codigo "
				+ "INNER JOIN uaa u2 WITH (NOLOCK) ON u.uaa_dependencia = u2.uaa_codigo "
				+ "INNER JOIN sede sed WITH (NOLOCK) ON pro.sed_codigo = sed.sed_codigo "
				+ "INNER JOIN nivel_academico nia WITH (NOLOCK) ON pro.nia_codigo = nia.nia_codigo "
				+ "INNER JOIN nivel_academico_tipo nat WITH (NOLOCK) ON nia.nat_codigo = nat.nat_codigo "
				+ "INNER JOIN persona per WITH (NOLOCK) ON est.per_codigo = per.per_codigo "
				+ "INNER JOIN inscripcion ins WITH (NOLOCK) ON est.ins_codigo = ins.ins_codigo "
				+ "INNER JOIN inscripcion_programa inp WITH(NOLOCK) ON ins.ins_codigo = inp.ins_codigo "
				+ "INNER JOIN tipo_id tii WITH (NOLOCK) ON per.tii_codigo = tii.tii_codigo "
				+ "LEFT JOIN estudiante_estado ese WITH (NOLOCK) ON est.ese_codigo = ese.ese_codigo "
				+ "LEFT JOIN modalidad_ingreso moi WITH(NOLOCK) ON ins.moi_codigo = moi.moi_codigo "
				+ "LEFT JOIN admision_resultado adr WITH(NOLOCK) ON  inp.inp_codigo = adr.inp_codigo "
				+ "LEFT JOIN admision_tipo adt WITH(NOLOCK) ON adr.adt_codigo = adt.adt_codigo "
				+ "WHERE pe.per_nombre BETWEEN '19701' AND '20241' "
				+ "AND pro.pro_codigo IN(SELECT * FROM dbo.Split(" + programaCodigo + ",','))  AND (mat.mat_estado != 'I') "
				+ "AND (mat_observacion like 'Matricula Automatica%' OR mat_observacion like 'Matricula Posgrados%' or mat_cliente like 'MATRICULA_PRIMIPAROS%' "
				+ "OR SUBSTRING(est.est_codigo, 1, 5) in (SELECT pe.per_nombre FROM periodo WHERE pe.per_nombre BETWEEN '19701' AND '20232')) "
				+ "GROUP by pe.per_nombre "
				+ "ORDER BY pe.per_nombre desc";
		
		return jdbcTemplate.query(sql, new TasaGraduacionPeriodoSetExtractor());
		
	}

	@Override
	public List<TasaGraduacionPersonas> obtenerEstudiantesPrimerIngreso(String periodoInicial, String periodoFinal,
			int programaCodigo) {
		
		String sql = "SELECT pe.per_nombre, est.est_codigo FROM matricula mat WITH (NOLOCK) "
				+ "INNER JOIN estudiante est WITH (NOLOCK) ON mat.est_codigo = est.est_codigo "
				+ "INNER JOIN calendario cal WITH (NOLOCK) ON mat.cal_codigo = cal.cal_codigo "
				+ "INNER JOIN periodo pe WITH (NOLOCK) ON cal.per_codigo = pe.per_codigo "
				+ "INNER JOIN programa pro WITH (NOLOCK) ON est.pro_codigo = pro.pro_codigo "
				+ "INNER JOIN uaa u WITH (NOLOCK) ON pro.uaa_codigo = u.uaa_codigo "
				+ "INNER JOIN uaa u2 WITH (NOLOCK) ON u.uaa_dependencia = u2.uaa_codigo "
				+ "INNER JOIN sede sed WITH (NOLOCK) ON pro.sed_codigo = sed.sed_codigo "
				+ "INNER JOIN nivel_academico nia WITH (NOLOCK) ON pro.nia_codigo = nia.nia_codigo "
				+ "INNER JOIN nivel_academico_tipo nat WITH (NOLOCK) ON nia.nat_codigo = nat.nat_codigo "
				+ "INNER JOIN persona per WITH (NOLOCK) ON est.per_codigo = per.per_codigo "
				+ "INNER JOIN inscripcion ins WITH (NOLOCK) ON est.ins_codigo = ins.ins_codigo "
				+ "INNER JOIN inscripcion_programa inp WITH(NOLOCK) ON ins.ins_codigo = inp.ins_codigo "
				+ "INNER JOIN tipo_id tii WITH (NOLOCK) ON per.tii_codigo = tii.tii_codigo "
				+ "LEFT JOIN estudiante_estado ese WITH (NOLOCK) ON est.ese_codigo = ese.ese_codigo "
				+ "LEFT JOIN modalidad_ingreso moi WITH(NOLOCK) ON ins.moi_codigo = moi.moi_codigo "
				+ "LEFT JOIN admision_resultado adr WITH(NOLOCK) ON  inp.inp_codigo = adr.inp_codigo "
				+ "LEFT JOIN admision_tipo adt WITH(NOLOCK) ON adr.adt_codigo = adt.adt_codigo "
				+ "WHERE pe.per_nombre BETWEEN '" + periodoInicial + "' AND '" + periodoFinal + "' "
				+ "AND pro.pro_codigo IN(SELECT * FROM dbo.Split(" + programaCodigo + ",','))  AND (mat.mat_estado != 'I') "
				+ "AND (mat_observacion like 'Matricula Automatica%' OR mat_observacion like 'Matricula Posgrados%' or mat_cliente like 'MATRICULA_PRIMIPAROS%' "
				+ "OR SUBSTRING(est.est_codigo, 1, 5) in (SELECT pe.per_nombre FROM periodo WHERE pe.per_nombre BETWEEN '" + periodoInicial + "' AND '" + periodoFinal + "')) "
				+ "GROUP by pe.per_nombre, est.est_codigo "
				+ "ORDER BY pe.per_nombre desc "
				+ "";
		
		return jdbcTemplate.query(sql, new TasaGraduacionPersonasSetExtractor());
		
	}

	@Override
	public List<TasaGraduacionPersonas> obtenerGraduados(int programaCodigo, String periodo) {
		
		String sql = "select p2.per_nombre, g.est_codigo from graduado g "
				+ "inner join estudiante e on g.est_codigo = e.est_codigo "
				+ "inner join programa p on e.pro_codigo = p.pro_codigo "
				+ "inner join uaa u on p.uaa_codigo = u.uaa_codigo "
				+ "join periodo p2 on g.gra_fecha >= p2.per_fecha_inicio and g.gra_fecha <= p2.per_fecha_fin "
				+ "where p.pro_codigo = " + programaCodigo + "and p2.per_nombre = '" + periodo + "'";
		
		return jdbcTemplate.query(sql, new TasaGraduacionPersonasSetExtractor());
		
	}

}
