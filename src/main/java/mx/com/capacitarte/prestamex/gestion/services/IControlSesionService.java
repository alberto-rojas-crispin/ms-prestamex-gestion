package mx.com.capacitarte.prestamex.gestion.services;

import java.util.Optional;

import mx.com.capacitarte.prestamex.gestion.beans.request.LoginBeanRequest;
import mx.com.capacitarte.prestamex.gestion.beans.response.LoginBeanResponse;

public interface IControlSesionService {

	public Optional<LoginBeanResponse> validarAcceso(LoginBeanRequest request) throws Exception;
	
}
