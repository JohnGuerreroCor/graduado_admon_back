package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.EstudianteActivo;
import com.usco.edu.entities.Graduado;

public interface IGraduadoDao {
	
	public List<Graduado> buscarGraduadoPorIdentificacion(String id, String userdb);
	
	public List<EstudianteActivo> buscarGraduadoEstudianteActivo(String codigo, String userdb);
	
}
