package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.HistorialLaboral;
import com.usco.edu.service.IHistorialLaboralService;

@RestController
@RequestMapping(path = "historialLaboral")
public class HistorialLaboralRestController {
	
	@Autowired
	IHistorialLaboralService historialLaboralService;
	
	@GetMapping(path = "obtener-historial-laboral/{id}")
	public List<HistorialLaboral> obtenerHistorialLaboral(@PathVariable String id) {
		
		return historialLaboralService.obtenerHistorialLaboral(id);
		
	}
	
	@GetMapping(path = "obtener-reporte-historial-laboral/{inicio}/{fin}")
	public List<HistorialLaboral> obtenerReporteHistorialLaboral(@PathVariable String inicio, @PathVariable String fin) {
		
		return historialLaboralService.obtenerReporteHistorialLaboral(inicio, fin);
		
	}

}
