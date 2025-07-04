package mx.com.capacitarte.prestamex.gestion.beans.request;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRegistrarBeanRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nombreUsuario;
	private String apPaterno;
	private String apMaterno;
	private String telefono;
	private String correoElectronico;
	private String genero;
	private String direccion;
	private String nacionalidad;
	private Date fechaNacimiento;
	
	private Boolean vigencia;
	private String usuario;
	private String password;
	private Integer idPerfil;
	
	private String usuarioRegistra;
	
}
