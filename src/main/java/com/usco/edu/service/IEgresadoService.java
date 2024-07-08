package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.ListadoEgresados;

public interface IEgresadoService {
	
	public List<ListadoEgresados> obtenerListadoEgresadosFacultad(String periodo, int programaCodigo);

}
