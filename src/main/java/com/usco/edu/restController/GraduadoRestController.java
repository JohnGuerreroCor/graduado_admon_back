package com.usco.edu.restController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.EstudianteActivo;
import com.usco.edu.entities.Graduado;
import com.usco.edu.service.IGraduadoService;

@RestController
@RequestMapping(path = "graduado")
public class GraduadoRestController {
	
	@Autowired
	IGraduadoService graduadoService;
	
	@GetMapping(path = "obtener-graduado/{codigo}/{username}")
	public List<Graduado> buscarGraduadoPorIdentificacion(@PathVariable String codigo, @PathVariable String username) {
		return graduadoService.buscarGraduadoPorIdentificacion(codigo, username);
	}
	
	
	@GetMapping(path = "obtener-graduado-estudiante-activo/{codigo}/{username}")
	public List<EstudianteActivo> buscarGraduadoEstudianteActivo(@PathVariable String codigo, @PathVariable String username) {
		return graduadoService.buscarGraduadoEstudianteActivo(codigo, username);
	}
	
}
