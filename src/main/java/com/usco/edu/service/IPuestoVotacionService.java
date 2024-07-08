package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.GraduadosElecciones;
import com.usco.edu.entities.PuestoVotacion;

public interface IPuestoVotacionService {
	
	public List<PuestoVotacion> obtenerListadoPuestoVotacion(int programaCodigo);
	
	public List<GraduadosElecciones> obtenerListadoGraduadosElecciones();

}
