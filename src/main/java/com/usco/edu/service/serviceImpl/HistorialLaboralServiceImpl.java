package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IHistorialLaboralDao;
import com.usco.edu.entities.HistorialLaboral;
import com.usco.edu.service.IHistorialLaboralService;

@Service
public class HistorialLaboralServiceImpl implements IHistorialLaboralService {
	
	@Autowired
	private IHistorialLaboralDao historialLaboralDao;

	@Override
	public List<HistorialLaboral> obtenerHistorialLaboral(String id) {
		
		return historialLaboralDao.obtenerHistorialLaboral(id);
		
	}

	@Override
	public List<HistorialLaboral> obtenerReporteHistorialLaboral(String inicio, String fin) {

		return historialLaboralDao.obtenerReporteHistorialLaboral(inicio, fin);
		
	}
}
