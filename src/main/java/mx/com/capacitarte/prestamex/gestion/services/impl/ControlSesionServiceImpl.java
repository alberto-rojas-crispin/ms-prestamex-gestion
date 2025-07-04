package mx.com.capacitarte.prestamex.gestion.services.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.com.capacitarte.prestamex.gestion.beans.request.LoginBeanRequest;
import mx.com.capacitarte.prestamex.gestion.beans.response.LoginBeanResponse;
import mx.com.capacitarte.prestamex.gestion.enums.ControlSesionEnum;
import mx.com.capacitarte.prestamex.gestion.enums.MSPrestamexGestionResponseEnum;
import mx.com.capacitarte.prestamex.gestion.filters.LoginFilter;
import mx.com.capacitarte.prestamex.gestion.repositories.ICustomControlSesionRepository;
import mx.com.capacitarte.prestamex.gestion.services.IControlSesionService;

@Service
@Slf4j
public class ControlSesionServiceImpl implements IControlSesionService {

	@Autowired
	ICustomControlSesionRepository customControlSesionRepository;

	@Override
	public Optional<LoginBeanResponse> validarAcceso(LoginBeanRequest request) throws Exception {
		log.info("service: validarAcceso");
		
		try {

			LoginFilter filter = LoginFilter.builder().usuario(request.getUsuario()).pass(request.getPass()).build();

			List<Object> usuariosObject = customControlSesionRepository.consultarUsuarios(filter);
			log.info("Filtros: " + filter.toString());
			log.info("Registros encontrados: {}", usuariosObject.size());

			if (usuariosObject.isEmpty()) {
				return Optional.empty();
			}
			
			List<LoginBeanResponse> lstUsuariosBean = new ArrayList<>();
			usuariosObject.stream()
				.map(result -> (Object[]) result).forEach(row -> {
					
					LoginBeanResponse usuarioBean = LoginBeanResponse.builder()
						.idUsuario(row[ControlSesionEnum.FTN_ID_USUARIO.getValue()] != null ? 
								row[ControlSesionEnum.FTN_ID_USUARIO.getValue()].toString() : "")
						.usuario(row[ControlSesionEnum.FTC_USUARIO.getValue()] != null ? 
								row[ControlSesionEnum.FTC_USUARIO.getValue()].toString() : "")
						.nombre(row[ControlSesionEnum.NOMBRE.getValue()] != null ? 
								row[ControlSesionEnum.NOMBRE.getValue()].toString() : "")
						.apPaterno(row[ControlSesionEnum.APELLIDO_PATERNO.getValue()] != null ? 
								row[ControlSesionEnum.APELLIDO_PATERNO.getValue()].toString() : "")
						.apMaterno(row[ControlSesionEnum.APELLIDO_MATERNO.getValue()] != null ? 
								row[ControlSesionEnum.APELLIDO_MATERNO.getValue()].toString() : "")
						.genero(row[ControlSesionEnum.GENERO.getValue()] != null ? 
								row[ControlSesionEnum.GENERO.getValue()].toString() : "")
						.perfil("admin")
						.estatusLogin(row[ControlSesionEnum.FCB_VIGENCIA.getValue()] != null ? 
								row[ControlSesionEnum.FCB_VIGENCIA.getValue()].toString().equals("true") ? true : false : false)
						.build();
				
					usuarioBean.setMessage(usuarioBean.getEstatusLogin() ? "Usuario vigente": "Usuario no vigente");
					
					lstUsuariosBean.add(usuarioBean);	
			});
			
			return Optional.of(lstUsuariosBean.get(0));

		} catch (SQLException sqlEx) {
			log.error(sqlEx.getMessage());
			throw new Exception(MSPrestamexGestionResponseEnum.WS_DATA_ERROR.getMessage() + " - validar Acceso");

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception(MSPrestamexGestionResponseEnum.WS_BUSINESS_ERROR.getMessage() + " - validar Acceso");

		}

	}

}
