package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.Facultad;
import com.usco.edu.entities.NivelAcademico;
import com.usco.edu.entities.Periodo;
import com.usco.edu.entities.ProgramaGeneral;
import com.usco.edu.service.IConsultaGeneralService;

@RestController
@RequestMapping(path = "consultageneral")
public class ConsultaGeneralRestController {
	
	@Autowired
	IConsultaGeneralService consultaGeneralService;
	
	
	@GetMapping(path = "obtener-periodos")
	public List<Periodo> obtenerPeriodos() {
		
		return consultaGeneralService.obtenerPeriodos();
		
	}
	
	@GetMapping(path = "obtener-facultades")
	public List<Facultad> obtenerFacultades() {
		
		return consultaGeneralService.obtenerFacultades();
		
	}
	
	@GetMapping(path = "obtener-programas-facultad/{sedeCodigo}/{nivelAcademicoCodigo}/{dependenciaCodigo}")
	public List<ProgramaGeneral> obtenerProgramasFacultad(@PathVariable int sedeCodigo, @PathVariable int nivelAcademicoCodigo, @PathVariable int dependenciaCodigo) {
		
		return consultaGeneralService.obtenerProgramasFacultad(sedeCodigo, nivelAcademicoCodigo, dependenciaCodigo);
		
	}
	
	@GetMapping(path = "obtener-niveles-academicos/{nivelFormacionCodigo}")
	public List<NivelAcademico> obtenerNivelesAcademicos(@PathVariable int nivelFormacionCodigo) {
		
		return consultaGeneralService.obtenerNivelesAcademicos(nivelFormacionCodigo);
		
	}

}
