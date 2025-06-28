package mx.com.capacitarte.prestamex.gestion.beans.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginBeanResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("idUsuario")
	private String idUsuario;
	
	@JsonProperty("usuario")
	private String usuario;

	@JsonProperty("nombre")
	private String nombre;
	
	@JsonProperty("apPaterno")
	private String apPaterno;
	
	@JsonProperty("apMaterno")
	private String apMaterno;
	
	@JsonProperty("genero")
	private String genero;
	
	@JsonProperty("perfil")
	private String perfil;
	
	@JsonProperty("estatusLogin")
	private Boolean estatusLogin;
}
