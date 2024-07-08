package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IPuestoVotacionDao;
import com.usco.edu.entities.GraduadosElecciones;
import com.usco.edu.entities.PuestoVotacion;
import com.usco.edu.service.IPuestoVotacionService;

@Service
public class PuestoVotacionServiceImpl implements IPuestoVotacionService{
	
	@Autowired
	private IPuestoVotacionDao puestoVotacionDao;

	@Override
	public List<PuestoVotacion> obtenerListadoPuestoVotacion(int programaCodigo) {
		
		return puestoVotacionDao.obtenerListadoPuestoVotacion(programaCodigo);
		
	}

	@Override
	public List<GraduadosElecciones> obtenerListadoGraduadosElecciones() {
		
		return puestoVotacionDao.obtenerListadoGraduadosElecciones();
		
	}
}
