package mx.com.capacitarte.prestamex.gestion.beans.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UsuarioConsultarBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idEmpleado;
	private String nombreUsuario;
	private String apPaterno;
	private String apMaterno;
	private String telefono;
	private String correoElectronico;
	private String genero;
	
	private String direccion;
	private String nacionalidad;
	private String fechaNacimiento;
	private Boolean vigencia;
	
	private Integer idUsuario;
	private String usuario;
	private Integer idPerfil;
	private String perfil;
	private String descPerfil;
	
}
