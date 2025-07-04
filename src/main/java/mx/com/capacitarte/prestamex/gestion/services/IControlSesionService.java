package mx.com.capacitarte.prestamex.gestion.services;

import java.util.Optional;

import mx.com.capacitarte.prestamex.gestion.beans.request.LoginBeanRequest;
import mx.com.capacitarte.prestamex.gestion.beans.response.LoginBeanResponse;
import mx.com.capacitarte.prestamex.gestion.exceptions.ServiceException;

public interface IControlSesionService {

	public Optional<LoginBeanResponse> validarAcceso(LoginBeanRequest request) throws ServiceException;
	
}
