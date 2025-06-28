package mx.com.capacitarte.prestamex.gestion.beans.request;

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
public class LoginBeanRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("usuario")
	private String usuario;

	@JsonProperty("pass")
	private String pass;
}
