package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IInformacionAcademicaDao;
import com.usco.edu.entities.DatosComplementarios;
import com.usco.edu.entities.HabilidadInformatica;
import com.usco.edu.entities.Idioma;
import com.usco.edu.entities.RegistroEducativo;
import com.usco.edu.service.IInformacionAcademicaService;

@Service
public class InformacionAcademicaServiceImpl implements IInformacionAcademicaService {
	
	@Autowired
	private IInformacionAcademicaDao informacionAcademicaDao;

	@Override
	public List<HabilidadInformatica> obtenerListadoHabilidadesInformaticas(String id) {
		
		return informacionAcademicaDao.obtenerListadoHabilidadesInformaticas(id);
		
	}
	
	@Override
	public List<HabilidadInformatica> obtenerReporteHabilidadesInformaticas(String inicio, String fin) {
		
		return informacionAcademicaDao.obtenerReporteHabilidadesInformaticas(inicio, fin);
		
	}

	@Override
	public List<Idioma> obtenerListadoIdiomas(String id) {
		
		return informacionAcademicaDao.obtenerListadoIdiomas(id);
		
	}
	
	@Override
	public List<Idioma> obtenerReporteIdiomas(String inicio, String fin) {
		
		return informacionAcademicaDao.obtenerReporteIdiomas(inicio, fin);
		
	}

	@Override
	public List<RegistroEducativo> obtenerListadoRegistroEducativo(String id) {
		
		return informacionAcademicaDao.obtenerListadoRegistroEducativo(id);
		
	}
	
	@Override
	public List<RegistroEducativo> obtenerReporteRegistroEducativo(String inicio, String fin) {
		
		return informacionAcademicaDao.obtenerReporteRegistroEducativo(inicio, fin);
		
	}

	@Override
	public List<DatosComplementarios> obtenerListadoDatosComplementarios(String id) {
		
		return informacionAcademicaDao.obtenerListadoDatosComplementarios(id);
		
	}

	@Override
	public List<DatosComplementarios> obtenerReporteDatosComplementarios(String inicio, String fin) {
		
		return informacionAcademicaDao.obtenerReporteDatosComplementarios(inicio, fin);
		
	}
	
}
