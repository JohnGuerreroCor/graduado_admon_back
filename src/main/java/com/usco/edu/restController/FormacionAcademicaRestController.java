package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.HistorialAcademico;
import com.usco.edu.entities.NivelAcademico;
import com.usco.edu.service.IFormacionAcademicaService;

@RestController
@RequestMapping(path = "formacionAcademica")
public class FormacionAcademicaRestController {
	
	@Autowired
	IFormacionAcademicaService formacionService;
	
	@GetMapping(path = "obtener-niveles-academicos")
	public List<NivelAcademico> obtenerNivelesAcademicos() {
		
		return formacionService.obtenerNivelesAcademicos();
		
	}
	
	@GetMapping(path = "obtener-historial-academico/{id}")
	public List<HistorialAcademico> obtenerHistorialAcademico(@PathVariable String id) {
		
		return formacionService.obtenerHistorialAcademico(id);
		
	}
	
	@GetMapping(path = "obtener-reporte-historial-academico/{inicio}/{fin}")
	public List<HistorialAcademico> obtenerReporteHistorialAcademico(@PathVariable String inicio, @PathVariable String fin) {
		
		return formacionService.obtenerReporteHistorialAcademico(inicio, fin);
		
	}

}
