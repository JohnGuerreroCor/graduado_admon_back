package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.GraduadosElecciones;
import com.usco.edu.entities.PuestoVotacion;

public interface IPuestoVotacionDao {
	
	public List<PuestoVotacion> obtenerListadoPuestoVotacion(int programaCodigo);
	
	public List<GraduadosElecciones> obtenerListadoGraduadosElecciones();
	
}
