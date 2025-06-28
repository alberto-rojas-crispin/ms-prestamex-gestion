package mx.com.capacitarte.prestamex.gestion.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mx.com.capacitarte.prestamex.gestion.beans.request.LoginBeanRequest;
import mx.com.capacitarte.prestamex.gestion.beans.response.LoginBeanResponse;

@RestController
@RequestMapping("/login")
@Slf4j
public class ControlSesionController {

	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> guardar(@RequestBody LoginBeanRequest loginReq) throws Exception {
		log.info("Input: {} " + loginReq);
				
		Map<String, String> usuariosValidos = new HashMap<String, String>();
		usuariosValidos.put("admin", "1234");
		usuariosValidos.put("operaciones", "4321");
		usuariosValidos.put("consultor", "9876");
		
		Map<String, String> perfilesValidos = new HashMap<String, String>();
		perfilesValidos.put("admin", "admin");
		perfilesValidos.put("operaciones", "operativo");
		perfilesValidos.put("consultor", "consultas");
		
		if(!usuariosValidos.containsKey(loginReq.getUsuario())) {
			return ResponseEntity.noContent().build();
		}
		
		LoginBeanResponse loginBeanResponse = null;
		if(usuariosValidos.get(loginReq.getUsuario()).equals(loginReq.getPass())) {
			System.out.println("aq");
			loginBeanResponse = LoginBeanResponse.builder()
					.idUsuario("12")
					.usuario("FT192030")
					.nombre("Feliciano")
					.apPaterno("Crispin")
					.apMaterno("Gutierrez")
					.genero("Masculino")
					.perfil(perfilesValidos.get(loginReq.getUsuario()))
					.estatusLogin(true)
					.build();
		}
		
		ResponseEntity<LoginBeanResponse> successResponseEntity = ResponseEntity.ok().body(loginBeanResponse);
				
		log.info("OutPut: {}", successResponseEntity);
		return loginBeanResponse == null ? ResponseEntity.noContent().build() :successResponseEntity;
	}
	
	@GetMapping("/test")
	public ResponseEntity<?> test() throws Exception{
		
		LoginBeanResponse loginBeanResponse = LoginBeanResponse.builder()
					.idUsuario("12")
					.usuario("FT192030")
					.nombre("Feliciano")
					.apPaterno("Crispin")
					.apMaterno("Gutierrez")
					.genero("Masculino")
					.perfil("admin")
					.estatusLogin(true)
					.build();
			
		return ResponseEntity.ok().body(loginBeanResponse);
	}
	
}
