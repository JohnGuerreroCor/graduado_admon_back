package com.usco.edu.service.serviceImpl;

import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usco.edu.dao.IDatosPersonalesDao;
import com.usco.edu.dao.IDocumentoDao;
import com.usco.edu.dto.RespuestaSubirArchivo;
import com.usco.edu.dto.RespuestaVerArchivo;
import com.usco.edu.entities.DatosPersonales;
import com.usco.edu.entities.Documento;
import com.usco.edu.entities.EstadoCivil;
import com.usco.edu.entities.GrupoSanguineo;
import com.usco.edu.entities.SoporteExpedicion;
import com.usco.edu.entities.TipoDocumento;
import com.usco.edu.feing.EnviarArchivoClient;
import com.usco.edu.service.IDatosPersonalesService;

@Service
public class DatosPersonalesServiceImpl implements IDatosPersonalesService {

	@Autowired
	private IDatosPersonalesDao datosPersonalesDao;

	@Autowired
	private IDocumentoDao documentoDao;

	@Autowired
	private EnviarArchivoClient enviarArchivo;

	@Override
	public List<DatosPersonales> obtenerDatosPersonales(String id) {

		return datosPersonalesDao.obtenerDatosPersonales(id);

	}

	@Override
	public List<TipoDocumento> obtenerIdentificacionTipos() {

		return datosPersonalesDao.obtenerIdentificacionTipos();

	}

	@Override
	public List<EstadoCivil> obtenerEstadosCivil() {

		return datosPersonalesDao.obtenerEstadosCivil();

	}

	@Override
	public List<GrupoSanguineo> obtenerGruposSanguineos() {

		return datosPersonalesDao.obtenerGruposSanguineos();

	}

	@Override
	public int actualizarDatosContacto(String userdb, DatosPersonales contacto) {

		return datosPersonalesDao.actualizarDatosContacto(userdb, contacto);

	}

	@Override
	public int actualizarDatosResidencia(String userdb, DatosPersonales residencia) {

		return datosPersonalesDao.actualizarDatosResidencia(userdb, residencia);

	}

	@Override
	public int actualizarDatosExpedicion(String userdb, DatosPersonales expedicion) {

		return datosPersonalesDao.actualizarDatosExpedicion(userdb, expedicion);

	}

	@Override
	public void registrarSoporteExpedicion(String userdb, SoporteExpedicion soporte) {

		datosPersonalesDao.registrarSoporteExpedicion(userdb, soporte);

	}

	@Override
	public void actualizarSoporteExpedicion(String userdb, SoporteExpedicion soporte) {

		datosPersonalesDao.actualizarSoporteExpedicion(userdb, soporte);

	}

	@Override
	public String subirSoporteExpedicion(MultipartFile file, Long perCodigo, int uaa, String userdb,
			HttpServletRequest request) {

		String err = "";
		if (!file.isEmpty()) {

			if (isValido(file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".")))) {

				Documento documento = new Documento();
				documento.setDocNombreArchivo(file.getOriginalFilename());
				documento.setPerCodigo("" + perCodigo);
				documento.setDocCliente("Graduados_Administrador");
				documento.setDocContenido("Soporte Cambio Fecha Expedicion");
				documento.setDocExtension("pdf");
				documento.setDocIp(request.getRemoteAddr());
				documento.setDocSesion(request.getSession().getId());
				documento.setModCodigo(79);// CAMBIAR PARA PRODUCCION
				documento.setTdocCodigo(1);// CAMBIAR PARA PRODUCCION
				documento.setUaaCodigo(uaa);

				String Key = documentoDao.getKeyDocumento(
						documento.getModCodigo().toString() + documento.getUaaCodigo() + documento.getPerCodigo(),
						userdb);

				System.out.println("datos: " + documento.getModCodigo().toString() + documento.getUaaCodigo()
						+ documento.getPerCodigo());
				ObjectMapper objectMapper = new ObjectMapper();
				RespuestaSubirArchivo respuesta = new RespuestaSubirArchivo();
				try {
					respuesta = enviarArchivo.subirArchivo(file, Key, objectMapper.writeValueAsString(documento));
					System.out.println(respuesta.getMensaje());
					System.out.println(respuesta.getIdDocumento());
					err = respuesta.getMensaje();
					if (!respuesta.isEstado()) {

						System.out.println("Ocurrio un error: " + respuesta.getMensaje());
					}

				} catch (Exception e) {

					System.out.println("Ocurrio un error: " + e);
					return null;
				}
				System.out.println("Creado" + respuesta.getMensaje());
				return respuesta.getIdDocumento() + "";

			} else {

				System.out.println("Ocurrio un error" + err);
				return null;
			}

		} else {
			System.out.println("Ocurrio un error" + err);
			return null;
		}

	}

	@Override
	public ByteArrayInputStream mirarSoporteExpedicion(long archivoCodigo, String userdb,
			HttpServletResponse response) {

		String Key = documentoDao.getKeyDocumento(archivoCodigo + "", userdb);

		RespuestaVerArchivo respuesta = new RespuestaVerArchivo();

		try {
			respuesta = enviarArchivo.mostrarArchivo(archivoCodigo, Key);

			byte[] archivoBytes = Base64.getDecoder().decode(respuesta.getBase64().split(",")[1]);
			return new ByteArrayInputStream(archivoBytes);

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public boolean isValido(String nombre) {
		String expresion = "^([[a-zA-Z][0-9]_]{2,150})$";
		try {
			Pattern p = Pattern.compile(expresion);
			Matcher matcher = p.matcher(nombre);
			return matcher.matches();
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}

	}

}
