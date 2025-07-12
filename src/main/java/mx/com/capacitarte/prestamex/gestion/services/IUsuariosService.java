package mx.com.capacitarte.prestamex.gestion.services;

import mx.com.capacitarte.prestamex.gestion.beans.RespuestaPersistenciaBean;
import mx.com.capacitarte.prestamex.gestion.entity.EmpleadoEntity;
import mx.com.capacitarte.prestamex.gestion.entity.UsuarioEntity;
import mx.com.capacitarte.prestamex.gestion.exceptions.ServiceException;

public interface IUsuariosService {

	RespuestaPersistenciaBean registrarUsuario(UsuarioEntity usuarioEntity, EmpleadoEntity empleadoEntity) throws ServiceException;
	
	RespuestaPersistenciaBean actualizarUsuario(UsuarioEntity usuarioEntity, EmpleadoEntity empleadoEntity) throws ServiceException;
	
}
