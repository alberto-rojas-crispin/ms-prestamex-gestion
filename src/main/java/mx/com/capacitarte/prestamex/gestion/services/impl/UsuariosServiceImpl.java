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

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public RespuestaPersistenciaBean actualizarUsuario(UsuarioEntity usuarioEntity, EmpleadoEntity empleadoEntity)
			throws ServiceException {
		log.info("registrarUsuarioService");
		log.info(usuarioEntity.toString());
		log.info(empleadoEntity.toString());

		try {
			Optional<UsuarioEntity> _usuarioEntity = usuariosRepository.findByIdEmpleado(usuarioEntity.getIdEmpleado());
			
			if(!_usuarioEntity.isPresent()) {
				
				return RespuestaPersistenciaBean.builder()
						.estatusPersistencia(Boolean.FALSE)
						.mensaje("El Id empleado que intenta actualizar no existe")
						.idEmpleado(usuarioEntity.getIdEmpleado())
						.build();
			}
			
			if(usuarioEntity.getUsuario() != null) {
				log.info("Validar si el usuario que se desea actualizar existe");
				
				if(usuariosRepository.findByUsuario(usuarioEntity.getUsuario()).isPresent()) {
					
					return RespuestaPersistenciaBean.builder()
							.estatusPersistencia(Boolean.FALSE)
							.mensaje("El usuario que intenta actualizar ya existe")
							.idEmpleado(_usuarioEntity.get().getIdEmpleado())
							.build();
				}
			}
			
			Optional<EmpleadoEntity> _empleadoEntity = empleadosRepository.findByIdEmpleado(empleadoEntity.getIdEmpleado());
			_empleadoEntity.get().setNombre(empleadoEntity.getNombre() != null ? empleadoEntity.getNombre() : _empleadoEntity.get().getNombre());
			_empleadoEntity.get().setApPaterno(empleadoEntity.getApPaterno() != null ? empleadoEntity.getApPaterno() : _empleadoEntity.get().getApPaterno());
			_empleadoEntity.get().setApMaterno(empleadoEntity.getApMaterno() != null ? empleadoEntity.getApMaterno() : _empleadoEntity.get().getApMaterno());
			_empleadoEntity.get().setCorreoElectronico(empleadoEntity.getCorreoElectronico() != null ? empleadoEntity.getCorreoElectronico() : _empleadoEntity.get().getCorreoElectronico());
			_empleadoEntity.get().setTelefono(empleadoEntity.getTelefono() != null ? empleadoEntity.getTelefono() : _empleadoEntity.get().getTelefono());
			_empleadoEntity.get().setDireccion(empleadoEntity.getDireccion() != null ? empleadoEntity.getDireccion() : _empleadoEntity.get().getDireccion());
			_empleadoEntity.get().setGenero(empleadoEntity.getGenero() != null ? empleadoEntity.getGenero() : _empleadoEntity.get().getGenero());
			_empleadoEntity.get().setNacionalidad(empleadoEntity.getNacionalidad() != null ? empleadoEntity.getNacionalidad() : _empleadoEntity.get().getNacionalidad());
			_empleadoEntity.get().setFechaNacimiento(empleadoEntity.getFechaNacimiento() != null ? empleadoEntity.getFechaNacimiento() : _empleadoEntity.get().getFechaNacimiento());
			_empleadoEntity.get().setVigencia(empleadoEntity.getVigencia() != null ? empleadoEntity.getVigencia() : _empleadoEntity.get().getVigencia());
			_empleadoEntity.get().setUsuarioActualiza(empleadoEntity.getUsuarioActualiza() != null ? empleadoEntity.getUsuarioActualiza() : _empleadoEntity.get().getUsuarioActualiza());
			_empleadoEntity.get().setFechaActualiza(null);
			empleadosRepository.save(_empleadoEntity.get());
			
			_usuarioEntity.get().setUsuario(usuarioEntity.getUsuario() != null ? usuarioEntity.getUsuario() : _usuarioEntity.get().getUsuario());
			_usuarioEntity.get().setPassword(usuarioEntity.getPassword() != null ? usuarioEntity.getPassword() : _usuarioEntity.get().getPassword());
			_usuarioEntity.get().setIdPerfil(usuarioEntity.getIdPerfil() != null ? usuarioEntity.getIdPerfil() : _usuarioEntity.get().getIdPerfil());
			_usuarioEntity.get().setVigencia(usuarioEntity.getVigencia() != null ? usuarioEntity.getVigencia() : _usuarioEntity.get().getVigencia());
			_usuarioEntity.get().setUsuarioActualiza(usuarioEntity.getUsuarioActualiza());
			usuariosRepository.save(_usuarioEntity.get());
			
			return RespuestaPersistenciaBean.builder()
					.estatusPersistencia(Boolean.TRUE)
					.mensaje("Usuario actualizado con exito")
					.idEmpleado(usuarioEntity.getIdEmpleado())
					.build();
			
		} catch (SQLException sqlEx) {
			log.error(sqlEx.getMessage());
			throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR,
					MSPrestamexGestionResponseEnum.WS_DATA_ERROR.getCodeResponse(),
					MSPrestamexGestionResponseEnum.WS_DATA_ERROR.getMessage() + " - actualizarUsuario",
                    sqlEx.getMessage());
			
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR,
					MSPrestamexGestionResponseEnum.WS_BUSINESS_ERROR.getCodeResponse(),
					MSPrestamexGestionResponseEnum.WS_BUSINESS_ERROR.getMessage() + " - actualizarUsuario",
                    e.getMessage());
			
		}
	}


}
