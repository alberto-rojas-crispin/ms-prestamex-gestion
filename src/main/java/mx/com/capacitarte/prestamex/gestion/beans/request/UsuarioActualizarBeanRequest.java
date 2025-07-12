package mx.com.capacitarte.prestamex.gestion.beans.request;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioActualizarBeanRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message="Id empleado requerido")
	private Integer idEmpleado;
	
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

	@NotBlank(message="Usuario que actualiza requerido")
	private String usuarioActualiza;
	
}
