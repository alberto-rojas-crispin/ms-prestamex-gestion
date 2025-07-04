package mx.com.capacitarte.prestamex.gestion.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.capacitarte.prestamex.gestion.beans.request.LoginBeanRequest;
import mx.com.capacitarte.prestamex.gestion.beans.response.LoginBeanResponse;
import mx.com.capacitarte.prestamex.gestion.commons.CONSTANTES;
import mx.com.capacitarte.prestamex.gestion.exceptions.ServiceException;
import mx.com.capacitarte.prestamex.gestion.services.IControlSesionService;
import mx.com.capacitarte.prestamex.gestion.type.ErrorResponseType;

@RestController
@RequestMapping("/login")
@Slf4j
@Tag(name = CONSTANTES.CONTROLLER_SESION_NAME, description = CONSTANTES.CONTROLLER_SESION_DESCRIPTION)
public class ControlSesionController {

	@Autowired
	IControlSesionService controlSesionService;
	
	@Operation(summary = CONSTANTES.CONTROLLER_SESION_OPER_VALIDAR_ACCESO)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = LoginBeanResponse.class)) }),  
			@ApiResponse(responseCode = "500", content = {
					@Content(schema = @Schema(implementation = ErrorResponseType.class)) }), })
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> validarAcceso(@Valid @RequestBody LoginBeanRequest loginReq) throws ServiceException {
		log.info("Input: {} " + loginReq);
		
		Optional<LoginBeanResponse> loginBeanResponse = controlSesionService.validarAcceso(loginReq);
		
		ResponseEntity<LoginBeanResponse> successResponseEntity = null;
		if(loginBeanResponse.isPresent())
			successResponseEntity = ResponseEntity.ok().body(loginBeanResponse.get());
				
		log.info("OutPut: {}", successResponseEntity);
		return !loginBeanResponse.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(loginBeanResponse);
	
	}
	
}
