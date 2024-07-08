package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.DatosComplementarios;
import com.usco.edu.entities.HabilidadInformatica;
import com.usco.edu.entities.Idioma;
import com.usco.edu.entities.RegistroEducativo;
import com.usco.edu.service.IInformacionAcademicaService;

@RestController
@RequestMapping(path = "informacionAcademica")
public class InformacionAcademicaRestController {
	
	@Autowired
	IInformacionAcademicaService informacionAcademicaService;
	
	@GetMapping(path = "obtener-habilidades-informaticas/{id}")
	public List<HabilidadInformatica> obtenerListadoHabilidadesInformaticas(@PathVariable String id) {
		
		return informacionAcademicaService.obtenerListadoHabilidadesInformaticas(id);
		
	}
	
	@GetMapping(path = "obtener-reporte-habilidades-informaticas/{inicio}/{fin}")
	public List<HabilidadInformatica> obtenerReporteHabilidadesInformaticas(@PathVariable String inicio, @PathVariable String fin) {
		
		return informacionAcademicaService.obtenerReporteHabilidadesInformaticas(inicio, fin);
		
	}
	
	@GetMapping(path = "obtener-idiomas/{id}")
	public List<Idioma> obtenerListadoIdiomas(@PathVariable String id) {
		
		return informacionAcademicaService.obtenerListadoIdiomas(id);
		
	}
	
	@GetMapping(path = "obtener-reporte-idiomas/{inicio}/{fin}")
	public List<Idioma> obtenerReporteIdiomas(@PathVariable String inicio, @PathVariable String fin) {
		
		return informacionAcademicaService.obtenerReporteIdiomas(inicio, fin);
		
	}
	
	@GetMapping(path = "obtener-registro-educativo/{id}")
	public List<RegistroEducativo> obtenerListadoRegistroEducativo(@PathVariable String id) {
		
		return informacionAcademicaService.obtenerListadoRegistroEducativo(id);
		
	}
	
	@GetMapping(path = "obtener-reporte-registro-educativo/{inicio}/{fin}")
	public List<RegistroEducativo> obtenerReporteRegistroEducativo(@PathVariable String inicio, @PathVariable String fin) {
		
		return informacionAcademicaService.obtenerReporteRegistroEducativo(inicio, fin);
		
	}
	
	@GetMapping(path = "obtener-datos-complementarios/{id}")
	public List<DatosComplementarios> obtenerListadoDatosComplementarios(@PathVariable String id) {
		
		return informacionAcademicaService.obtenerListadoDatosComplementarios(id);
		
	}
	
	
	@GetMapping(path = "obtener-reporte-datos-complementarios/{inicio}/{fin}")
	public List<DatosComplementarios> obtenerReporteDatosComplementarios(@PathVariable String inicio,@PathVariable String fin) {
		
		return informacionAcademicaService.obtenerReporteDatosComplementarios(inicio, fin);
		
	}

}
