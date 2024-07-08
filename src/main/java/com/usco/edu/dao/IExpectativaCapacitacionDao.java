package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.dto.ReporteExpectativaCapacitacion;
import com.usco.edu.entities.ExpectativaCapacitacionEscala;
import com.usco.edu.entities.ExpectativaCompetenciaRespuesta;

public interface IExpectativaCapacitacionDao {
	
	public List<ExpectativaCapacitacionEscala> obtenerEscalaPregunta(int preguntaCodigo);
	
	public List<ExpectativaCompetenciaRespuesta> obtenerRespuestasIdentificacion(String id);
	
	public List<ReporteExpectativaCapacitacion> obtenerRerporteExpectativaCapacitacion(String inicio, String fin);

}
