package mx.com.capacitarte.prestamex.gestion.type;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ErrorResponseType {

	@JsonIgnore
	@Schema(description = "Estado HTTP de la respuesta", required = false)
	private int status;
	private int code;
	private Date timestamp;
	@Schema(description = "Mesaje a mostrar a usuarios finales.")
	private String userMessage;
	@Schema(description = "Error para el desarrollador")
	private String developerMessage;

	public ErrorResponseType(String developerMessage) {
		this.developerMessage = developerMessage;
	}
	
}
