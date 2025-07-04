package mx.com.capacitarte.prestamex.gestion.services.impl;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.com.capacitarte.prestamex.gestion.beans.RespuestaPersistenciaBean;
import mx.com.capacitarte.prestamex.gestion.entity.EmpleadoEntity;
import mx.com.capacitarte.prestamex.gestion.entity.UsuarioEntity;
import mx.com.capacitarte.prestamex.gestion.exceptions.ServiceException;
import mx.com.capacitarte.prestamex.gestion.services.IUsuariosService;

@Service
@Slf4j
public class UsuariosServiceImpl implements IUsuariosService {@Override
	
	public RespuestaPersistenciaBean registrarUsuario(UsuarioEntity usuarioEntity, EmpleadoEntity empleadoEntity)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}


}
