package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.MencionReconocimiento;

public interface IMencionReconocimientoDao {
	
	public List<MencionReconocimiento> obtenerMencionesReconocimiento(String id);
	
	public List<MencionReconocimiento> obtenerReporteMencionesReconocimiento(String inicio, String fin);

}
