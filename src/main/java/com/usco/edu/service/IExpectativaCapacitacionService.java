package com.usco.edu.service;

import java.util.List;

import com.usco.edu.dto.ReporteExpectativaCapacitacion;
import com.usco.edu.entities.ExpectativaCapacitacionEscala;
import com.usco.edu.entities.ExpectativaCompetenciaRespuesta;

public interface IExpectativaCapacitacionService {
	
	public List<ExpectativaCapacitacionEscala> obtenerEscalaPregunta(int preguntaCodigo);
	
	public List<ExpectativaCompetenciaRespuesta> obtenerRespuestasIdentificacion(String id);
	
	public List<ReporteExpectativaCapacitacion> obtenerRerporteExpectativaCapacitacion(String inicio, String fin);

}
