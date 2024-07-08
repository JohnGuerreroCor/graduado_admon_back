package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.Facultad;
import com.usco.edu.entities.NivelAcademico;
import com.usco.edu.entities.Periodo;
import com.usco.edu.entities.ProgramaGeneral;

public interface IConsultaGeneralService {
	
	public List<Periodo> obtenerPeriodos();
	
	public List<Facultad> obtenerFacultades();
	
	public List<ProgramaGeneral> obtenerProgramasFacultad(int sedeCodigo, int nivelAcademicoCodigo, int dependenciaCodigo);
	
	public List<NivelAcademico> obtenerNivelesAcademicos(int nivelFormacionCodigo);

}
