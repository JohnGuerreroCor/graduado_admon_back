package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.ISatisfaccionFormacionDao;
import com.usco.edu.dto.ReporteCompetencia;
import com.usco.edu.entities.CompetenciaRespuesta;
import com.usco.edu.service.ISatisfaccionFormacionService;

@Service
public class SatisfaccionFormacionServiceImpl implements ISatisfaccionFormacionService {
	
	@Autowired
	private ISatisfaccionFormacionDao satisfaccionFormacionDao;

	@Override
	public List<CompetenciaRespuesta> obtenerRespuestasTipoUnoIdentificacion(String id) {
		
		return satisfaccionFormacionDao.obtenerRespuestasTipoUnoIdentificacion(id);
		
	}
	
	@Override
	public List<CompetenciaRespuesta> obtenerRespuestasTipoDosIdentificacion(String id) {
		
		return satisfaccionFormacionDao.obtenerRespuestasTipoDosIdentificacion(id);
		
	}

	@Override
	public List<CompetenciaRespuesta> obtenerRespuestasTipoTresIdentificacion(String id) {
		
		return satisfaccionFormacionDao.obtenerRespuestasTipoTresIdentificacion(id);
		
	}

	@Override
	public List<ReporteCompetencia> obtenerRerporteCompetencia(String inicio, String fin) {
		
		return satisfaccionFormacionDao.obtenerRerporteCompetencia(inicio, fin);
		
	}
}
