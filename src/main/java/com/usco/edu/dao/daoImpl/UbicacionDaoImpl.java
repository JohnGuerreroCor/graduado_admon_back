package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IUbicacionDao;
import com.usco.edu.entities.Bloque;
import com.usco.edu.entities.Departamento;
import com.usco.edu.entities.Municipio;
import com.usco.edu.entities.Oficina;
import com.usco.edu.entities.Pais;
import com.usco.edu.entities.SedeCarnet;
import com.usco.edu.entities.SubSede;
import com.usco.edu.resultSetExtractor.PaisSetExtractor;
import com.usco.edu.resultSetExtractor.DepartamentoSetExtractor;
import com.usco.edu.resultSetExtractor.MunicipioSetExtractor;
import com.usco.edu.resultSetExtractor.SedeCarnetSetExtractor;
import com.usco.edu.resultSetExtractor.BloqueSetExtractor;
import com.usco.edu.resultSetExtractor.OficinaSetExtractor;
import com.usco.edu.resultSetExtractor.SubSedeSetExtractor;

@Repository
public class UbicacionDaoImpl implements IUbicacionDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<Departamento> obtenerDepartamentosPorPais(int paiCodigo, String userdb) {

		String sql = "select * from departamento d " + "inner join pais p on d.pai_codigo = p.pai_codigo "
				+ "where d.pai_codigo = " + paiCodigo + " ";
		return jdbcTemplate.query(sql, new DepartamentoSetExtractor());

	}

	@Override
	public List<Municipio> obtenerMunicipiosPorDepartamento(int depCodigo, String userdb) {

		String sql = "select * FROM municipio m " + "inner join departamento d on m.dep_codigo = d.dep_codigo "
				+ "inner join pais p on d.pai_codigo = p.pai_codigo " + "where m.dep_codigo = " + depCodigo + " ";
		return jdbcTemplate.query(sql, new MunicipioSetExtractor());

	}

	@Override
	public List<Departamento> obtenerDepartamentosPorMunicipio(int munCodigo, String userdb) {

		String sql = "select * from departamento d " + "inner join pais p on d.pai_codigo = p.pai_codigo "
				+ "inner join municipio m on d.dep_codigo = m.dep_codigo " + "where m.mun_codigo =" + munCodigo + " ";

		return jdbcTemplate.query(sql, new DepartamentoSetExtractor());

	}

	@Override
	public List<Pais> obtenerPaisesPorDepartamento(int depCodigo, String userdb) {

		String sql = "select * from pais p " + "inner join departamento d on p.pai_codigo = d.pai_codigo "
				+ "where d.dep_codigo =" + depCodigo + " ";

		return jdbcTemplate.query(sql, new PaisSetExtractor());

	}

	@Override
	public List<Pais> obtenerPaises(String userdb) {

		String sql = "select * from pais p";
		return jdbcTemplate.query(sql, new PaisSetExtractor());

	}

	@Override
	public List<Municipio> obtenerMunicipios(String userdb) {

		String sql = "select * from municipio m " + "left join departamento d on m.dep_codigo = d.dep_codigo "
				+ "left join pais p on d.pai_codigo = p.pai_codigo ";
		return jdbcTemplate.query(sql, new MunicipioSetExtractor());

	}

	@Override
	public List<SedeCarnet> obtenerSedes(String userdb) {

		String sql = "select * from dbo.sede s where s.sed_estado = 1 and s.sippa_sed_codigo is not null";
		return jdbcTemplate.query(sql, new SedeCarnetSetExtractor());

	}

	@Override
	public List<SubSede> obtenerSubSedes(String userdb) {

		String sql = "select * from dbo.sub_sede ss";
		return jdbcTemplate.query(sql, new SubSedeSetExtractor());

	}

	@Override
	public List<Bloque> obtenerBloques(String userdb) {

		String sql = "select * from dbo.bloque b where b.blo_estado = 1 and b.blo_estado is not null";
		return jdbcTemplate.query(sql, new BloqueSetExtractor());

	}

	@Override
	public List<Oficina> obtenerOficinas(String userdb) {

		String sql = "select * from uaa u where u.uaa_dependencia is not null and u.uat_codigo in (1,2,6,9,11) and u.sed_codigo in (1,2,3,4) and u.uaa_estado = 1";
		return jdbcTemplate.query(sql, new OficinaSetExtractor());

	}

	@Override
	public List<SubSede> buscarSubSedePorSede(int codigo, String userdb) {

		String sql = "select * from dbo.sub_sede ss where ss.sed_codigo = " + codigo + " ";
		return jdbcTemplate.query(sql, new SubSedeSetExtractor());

	}

	@Override
	public List<Bloque> buscarBloquePorSubSede(int codigo, String userdb) {

		String sql = "select * from dbo.bloque b where b.blo_estado = 1 and b.blo_estado is not null and b.sus_codigo = "
				+ codigo + " ";
		return jdbcTemplate.query(sql, new BloqueSetExtractor());

	}

	@Override
	public List<Oficina> buscarOficinaPorSede(int codigo, String userdb) {

		String sql = "select * from uaa u where u.sed_codigo = " + codigo
				+ " and u.uaa_dependencia is not null and u.uat_codigo in (1,2,6,9,11,22) and u.sed_codigo in (1,2,3,4) and u.uaa_estado = 1";
		return jdbcTemplate.query(sql, new OficinaSetExtractor());

	}

}
