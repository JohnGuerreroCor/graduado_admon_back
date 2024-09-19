package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IEgresadoDao;
import com.usco.edu.entities.ListadoEgresados;
import com.usco.edu.resultSetExtractor.ListadoEgresadosSetExtractor;

@Repository
public class EgresadoDaoImpl implements IEgresadoDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<ListadoEgresados> obtenerListadoEgresadosFacultad(String periodo, int programaCodigo) {

		String sql = "WITH resultado(anio, periodo, sed_nombre, nat_nombre, nia_nombre, dependencia_codigo, dependencia, pro_codigo, "
				+ "        pro_registro_snies, uaa_nombre, est_codigo, ese_nombre, mat_estado, cal_nombre, per_nombre, per_apellido, "
				+ "        per_estrato, per_genero, tii_nombre, per_identificacion, per_email_interno, pla_codigo, pla_total_creditos, "
				+ "        creditos_aprobados, mti_nombre) AS ( "
				+ "        SELECT pe.per_año AS anio, pe.per_nombre AS periodo, sed.sed_nombre, nat.nat_nombre, nia.nia_nombre, u2.uaa_codigo AS dependencia_codigo, "
				+ "                u2.uaa_nombre AS dependencia, pro.pro_codigo, pro.pro_registro_snies, u1.uaa_nombre, est.est_codigo, ese.ese_nombre, mat.mat_estado, "
				+ "                cal.cal_nombre, per.per_nombre, per.per_apellido, per.per_estrato, per.per_genero, tii.tii_nombre, per.per_identificacion, per.per_email_interno, "
				+ "                pla.pla_codigo, pla.pla_total_creditos, ( " + "                        SELECT "
				+ "                                SUM(creditos_aprobados) " + "                        FROM "
				+ "                                creditos_aprobados_por_calendario "
				+ "                        WHERE " + "                                est_codigo = est.est_codigo "
				+ "                                AND mat_codigo <= mat.mat_codigo "
				+ "                                AND pla_codigo = pla.pla_codigo "
				+ "                ) AS creditos_aprobados, " + "                mti.mti_nombre " + "        FROM "
				+ "                estudiante est WITH (NOLOCK) "
				+ "                LEFT JOIN inscripcion ins WITH (NOLOCK) ON est.ins_codigo = ins.ins_codigo "
				+ "                INNER JOIN matricula mat WITH (NOLOCK) ON est.est_codigo = mat.est_codigo "
				+ "                INNER JOIN calendario cal WITH (NOLOCK) ON mat.cal_codigo = cal.cal_codigo "
				+ "                INNER JOIN periodo pe WITH (NOLOCK) ON cal.per_codigo = pe.per_codigo "
				+ "                INNER JOIN programa pro WITH (NOLOCK) ON est.pro_codigo = pro.pro_codigo "
				+ "                INNER JOIN uaa u1 WITH (NOLOCK) ON pro.uaa_codigo = u1.uaa_codigo "
				+ "                INNER JOIN uaa u2 WITH (NOLOCK) ON u1.uaa_dependencia = u2.uaa_codigo "
				+ "                INNER JOIN sede sed WITH (NOLOCK) ON pro.sed_codigo = sed.sed_codigo "
				+ "                INNER JOIN nivel_academico nia WITH (NOLOCK) ON pro.nia_codigo = nia.nia_codigo "
				+ "                INNER JOIN nivel_academico_tipo nat WITH (NOLOCK) ON nia.nat_codigo = nat.nat_codigo "
				+ "                INNER JOIN persona per WITH (NOLOCK) ON est.per_codigo = per.per_codigo "
				+ "                INNER JOIN tipo_id tii WITH (NOLOCK) ON per.tii_codigo = tii.tii_codigo "
				+ "                INNER JOIN plan_estudiante ple WITH (NOLOCK) ON est.est_codigo = ple.est_codigo "
				+ "                INNER JOIN plan_academico pla WITH (NOLOCK) ON ple.pla_codigo = pla.pla_codigo "
				+ "                LEFT JOIN matricula_tipo mti WITH(NOLOCK) ON mat.mat_tipo = mti.mti_codigo "
				+ "                LEFT JOIN estudiante_estado ese WITH (NOLOCK) ON est.ese_codigo = ese.ese_codigo "
				+ "        WHERE " + "                pe.per_nombre BETWEEN '" + periodo + "' "
				+ "                AND '" + periodo + "' " + "                AND ple.ple_estado = 1 "
				+ "                AND mat.mat_estado = 'A' " + "                AND pro.pro_codigo IN( "
				+ "                        SELECT " + "                                * "
				+ "                        FROM " + "                                dbo.Split(" + programaCodigo
				+ ", ',') " + "                ) " + ") " + "SELECT " + "        * " + "FROM " + "        resultado "
				+ "WHERE " + "        creditos_aprobados >= pla_total_creditos " + "        AND est_codigo NOT IN ( "
				+ "                SELECT " + "                        gra.est_codigo " + "                FROM "
				+ "                        graduado gra WITH (NOLOCK) " + "                WHERE "
				+ "                        gra.est_codigo = est_codigo "
				+ "                        AND YEAR(gra.gra_fecha) <= anio "
				+ "                        AND MONTH(gra.gra_fecha) <= CASE "
				+ "                                SUBSTRING(periodo, LEN(periodo), 1) "
				+ "                                WHEN '1' THEN '6' " + "                                ELSE '12' "
				+ "                        END " + "        ) "
				+ "ORDER BY anio, periodo, sed_nombre, nat_nombre, nia_nombre, dependencia, uaa_nombre";
		return jdbcTemplate.query(sql, new ListadoEgresadosSetExtractor());

	}

}
