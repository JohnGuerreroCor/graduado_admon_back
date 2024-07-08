package com.usco.edu.service;
import java.util.List;

import com.usco.edu.entities.EstudianteActivo;
import com.usco.edu.entities.Graduado;

public interface IGraduadoService {
	
	public List<Graduado> buscarGraduadoPorIdentificacion(String id, String userdb);
	
	public List<EstudianteActivo> buscarGraduadoEstudianteActivo(String codigo, String userdb);
}
