package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IConsultaGeneralDao;
import com.usco.edu.entities.Facultad;
import com.usco.edu.entities.NivelAcademico;
import com.usco.edu.entities.Periodo;
import com.usco.edu.entities.ProgramaGeneral;
import com.usco.edu.service.IConsultaGeneralService;

@Service
public class ConsultaGeneralServiceImpl implements IConsultaGeneralService {
	
	@Autowired
	private IConsultaGeneralDao consultaGeneralDao;

	@Override
	public List<Periodo> obtenerPeriodos() {
		
		return consultaGeneralDao.obtenerPeriodos();
		
	}

	@Override
	public List<Facultad> obtenerFacultades() {
		
		return consultaGeneralDao.obtenerFacultades();
		
	}

	@Override
	public List<ProgramaGeneral> obtenerProgramasFacultad(int sedeCodigo, int nivelAcademicoCodigo, int dependenciaCodigo) {
		
		return consultaGeneralDao.obtenerProgramasFacultad(sedeCodigo, nivelAcademicoCodigo, dependenciaCodigo);
		
	}

	@Override
	public List<NivelAcademico> obtenerNivelesAcademicos(int nivelFormacionCodigo) {
		
		return consultaGeneralDao.obtenerNivelesAcademicos(nivelFormacionCodigo);
		
	}
}
