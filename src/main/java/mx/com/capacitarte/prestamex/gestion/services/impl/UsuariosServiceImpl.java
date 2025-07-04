package mx.com.capacitarte.prestamex.gestion.services.impl;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import mx.com.capacitarte.prestamex.gestion.beans.RespuestaPersistenciaBean;
import mx.com.capacitarte.prestamex.gestion.entity.EmpleadoEntity;
import mx.com.capacitarte.prestamex.gestion.entity.UsuarioEntity;
import mx.com.capacitarte.prestamex.gestion.enums.MSPrestamexGestionResponseEnum;
import mx.com.capacitarte.prestamex.gestion.exceptions.ServiceException;
import mx.com.capacitarte.prestamex.gestion.repositories.IEmpleadosRepository;
import mx.com.capacitarte.prestamex.gestion.repositories.IUsuariosRepository;
import mx.com.capacitarte.prestamex.gestion.services.IUsuariosService;

@Service
@Slf4j
public class UsuariosServiceImpl implements IUsuariosService {

	@Autowired
	IUsuariosRepository usuariosRepository;
	
	@Autowired
	IEmpleadosRepository empleadosRepository;
	
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public RespuestaPersistenciaBean registrarUsuario(UsuarioEntity usuarioEntity, EmpleadoEntity empleadoEntity)
			throws ServiceException {
		log.info("registrarUsuarioService");

		try {
			Optional<UsuarioEntity> usuariosEntity = usuariosRepository.findByUsuario(usuarioEntity.getUsuario());
			
			if(usuariosEntity.isPresent()) {
				
				return RespuestaPersistenciaBean.builder()
						.estatusPersistencia(Boolean.FALSE)
						.mensaje("El usuario ya existe")
						.idEmpleado(usuariosEntity.get().getIdEmpleado())
						.build();
			} 
			
			usuarioEntity.setIdEmpleado(empleadosRepository.save(empleadoEntity).getIdEmpleado());
			
			usuariosRepository.save(usuarioEntity);
			
			return RespuestaPersistenciaBean.builder()
					.estatusPersistencia(Boolean.TRUE)
					.mensaje("Usuario registrado con exito")
					.idEmpleado(usuarioEntity.getIdEmpleado())
					.build();
			
		} catch (SQLException sqlEx) {
			log.error(sqlEx.getMessage());
			throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR,
					MSPrestamexGestionResponseEnum.WS_DATA_ERROR.getCodeResponse(),
					MSPrestamexGestionResponseEnum.WS_DATA_ERROR.getMessage() + " - registrarUsuario",
                    sqlEx.getMessage());
			
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR,
					MSPrestamexGestionResponseEnum.WS_BUSINESS_ERROR.getCodeResponse(),
					MSPrestamexGestionResponseEnum.WS_BUSINESS_ERROR.getMessage() + " - registrarUsuario",
                    e.getMessage());
			
		}

	}


}
