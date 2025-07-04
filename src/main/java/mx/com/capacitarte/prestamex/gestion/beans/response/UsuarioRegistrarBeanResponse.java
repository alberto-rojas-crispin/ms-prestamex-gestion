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
public class UsuarioRegistrarBeanResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idEmpleado;
	private Boolean estatusRegistro;
	private String mensaje;
	
	
}
