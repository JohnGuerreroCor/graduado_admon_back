package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.DatosPersonales;
import com.usco.edu.entities.EstadoCivil;
import com.usco.edu.entities.GrupoSanguineo;
import com.usco.edu.entities.SoporteExpedicion;
import com.usco.edu.entities.TipoDocumento;

public interface IDatosPersonalesDao {

	public List<DatosPersonales> obtenerDatosPersonales(String id);

	public List<TipoDocumento> obtenerIdentificacionTipos();

	public List<EstadoCivil> obtenerEstadosCivil();

	public List<GrupoSanguineo> obtenerGruposSanguineos();

	public int actualizarDatosContacto(String userdb, DatosPersonales contacto);

	public int actualizarDatosResidencia(String userdb, DatosPersonales residencia);

	public int actualizarDatosExpedicion(String userdb, DatosPersonales expedicion);

	public void registrarSoporteExpedicion(String userdb, SoporteExpedicion soporte);

	public void actualizarSoporteExpedicion(String userdb, SoporteExpedicion soporte);

}
