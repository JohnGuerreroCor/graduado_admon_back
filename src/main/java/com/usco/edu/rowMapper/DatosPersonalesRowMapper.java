package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.DatosPersonales;

public class DatosPersonalesRowMapper implements RowMapper<DatosPersonales> {
	
	@Override
	public DatosPersonales mapRow(ResultSet rs, int rowNum) throws SQLException {
		DatosPersonales datosPersonales = new DatosPersonales();
		datosPersonales.setCodigo(rs.getInt("per_codigo"));
		datosPersonales.setIdentificacionTipoCodigo(rs.getInt("tii_codigo"));
		datosPersonales.setIdentificacionTipo(rs.getString("tii_nombre"));
		datosPersonales.setIdentificacion(rs.getString("per_identificacion"));
		datosPersonales.setPaisExpedicionCodigo(rs.getInt("pai_expedicion_codigo"));
		datosPersonales.setPaisExpedicion(rs.getString("pai_expedicion"));
		datosPersonales.setDepartamentoExpedicionCodigo(rs.getInt("dep_expedicion_codigo"));
		datosPersonales.setDepartamentoExpedicion(rs.getString("dep_expedicion"));
		datosPersonales.setMunicipioExpedicionCodigo(rs.getInt("mun_expedicion_codigo"));
		datosPersonales.setMunicipioExpedicion(rs.getString("mun_expedicion"));
		datosPersonales.setIdentificacionFechaExpedicion(rs.getDate("per_fecha_expedicion"));
		datosPersonales.setUrlAnexoExpedicion(rs.getString("sopore_expedicion"));
		datosPersonales.setApellido(rs.getString("per_apellido"));
		datosPersonales.setNombre(rs.getString("per_nombre"));
		datosPersonales.setGenero(rs.getString("per_genero"));
		datosPersonales.setEstadoCivilCodigo(rs.getInt("per_estado_civil"));
		datosPersonales.setEstadoCivil(rs.getString("esc_nombre"));
		datosPersonales.setGrupoSanguineoCodigo(rs.getInt("grs_codigo"));
		datosPersonales.setGrupoSanguineo(rs.getString("grs_nombre"));
		datosPersonales.setFechaNacimiento(rs.getDate("per_fecha_nacimiento"));
		datosPersonales.setPaisNacimientoCodigo(rs.getInt("pai_nacimiento_codigo"));
		datosPersonales.setPaisNacimiento(rs.getString("pai_nacimiento"));
		datosPersonales.setDepartamentoNacimientoCodigo(rs.getInt("dep_nacimiento_codigo"));
		datosPersonales.setDepartamentoNacimiento(rs.getString("dep_nacimiento"));
		datosPersonales.setMunicipioNacimientoCodigo(rs.getInt("mun_nacimiento_codigo"));
		datosPersonales.setMunicipioNacimiento(rs.getString("mun_nacimiento"));
		datosPersonales.setEmailPersonal(rs.getString("per_email"));
		datosPersonales.setPaginaWeb(rs.getString("per_pagina_personal"));
		datosPersonales.setTelefonoFijo(rs.getString("per_telefono_fijo"));
		datosPersonales.setTelefonoMovil(rs.getString("per_telefono_movil"));
		datosPersonales.setPaisResidenciaCodigo(rs.getInt("pai_residencia_codigo"));
		datosPersonales.setPaisResidencia(rs.getString("pai_residencia"));
		datosPersonales.setDepartamentoResidenciaCodigo(rs.getInt("dep_residencia_codigo"));
		datosPersonales.setDepartamentoResidencia(rs.getString("dep_residencia"));
		datosPersonales.setMunicipioResidenciaCodigo(rs.getInt("mun_residencia_codigo"));
		datosPersonales.setMunicipioResidencia(rs.getString("mun_residencia"));
		datosPersonales.setBarrio(rs.getString("per_barrio"));
		datosPersonales.setDireccion(rs.getString("per_direccion_residencia"));
		return datosPersonales;
		
	}
	
}
