package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.dto.ReporteCompetencia;
import com.usco.edu.entities.CompetenciaRespuesta;
import com.usco.edu.service.ISatisfaccionFormacionService;

@RestController
@RequestMapping(path = "satisfaccionformacion")
public class SatisfaccionFormacionRestController {
	
	@Autowired
	ISatisfaccionFormacionService satisfaccionFormacionService;
	
	@GetMapping(path = "obtener-respuestas-tipo-uno-identificacion/{id}")
	public List<CompetenciaRespuesta> obtenerRespuestasTipoUnoIdentificacion(@PathVariable String id) {
		
		return satisfaccionFormacionService.obtenerRespuestasTipoUnoIdentificacion(id);
		
	}
	
	@GetMapping(path = "obtener-respuestas-tipo-dos-identificacion/{id}")
	public List<CompetenciaRespuesta> obtenerRespuestasTipoDosIdentificacion(@PathVariable String id) {
		
		return satisfaccionFormacionService.obtenerRespuestasTipoDosIdentificacion(id);
		
	}
	
	@GetMapping(path = "obtener-respuestas-tipo-tres-identificacion/{id}")
	public List<CompetenciaRespuesta> obtenerRespuestasTipoTresIdentificacion(@PathVariable String id) {
		
		return satisfaccionFormacionService.obtenerRespuestasTipoTresIdentificacion(id);
		
	}
	
	@GetMapping(path = "obtener-reporte-competencia/{inicio}/{fin}")
	public List<ReporteCompetencia> obtenerRerporteCompetencia(@PathVariable String inicio, @PathVariable String fin) {
		
		return satisfaccionFormacionService.obtenerRerporteCompetencia(inicio, fin);
		
	}

}
