package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.Pais;
import com.usco.edu.entities.Departamento;
import com.usco.edu.entities.Municipio;
import com.usco.edu.entities.SedeCarnet;
import com.usco.edu.entities.SubSede;
import com.usco.edu.entities.Bloque;
import com.usco.edu.entities.Oficina;

public interface IUbicacionDao {
	
	//UBICACION GEOGRÁFICA
	
	public List<Pais> obtenerPaises(String userdb);
	
	public List<Departamento> obtenerDepartamentosPorPais(int paiCodigo, String userdb);
	
	public List<Municipio> obtenerMunicipiosPorDepartamento(int depCodigo, String userdb);
	
	public List<Departamento> obtenerDepartamentosPorMunicipio(int munCodigo, String userdb);
	
	public List<Pais> obtenerPaisesPorDepartamento(int depCodigo, String userdb);
	
	public List<Municipio> obtenerMunicipios(String userdb);
	
	//LISTAR TODAS LAS CATEGORIAS
	
	public List<SedeCarnet> obtenerSedes(String userdb);
	
	public List<SubSede> obtenerSubSedes(String userdb);
	
	public List<Bloque> obtenerBloques(String userdb);
	
	public List<Oficina> obtenerOficinas(String userdb);
	
	//BUSCAR POR CATEGORIA PADRE A HIJA
	
	public List<SubSede> buscarSubSedePorSede(int codigo, String userdb);
	
	public List<Bloque> buscarBloquePorSubSede(int codigo, String userdb);
	
	public List<Oficina> buscarOficinaPorSede(int codigo, String userdb);
	

}
