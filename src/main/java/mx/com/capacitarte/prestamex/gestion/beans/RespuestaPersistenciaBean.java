package mx.com.capacitarte.prestamex.gestion.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespuestaPersistenciaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Boolean estatusPersistencia;
	private String mensaje;
	private Integer idEmpleado;
	
	
}
