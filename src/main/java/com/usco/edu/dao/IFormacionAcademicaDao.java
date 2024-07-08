package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.HistorialAcademico;
import com.usco.edu.entities.NivelAcademico;

public interface IFormacionAcademicaDao {
	
	public List<NivelAcademico> obtenerNivelesAcademicos();
	
	public List<HistorialAcademico> obtenerHistorialAcademico(String id);
	
	public List<HistorialAcademico> obtenerReporteHistorialAcademico(String inicio, String fin);

}
