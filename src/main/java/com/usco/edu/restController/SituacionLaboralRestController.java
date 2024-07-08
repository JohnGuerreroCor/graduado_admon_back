package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.dto.ReporteSituacionLaboral;
import com.usco.edu.entities.SituacionLaboralRespuesta;
import com.usco.edu.service.ISituacionLaboralService;

@RestController
@RequestMapping(path = "situacionlaboral")
public class SituacionLaboralRestController {
	
	@Autowired
	ISituacionLaboralService situacionLaboralService;
	
	@GetMapping(path = "obtener-respuestas-identificacion/{id}")
	public List<SituacionLaboralRespuesta> obtenerRespuestasIdentificacion(@PathVariable String id) {
		
		return situacionLaboralService.obtenerRespuestasIdentificacion(id);
		
	}
	
	@GetMapping(path = "obtener-reporte-situacion-laboral/{inicio}/{fin}")
	public List<ReporteSituacionLaboral> obtenerRerporteSituacionLaboral(@PathVariable String inicio, @PathVariable String fin) {
		
		return situacionLaboralService.obtenerRerporteSituacionLaboral(inicio, fin);
		
	}

}
