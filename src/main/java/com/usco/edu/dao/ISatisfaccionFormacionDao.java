package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.dto.ReporteCompetencia;
import com.usco.edu.entities.CompetenciaRespuesta;

public interface ISatisfaccionFormacionDao {
	
	public List<CompetenciaRespuesta> obtenerRespuestasTipoUnoIdentificacion(String id);
	
	public List<CompetenciaRespuesta> obtenerRespuestasTipoDosIdentificacion(String id);
	
	public List<CompetenciaRespuesta> obtenerRespuestasTipoTresIdentificacion(String id);
	
	public List<ReporteCompetencia> obtenerRerporteCompetencia(String inicio, String fin);

}
