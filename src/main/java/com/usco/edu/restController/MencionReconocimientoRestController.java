package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.MencionReconocimiento;
import com.usco.edu.service.IMencionReconocimientoService;

@RestController
@RequestMapping(path = "mencionreconocimiento")
public class MencionReconocimientoRestController {
	
	@Autowired
	IMencionReconocimientoService mencionReconocimientoService;
	
	
	@GetMapping(path = "obtener-mencion-reconocimiento/{id}")
	public List<MencionReconocimiento> obtenerMencionesReconocimiento(@PathVariable String id) {
		
		return mencionReconocimientoService.obtenerMencionesReconocimiento(id);
		
	}
	
	
	@GetMapping(path = "obtener-reporte-mencion-reconocimiento/{inicio}/{fin}")
	public List<MencionReconocimiento> obtenerMencionesReconocimiento(@PathVariable String inicio, @PathVariable String fin) {
		
		return mencionReconocimientoService.obtenerReporteMencionesReconocimiento(inicio, fin);
		
	}

}
