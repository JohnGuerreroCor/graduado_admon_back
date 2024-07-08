package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IEgresadoDao;
import com.usco.edu.entities.ListadoEgresados;
import com.usco.edu.service.IEgresadoService;

@Service
public class EgresadoServiceImpl implements IEgresadoService {
	
	@Autowired
	private IEgresadoDao egresadoDao;

	@Override
	public List<ListadoEgresados> obtenerListadoEgresadosFacultad(String periodo, int programaCodigo) {
		
		return egresadoDao.obtenerListadoEgresadosFacultad(periodo, programaCodigo);
		
	}
}
