package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.dto.ReporteExpectativaCapacitacion;
import com.usco.edu.entities.ExpectativaCapacitacionEscala;
import com.usco.edu.entities.ExpectativaCompetenciaRespuesta;
import com.usco.edu.service.IExpectativaCapacitacionService;

@RestController
@RequestMapping(path = "expectativacapacitacion")
public class ExpectativaCapacitacionRestController {
	
	@Autowired
	IExpectativaCapacitacionService expectativaCapacitacionService;
	
	@GetMapping(path = "obtener-escala-pregunta/{codigo}")
	public List<ExpectativaCapacitacionEscala> obtenerEscalaPregunta(@PathVariable int codigo) {
		
		return expectativaCapacitacionService.obtenerEscalaPregunta(codigo);
		
	}
	
	@GetMapping(path = "obtener-respuestas-identificacion/{id}")
	public List<ExpectativaCompetenciaRespuesta> obtenerRespuestasIdentificacion(@PathVariable String id) {
		
		return expectativaCapacitacionService.obtenerRespuestasIdentificacion(id);
		
	}
	
	@GetMapping(path = "obtener-reporte-excpectativa-capacitacion/{inicio}/{fin}")
	public List<ReporteExpectativaCapacitacion> obtenerRerporteExpectativaCapacitacion(@PathVariable String inicio, @PathVariable String fin) {
		
		return expectativaCapacitacionService.obtenerRerporteExpectativaCapacitacion(inicio, fin);
		
	}

}
