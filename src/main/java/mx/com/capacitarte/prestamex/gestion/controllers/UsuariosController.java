package mx.com.capacitarte.prestamex.gestion.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
import mx.com.capacitarte.prestamex.gestion.beans.request.UsuarioRegistrarBeanRequest;
import mx.com.capacitarte.prestamex.gestion.beans.response.LoginBeanResponse;
import mx.com.capacitarte.prestamex.gestion.beans.response.UsuarioRegistrarBeanResponse;
import mx.com.capacitarte.prestamex.gestion.commons.CONSTANTES;
import mx.com.capacitarte.prestamex.gestion.entity.EmpleadoEntity;
import mx.com.capacitarte.prestamex.gestion.entity.UsuarioEntity;
import mx.com.capacitarte.prestamex.gestion.exceptions.ServiceException;
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
					@Content(schema = @Schema(implementation = LoginBeanResponse.class)) }),  
			@ApiResponse(responseCode = "500", content = {
					@Content(schema = @Schema(implementation = ErrorResponseType.class)) }), })
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrarUsuario(@Valid @RequestBody UsuarioRegistrarBeanRequest usuarioReq) throws ServiceException {
		log.info("Input: {} " + usuarioReq);
		
		UsuarioEntity usuarioEntity = null;
		EmpleadoEntity empleadoEntity = null;
		
		RespuestaPersistenciaBean persistenciaBean = usuariosService.registrarUsuario(usuarioEntity, empleadoEntity);
		
		log.info("OutPut: {}", persistenciaBean);
		return !persistenciaBean.getEstatusPersistencia() ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.CREATED).body(
				UsuarioRegistrarBeanResponse.builder()
				.numeroCuentaUsuario(persistenciaBean.getNumeroCuentaUsuario())
				.build());
	
	}
	
	
	
	
	
}
