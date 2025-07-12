package mx.com.capacitarte.prestamex.gestion.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.capacitarte.prestamex.gestion.beans.RespuestaPersistenciaBean;
import mx.com.capacitarte.prestamex.gestion.beans.request.UsuarioActualizarBeanRequest;
import mx.com.capacitarte.prestamex.gestion.beans.request.UsuarioRegistrarBeanRequest;
import mx.com.capacitarte.prestamex.gestion.beans.response.UsuarioActualizaBeanResponse;
import mx.com.capacitarte.prestamex.gestion.beans.response.UsuarioConsultarBean;
import mx.com.capacitarte.prestamex.gestion.beans.response.UsuarioRegistrarBeanResponse;
import mx.com.capacitarte.prestamex.gestion.commons.CONSTANTES;
import mx.com.capacitarte.prestamex.gestion.entity.EmpleadoEntity;
import mx.com.capacitarte.prestamex.gestion.entity.UsuarioEntity;
import mx.com.capacitarte.prestamex.gestion.exceptions.ServiceException;
import mx.com.capacitarte.prestamex.gestion.filters.UsuarioFilter;
import mx.com.capacitarte.prestamex.gestion.services.IUsuariosService;
import mx.com.capacitarte.prestamex.gestion.type.ErrorResponseType;

@RestController
@RequestMapping("/usuarios")
@Slf4j
@Tag(name = CONSTANTES.CONTROLLER_USUARIO_NAME, description = CONSTANTES.CONTROLLER_USUARIO_DESCRIPTION)
public class UsuariosController {

	@Autowired
	IUsuariosService usuariosService;
	
	@Operation(summary = CONSTANTES.CONTROLLER_USUARIO_OPER_REGISTRAR)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = UsuarioRegistrarBeanResponse.class)) }),  
			@ApiResponse(responseCode = "500", content = {
					@Content(schema = @Schema(implementation = ErrorResponseType.class)) }), })
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrarUsuario(@Valid @RequestBody UsuarioRegistrarBeanRequest usuarioReq) throws ServiceException {
		log.info("Input registrarUsuario: {} " + usuarioReq);
		
		UsuarioEntity usuarioEntity = UsuarioEntity.builder()
				.usuario(usuarioReq.getUsuario())
				.password(usuarioReq.getPassword())
				.idPerfil(usuarioReq.getIdPerfil())
				.vigencia(usuarioReq.getVigencia())
				.usuarioCreacion(usuarioReq.getUsuarioRegistra())
				.build();
		EmpleadoEntity empleadoEntity = EmpleadoEntity.builder()
				.nombre(usuarioReq.getNombreUsuario())
				.apPaterno(usuarioReq.getApPaterno())
				.apMaterno(usuarioReq.getApMaterno())
				.correoElectronico(usuarioReq.getCorreoElectronico())
				.telefono(usuarioReq.getTelefono())
				.direccion(usuarioReq.getDireccion())
				.genero(usuarioReq.getGenero())
				.nacionalidad(usuarioReq.getNacionalidad())
				.fechaNacimiento(usuarioReq.getFechaNacimiento())
				.vigencia(usuarioReq.getVigencia())
				.usuarioCreacion(usuarioReq.getUsuarioRegistra())
				.build();
		
		RespuestaPersistenciaBean persistenciaBean = usuariosService.registrarUsuario(usuarioEntity, empleadoEntity);
		
		UsuarioRegistrarBeanResponse response = UsuarioRegistrarBeanResponse.builder()
				.estatusRegistro(persistenciaBean.getEstatusPersistencia())
				.mensaje(persistenciaBean.getMensaje())
				.idEmpleado(persistenciaBean.getIdEmpleado())
				.build();
		
		log.info("OutPut registrarUsuario: {}", persistenciaBean);
		
		return ResponseEntity.status(!persistenciaBean.getEstatusPersistencia() ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED).body(response);
	
	}
	
	@Operation(summary = CONSTANTES.CONTROLLER_USUARIO_OPER_ACTUALIZAR)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = UsuarioActualizaBeanResponse.class)) }),  
			@ApiResponse(responseCode = "500", content = {
					@Content(schema = @Schema(implementation = ErrorResponseType.class)) }), })
	@PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> actualizarUsuario(@Valid @RequestBody UsuarioActualizarBeanRequest usuarioReq) throws ServiceException {
		log.info("Input actualizarUsuario: {} " + usuarioReq);
		
		UsuarioEntity usuarioEntity = UsuarioEntity.builder()
				.idEmpleado(usuarioReq.getIdEmpleado())
				.usuario(usuarioReq.getUsuario())
				.password(usuarioReq.getPassword())
				.idPerfil(usuarioReq.getIdPerfil())
				.vigencia(usuarioReq.getVigencia())
				.usuarioActualiza(usuarioReq.getUsuarioActualiza())
				.build();
		
		EmpleadoEntity empleadoEntity = EmpleadoEntity.builder()
				.idEmpleado(usuarioReq.getIdEmpleado())
				.nombre(usuarioReq.getNombreUsuario())
				.apPaterno(usuarioReq.getApPaterno())
				.apMaterno(usuarioReq.getApMaterno())
				.correoElectronico(usuarioReq.getCorreoElectronico())
				.telefono(usuarioReq.getTelefono())
				.direccion(usuarioReq.getDireccion())
				.genero(usuarioReq.getGenero())
				.nacionalidad(usuarioReq.getNacionalidad())
				.fechaNacimiento(usuarioReq.getFechaNacimiento())
				.vigencia(usuarioReq.getVigencia())
				.usuarioActualiza(usuarioReq.getUsuarioActualiza())
				.build();
		
		RespuestaPersistenciaBean persistenciaBean = usuariosService.actualizarUsuario(usuarioEntity, empleadoEntity);
		
		UsuarioActualizaBeanResponse response = UsuarioActualizaBeanResponse.builder()
				.estatusActualizacion(persistenciaBean.getEstatusPersistencia())
				.mensaje(persistenciaBean.getMensaje())
				.idEmpleado(persistenciaBean.getIdEmpleado())
				.build();
		
		log.info("OutPut actualizarUsuario: {}", persistenciaBean);
		
		return ResponseEntity.status(!persistenciaBean.getEstatusPersistencia() ? HttpStatus.NO_CONTENT : HttpStatus.OK).body(response);
	
	}
	
	@Operation(summary = CONSTANTES.CONTROLLER_USUARIO_OPER_CONSULTAR)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = UsuarioConsultarBean.class)) }),  
			@ApiResponse(responseCode = "500", content = {
					@Content(schema = @Schema(implementation = ErrorResponseType.class)) }), })
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultarUsuarios(
			@RequestParam(required = false)
			@Schema(description = "Id Empleado registrado", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "123")
			Integer idEmpleado,
			
			@RequestParam(required = false)
			@Schema(description = "Nombre del usuario/empleado", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "Juan")
			String nombre,
			
			@RequestParam(required = false)
			@Schema(description = "Usuario con el que se loguea al sistema", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "User1000")
			String usuario,
			
			@RequestParam(required = false)
			@Schema(description = "Id Perfil asignado al usuario", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "2")
			Integer idPerfil) throws ServiceException {
		log.info("Input consultarUsuarios: idEmpledo:{}, Nombre:{}, Usuario:{}, idPerfil:{} ", idEmpleado, nombre, usuario, idPerfil);
		
		if(idEmpleado == null && nombre == null && usuario == null && idPerfil == null) {
			return ResponseEntity.badRequest().build();
		}
		
		UsuarioFilter filter = UsuarioFilter.builder()
				.idEmpleado(idEmpleado)
				.nombre(nombre)
				.usuario(usuario)
				.idPerfil(idPerfil)
				.build();
		
		Optional<List<UsuarioConsultarBean>> _usuarios = usuariosService.consultarUsuarios(filter);
		
		log.info("OutPut actualizarUsuario: {}", _usuarios.isPresent() ? "Usuarios encontrados: " + _usuarios.get().size() : "usuarios null");
		
		return _usuarios.isPresent() ? ResponseEntity.ok().body(_usuarios.get()) : ResponseEntity.noContent().build();
	
	}
	
}
