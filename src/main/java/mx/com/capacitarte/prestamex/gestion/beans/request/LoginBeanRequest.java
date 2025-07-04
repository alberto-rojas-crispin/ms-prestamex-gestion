package mx.com.capacitarte.prestamex.gestion.beans.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginBeanRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Usuario obligatorio")
	private String usuario;

	@NotBlank(message = "Password obligatorio")
	private String pass;
}
