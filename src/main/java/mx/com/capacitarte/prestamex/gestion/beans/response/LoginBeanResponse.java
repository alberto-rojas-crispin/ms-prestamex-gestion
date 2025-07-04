package mx.com.capacitarte.prestamex.gestion.beans.response;

import java.io.Serializable;

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

	private Integer idUsuario;
	private Integer idEmpleado;
	private String usuario;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String genero;
	private Integer idPerfil;
	private String perfil;
	private String descPerfil;
	private Boolean estatusLogin;
	private String message;
	
}
