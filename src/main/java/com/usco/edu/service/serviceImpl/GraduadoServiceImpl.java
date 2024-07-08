package com.usco.edu.service.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IGraduadoDao;
import com.usco.edu.entities.EstudianteActivo;
import com.usco.edu.entities.Graduado;
import com.usco.edu.service.IGraduadoService;


@Service
public class GraduadoServiceImpl implements IGraduadoService{
	
	@Autowired
	private IGraduadoDao graduadoDao;

	@Override
	public List<Graduado> buscarGraduadoPorIdentificacion(String id, String userdb) {
		return graduadoDao.buscarGraduadoPorIdentificacion(id, userdb);
	}

	@Override
	public List<EstudianteActivo> buscarGraduadoEstudianteActivo(String codigo, String userdb) {
		
		return graduadoDao.buscarGraduadoEstudianteActivo(codigo, userdb);
		
	}

}
