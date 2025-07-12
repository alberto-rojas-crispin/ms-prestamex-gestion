package mx.com.capacitarte.prestamex.gestion.services;

import java.util.List;
import java.util.Optional;

import mx.com.capacitarte.prestamex.gestion.beans.RespuestaPersistenciaBean;
import mx.com.capacitarte.prestamex.gestion.beans.response.UsuarioConsultarBean;
import mx.com.capacitarte.prestamex.gestion.entity.EmpleadoEntity;
import mx.com.capacitarte.prestamex.gestion.entity.UsuarioEntity;
import mx.com.capacitarte.prestamex.gestion.exceptions.ServiceException;
import mx.com.capacitarte.prestamex.gestion.filters.UsuarioFilter;

public interface IUsuariosService {

	RespuestaPersistenciaBean registrarUsuario(UsuarioEntity usuarioEntity, EmpleadoEntity empleadoEntity) throws ServiceException;
	
	RespuestaPersistenciaBean actualizarUsuario(UsuarioEntity usuarioEntity, EmpleadoEntity empleadoEntity) throws ServiceException;
	
	Optional<List<UsuarioConsultarBean>> consultarUsuarios(UsuarioFilter filter) throws ServiceException;
	
}
