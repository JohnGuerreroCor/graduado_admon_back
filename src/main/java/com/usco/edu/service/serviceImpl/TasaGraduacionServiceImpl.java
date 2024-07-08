package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.ITasaGraduacionDao;
import com.usco.edu.entities.GraduadosPeriodoAcademico;
import com.usco.edu.entities.MatriculadosPrimerIngreso;
import com.usco.edu.entities.TasaGraduacionPeriodo;
import com.usco.edu.entities.TasaGraduacionPersonas;
import com.usco.edu.entities.TasaGraduacionSemestre;
import com.usco.edu.service.ITasaGraduacionService;

@Service
public class TasaGraduacionServiceImpl implements ITasaGraduacionService{
	
	@Autowired
	private ITasaGraduacionDao tasaGraduacionDao;
	
	@Override
	public List<TasaGraduacionSemestre> obtenerInformacionPrograma(int programaCodigo) {
		
		return tasaGraduacionDao.obtenerInformacionPrograma(programaCodigo);
		
	}
	
	@Override
	public List<MatriculadosPrimerIngreso> obtenerMatriculadosPrimerIngreso(int programaCodigo) {
		
		return tasaGraduacionDao.obtenerMatriculadosPrimerIngreso(programaCodigo);
		
	}

	@Override
	public List<GraduadosPeriodoAcademico> obtenerGraduadosPeriodoAcademico(int programaCodigo) {
		
		return tasaGraduacionDao.obtenerGraduadosPeriodoAcademico(programaCodigo);
		
	}

	@Override
	public List<TasaGraduacionPeriodo> obtenerPeriodosMatriculados(int programaCodigo) {
		
		return tasaGraduacionDao.obtenerPeriodosMatriculados(programaCodigo);
		
	}

	@Override
	public List<TasaGraduacionPersonas> obtenerEstudiantesPrimerIngreso(String periodoInicial, String periodoFinal,
			int programaCodigo) {
		
		return tasaGraduacionDao.obtenerEstudiantesPrimerIngreso(periodoInicial, periodoFinal, programaCodigo);
		
	}

	@Override
	public List<TasaGraduacionPersonas> obtenerGraduados(int programaCodigo, String periodo) {
		
		return tasaGraduacionDao.obtenerGraduados(programaCodigo, periodo);
		
	}
	
}
