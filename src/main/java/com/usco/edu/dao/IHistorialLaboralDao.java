package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.HistorialLaboral;

public interface IHistorialLaboralDao {
	
	public List<HistorialLaboral> obtenerHistorialLaboral(String id);
	
	public List<HistorialLaboral> obtenerReporteHistorialLaboral(String inicio, String fin);

}
