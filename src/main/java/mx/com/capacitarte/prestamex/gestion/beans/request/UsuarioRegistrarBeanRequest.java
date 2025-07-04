package mx.com.capacitarte.prestamex.gestion.beans.request;

import java.io.Serializable;

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
	private String genero;
	private String nacionalidad;
	private String fechaNacimiento;
	private Boolean vigencia;
	private String telefono;
	private String direccion;
	private String usuario;
	private String correoEletronico;
	private String password;
	private Integer idPerfil;
	private String usuarioRegistra;
	
}
