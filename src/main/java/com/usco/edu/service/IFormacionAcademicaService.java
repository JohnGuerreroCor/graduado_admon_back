package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.HistorialAcademico;
import com.usco.edu.entities.NivelAcademico;

public interface IFormacionAcademicaService {
	
	public List<NivelAcademico> obtenerNivelesAcademicos();
	
	public List<HistorialAcademico> obtenerHistorialAcademico(String id);
	
	public List<HistorialAcademico> obtenerReporteHistorialAcademico(String inicio, String fin);

}
