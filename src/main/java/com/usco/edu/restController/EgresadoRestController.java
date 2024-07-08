package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.ListadoEgresados;
import com.usco.edu.service.IEgresadoService;

@RestController
@RequestMapping(path = "egresado")
public class EgresadoRestController {
	
	@Autowired
	IEgresadoService egresadoService;
	
	
	@GetMapping(path = "obtener-listado-egresados/{periodo}/{programaCodigo}")
	public List<ListadoEgresados> obtenerListadoEgresadosFacultad(@PathVariable String periodo, @PathVariable int programaCodigo) {
		
		return egresadoService.obtenerListadoEgresadosFacultad(periodo, programaCodigo);
		
	}

}
