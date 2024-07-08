package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IFormacionAcademicaDao;
import com.usco.edu.entities.HistorialAcademico;
import com.usco.edu.entities.NivelAcademico;
import com.usco.edu.service.IFormacionAcademicaService;

@Service
public class FormacionAcademicaServiceImpl implements IFormacionAcademicaService{
	
	@Autowired
	IFormacionAcademicaDao formacionDao;

	@Override
	public List<NivelAcademico> obtenerNivelesAcademicos() {
		
		return formacionDao.obtenerNivelesAcademicos();
		
	}

	@Override
	public List<HistorialAcademico> obtenerHistorialAcademico(String id) {
		
		return formacionDao.obtenerHistorialAcademico(id);
		
	}

	@Override
	public List<HistorialAcademico> obtenerReporteHistorialAcademico(String inicio, String fin) {
		
		return formacionDao.obtenerReporteHistorialAcademico(inicio, fin);
		
	}
}
