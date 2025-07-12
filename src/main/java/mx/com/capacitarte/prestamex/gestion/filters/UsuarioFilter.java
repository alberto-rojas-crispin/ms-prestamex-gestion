package mx.com.capacitarte.prestamex.gestion.filters;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UsuarioFilter implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer idEmpleado;
	private String nombre;
	private String usuario;
	private Integer idPerfil;
	
}
