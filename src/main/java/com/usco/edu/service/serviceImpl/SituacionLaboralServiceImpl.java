package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.ISituacionLaboralDao;
import com.usco.edu.dto.ReporteSituacionLaboral;
import com.usco.edu.entities.SituacionLaboralRespuesta;
import com.usco.edu.service.ISituacionLaboralService;

@Service
public class SituacionLaboralServiceImpl implements ISituacionLaboralService {
	
	@Autowired
	private ISituacionLaboralDao situacionLaboralDao;


	@Override
	public List<SituacionLaboralRespuesta> obtenerRespuestasIdentificacion(String id) {
		
		return situacionLaboralDao.obtenerRespuestasIdentificacion(id);
		
	}


	@Override
	public List<ReporteSituacionLaboral> obtenerRerporteSituacionLaboral(String inicio, String fin) {
	
		return situacionLaboralDao.obtenerRerporteSituacionLaboral(inicio, fin);
		
	}
}
