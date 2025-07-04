package mx.com.capacitarte.prestamex.gestion.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	private final Integer status;
	private final Integer code;
	private final String userMessage;
	private final String developerMessage;
	private final Date timestamp;
	private Object body;

	public ServiceException(Integer status, Integer code, String message, String developerMessage) {
		this.status = status;
        this.code = code;
        this.userMessage = message;
		this.developerMessage = developerMessage;
		this.timestamp = new Date();
	}

	public ServiceException(HttpStatus status, Integer code, String message, String developerMessage) {
		this.status = status.value();
        this.code = code;
        this.userMessage = message;
		this.developerMessage = developerMessage;
		this.timestamp = new Date();
	}
	
	public ServiceException(Integer status, Integer code, String userMessage, String developerMessage, Object body) {
		this.status = status;
        this.code = code;
        this.userMessage = userMessage;
		this.developerMessage = developerMessage;
		this.body = body;
		this.timestamp = new Date();
	}

	@Override
	public String toString() {
		return "ServiceException [status=" + status + ", userMessage=" + userMessage + ", developerMessage="
				+ developerMessage + ", timestamp=" + timestamp + ", body=" + body + "]";
	}
	
}
