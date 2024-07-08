package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IPuestoVotacionDao;
import com.usco.edu.entities.GraduadosElecciones;
import com.usco.edu.entities.PuestoVotacion;
import com.usco.edu.resultSetExtractor.GraduadosEleccionesSetExtractor;
import com.usco.edu.resultSetExtractor.PuestoVotacionSetExtractor;

@Repository
public class PuestoVotacionDaoImpl implements IPuestoVotacionDao{
	
	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<PuestoVotacion> obtenerListadoPuestoVotacion(int programaCodigo) {
		
		//HACER INNER JOIN CON LA TABLA PUESTO DE VOTACION GRADUADOS DEL ESQUEMA DBO SI SE IMPLEMENTA NUEVAMENTE EL SISTEMA
		
		String sql = "SELECT  ti.tii_nombre_corto, p.per_codigo, p.per_identificacion, p.per_apellido, p.per_nombre, u.uaa_nombre, s.sed_nombre, vp.vop_nombre "
				+ "FROM persona p "
				+ "INNER JOIN tipo_id ti ON p.tii_codigo = ti.tii_codigo "
				+ "INNER JOIN estudiante e ON p.per_codigo = e.per_codigo "
				+ "INNER JOIN programa pr ON e.pro_codigo = pr.pro_codigo "
				+ "inner join sede s on pr.sed_codigo = s.sed_codigo "
				+ "inner join uaa u on pr.uaa_codigo = u.uaa_codigo "
				+ "INNER JOIN nivel_academico na ON pr.nia_codigo = na.nia_codigo "
				+ "INNER JOIN graduado g ON e.est_codigo = g.est_codigo "
				+ "INNER JOIN votacion_puesto vp ON pr.sed_codigo = vp.vop_codigo "
				+ "WHERE pr.pro_codigo = " + programaCodigo + " "
				+ "GROUP BY ti.tii_nombre_corto, p.per_codigo, p.per_identificacion, p.per_apellido, p.per_nombre, u.uaa_nombre, s.sed_nombre, vp.vop_nombre "
				+ "ORDER BY p.per_apellido ASC;";
		return jdbcTemplate.query(sql, new PuestoVotacionSetExtractor());
		
	}

	@Override
	public List<GraduadosElecciones> obtenerListadoGraduadosElecciones() {
		
		String sql = "WITH GraduadosConNumeros AS ( "
				+ "    SELECT "
				+ "        CASE "
				+ "            WHEN s.sed_codigo IN (1, 2, 3, 4) THEN s.sed_nombre "
				+ "            ELSE 'NEIVA' "
				+ "        END AS sed_nombre, "
				+ "        u2.uaa_nombre AS facultad, "
				+ "        nat.nat_nombre, "
				+ "        na.nia_nombre, "
				+ "        u.uaa_nombre AS programa, "
				+ "        p.per_nombre, "
				+ "        p.per_apellido, "
				+ "        ti.tii_nombre_corto, "
				+ "        p.per_identificacion, "
				+ "        ROW_NUMBER() OVER ( "
				+ "            PARTITION BY p.per_identificacion "
				+ "            ORDER BY "
				+ "                g.gra_fecha DESC "
				+ "        ) AS NumeroFila "
				+ "    FROM "
				+ "        persona p "
				+ "        INNER JOIN tipo_id ti ON p.tii_codigo = ti.tii_codigo "
				+ "        INNER JOIN estudiante e ON p.per_codigo = e.per_codigo "
				+ "        INNER JOIN programa pr ON e.pro_codigo = pr.pro_codigo "
				+ "        INNER JOIN nivel_academico na ON pr.nia_codigo = na.nia_codigo "
				+ "        INNER JOIN nivel_academico_tipo nat on na.nat_codigo = nat.nat_codigo "
				+ "        INNER JOIN graduado g ON e.est_codigo = g.est_codigo "
				+ "        INNER JOIN sede s on pr.sed_codigo = s.sed_codigo "
				+ "        INNER JOIN uaa u on pr.uaa_codigo = u.uaa_codigo "
				+ "        INNER JOIN uaa u2 on u.uaa_dependencia = u2.uaa_codigo "
				+ "    WHERE "
				+ "        pr.pro_propio = 'S' "
				+ "        AND nat.nat_codigo in (1, 2) "
				+ ") "
				+ "SELECT "
				+ "    sed_nombre, "
				+ "    facultad, "
				+ "    nat_nombre, "
				+ "    nia_nombre, "
				+ "    programa, "
				+ "    per_nombre, "
				+ "    per_apellido, "
				+ "    tii_nombre_corto, "
				+ "    per_identificacion "
				+ "FROM "
				+ "    GraduadosConNumeros "
				+ "WHERE "
				+ "    NumeroFila = 1 "
				+ "ORDER BY "
				+ "    sed_nombre, facultad asc;";
		return jdbcTemplate.query(sql, new GraduadosEleccionesSetExtractor());
		
	}
	
}
