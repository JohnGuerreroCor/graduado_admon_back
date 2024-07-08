package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.DatosComplementarios;
import com.usco.edu.entities.HabilidadInformatica;
import com.usco.edu.entities.Idioma;
import com.usco.edu.entities.RegistroEducativo;

public interface IInformacionAcademicaDao {
	
	public List<HabilidadInformatica> obtenerListadoHabilidadesInformaticas(String id);
	
	public List<HabilidadInformatica> obtenerReporteHabilidadesInformaticas(String inicio, String fin);
	
	public List<Idioma> obtenerListadoIdiomas(String id);
	
	public List<Idioma> obtenerReporteIdiomas(String inicio, String fin);
	
	public List<RegistroEducativo> obtenerListadoRegistroEducativo(String id);
	
	public List<RegistroEducativo> obtenerReporteRegistroEducativo(String inicio, String fin);
	
	public List<DatosComplementarios> obtenerListadoDatosComplementarios(String id);
	
	public List<DatosComplementarios> obtenerReporteDatosComplementarios(String inicio, String fin);

}
