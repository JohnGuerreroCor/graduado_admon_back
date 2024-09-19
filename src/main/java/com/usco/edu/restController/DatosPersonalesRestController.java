package com.usco.edu.restController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.usco.edu.entities.DatosPersonales;
import com.usco.edu.entities.EstadoCivil;
import com.usco.edu.entities.GrupoSanguineo;
import com.usco.edu.entities.SoporteExpedicion;
import com.usco.edu.entities.TipoDocumento;
import com.usco.edu.service.IDatosPersonalesService;

@RestController
@RequestMapping(path = "datos")
public class DatosPersonalesRestController {

	@Autowired
	IDatosPersonalesService datosPersonalesService;

	@GetMapping(path = "obtener-datos-personales/{id}")
	public List<DatosPersonales> obtenerPaises(@PathVariable String id) {

		return datosPersonalesService.obtenerDatosPersonales(id);

	}

	@GetMapping(path = "obtener-tipos-identificacion")
	public List<TipoDocumento> obtenerDepartamentos() {

		return datosPersonalesService.obtenerIdentificacionTipos();

	}

	@GetMapping(path = "obtener-estados-civil")
	public List<EstadoCivil> obtenerEstadosCivil() {

		return datosPersonalesService.obtenerEstadosCivil();

	}

	@GetMapping(path = "obtener-grupos-sanguineos")
	public List<GrupoSanguineo> obtenerGruposSanguineos() {

		return datosPersonalesService.obtenerGruposSanguineos();

	}

	@PutMapping(path = "actualizar-datos-contacto/{username}")
	public int actualizarDatosContacto(@PathVariable String username, @RequestBody DatosPersonales contacto) {

		return datosPersonalesService.actualizarDatosContacto(username, contacto);

	}

	@PutMapping(path = "actualizar-datos-residencia/{username}")
	public int actualizarDatosResidencia(@PathVariable String username, @RequestBody DatosPersonales residencia) {

		return datosPersonalesService.actualizarDatosResidencia(username, residencia);

	}

	@PutMapping(path = "actualizar-datos-expedicion/{username}")
	public int actualizarDatosExpedicion(@PathVariable String username, @RequestBody DatosPersonales expedicion) {

		return datosPersonalesService.actualizarDatosExpedicion(username, expedicion);

	}

	@PostMapping("registrar-soporte-expedicion/{user}/{perCodigo}/{uaa}")
	public void registrarSoporteExpedicion(@PathVariable String user, @PathVariable Long perCodigo,
			@RequestPart MultipartFile archivo, HttpServletRequest request, @PathVariable int uaa,
			@RequestParam String json) {

		ObjectMapper objectMapper = new ObjectMapper();
		SoporteExpedicion soporteExpedicion;
		try {
			soporteExpedicion = objectMapper.readValue(json, SoporteExpedicion.class);
			soporteExpedicion
					.setRuta(datosPersonalesService.subirSoporteExpedicion(archivo, perCodigo, uaa, user, request));
			System.out.println("Entro");
			datosPersonalesService.registrarSoporteExpedicion(user, soporteExpedicion);

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@PutMapping("actualizar-soporte-expedicion/{user}")
	public void update(@PathVariable String user, @RequestBody SoporteExpedicion soporte) {

		datosPersonalesService.actualizarSoporteExpedicion(user, soporte);
	}

	@GetMapping("mirar-archivo/{codigo}/{user}")
	public ResponseEntity<InputStreamResource> mirarArchivo(@PathVariable Long codigo, @PathVariable String user,
			HttpServletResponse response) throws Exception {
		ByteArrayInputStream stream = datosPersonalesService.mirarSoporteExpedicion(codigo, user, response);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=\" documento.pdf\"");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));

	}

}
