package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.dto.ReporteSituacionLaboral;
import com.usco.edu.entities.SituacionLaboralRespuesta;

public interface ISituacionLaboralDao {
	
	public List<SituacionLaboralRespuesta> obtenerRespuestasIdentificacion(String id);
	
	public List<ReporteSituacionLaboral> obtenerRerporteSituacionLaboral(String inicio, String fin);

}
