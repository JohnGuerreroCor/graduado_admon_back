package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.MencionReconocimiento;

public interface IMencionReconocimientoService {
	
	public List<MencionReconocimiento> obtenerMencionesReconocimiento(String id);
	
	public List<MencionReconocimiento> obtenerReporteMencionesReconocimiento(String inicio, String fin);

}
