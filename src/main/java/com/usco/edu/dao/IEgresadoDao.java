package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.ListadoEgresados;

public interface IEgresadoDao {
	
	public List<ListadoEgresados> obtenerListadoEgresadosFacultad(String periodo, int programaCodigo);

}
