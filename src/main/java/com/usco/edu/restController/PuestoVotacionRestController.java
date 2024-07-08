package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.GraduadosElecciones;
import com.usco.edu.entities.PuestoVotacion;
import com.usco.edu.service.IPuestoVotacionService;

@RestController
@RequestMapping(path = "puestoVotacion")
public class PuestoVotacionRestController {
	
	@Autowired
	IPuestoVotacionService puestoVotacionService;
	
	@GetMapping(path = "obtener-puesto-votacion/{programaCodigo}")
	public List<PuestoVotacion> obtenerListadoPuestoVotacion(@PathVariable int programaCodigo) {
		return puestoVotacionService.obtenerListadoPuestoVotacion(programaCodigo);
	}
	
	@GetMapping(path = "obtener-listado-graduados-elecciones")
	public List<GraduadosElecciones> obtenerListadoGraduadosElecciones() {
		return puestoVotacionService.obtenerListadoGraduadosElecciones();
	}

}
