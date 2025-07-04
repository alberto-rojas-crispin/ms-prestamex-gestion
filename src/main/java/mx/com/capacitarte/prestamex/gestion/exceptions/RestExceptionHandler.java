package mx.com.capacitarte.prestamex.gestion.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import mx.com.capacitarte.prestamex.gestion.type.ErrorResponseType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ErrorResponseType> handleServiceException(ServiceException service,
			HttpServletRequest request) {
		ErrorResponseType error = new ErrorResponseType(service.getUserMessage());
		error.setStatus(service.getStatus());
		error.setCode(service.getCode());
		error.setUserMessage(service.getUserMessage());
		error.setDeveloperMessage(service.getDeveloperMessage());
		error.setTimestamp(service.getTimestamp());
		return new ResponseEntity<>(error, HttpStatus.valueOf(service.getStatus()));
	}

}