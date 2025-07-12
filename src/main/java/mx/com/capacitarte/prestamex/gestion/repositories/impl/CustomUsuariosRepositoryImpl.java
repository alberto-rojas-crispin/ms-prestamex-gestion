package mx.com.capacitarte.prestamex.gestion.repositories.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import mx.com.capacitarte.prestamex.gestion.filters.UsuarioFilter;
import mx.com.capacitarte.prestamex.gestion.repositories.ICustomUsuariosRepository;

@Slf4j
@Repository
public class CustomUsuariosRepositoryImpl implements ICustomUsuariosRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> consultarUsuarios(UsuarioFilter filter) throws SQLException {
		try {
			log.info("Repository: consultarUsuarios");
			StringBuilder queryStr = new StringBuilder("SELECT \r\n");
			
	        queryStr.append("	   EMPL.FTN_ID_EMPLEADO,\r\n"
	        		+ "        EMPL.FTC_NOMBRE, \r\n"
	        		+ "        EMPL.FTC_APELLIDO_PATERNO, \r\n"
	        		+ "        EMPL.FTC_APELLIDO_MATERNO, \r\n"
	        		+ "        EMPL.FTC_TELEFONO,\r\n"
	        		+ "        EMPL.FTC_EMAIL,\r\n"
	        		+ "        EMPL.FTC_GENERO, \r\n"
	        		+ "        EMPL.FTC_DIRECCION,\r\n"
	        		+ "        EMPL.FTC_NACIONALIDAD,\r\n"
	        		+ "        EMPL.FTD_FECHA_NACIMIENTO,\r\n"
	        		+ "        USUARIOS.FCB_VIGENCIA,\r\n"
	        		+ "        USUARIOS.FTN_ID_USUARIO,\r\n"
	        		+ "        USUARIOS.FTC_USUARIO,\r\n"
	        		+ "        USUARIOS.FCN_ID_PERFIL,\r\n"
	        		+ "        FTC_VALOR_CATALOGO AS PERFIL,\r\n"
	        		+ "        DET_CAT.FTC_DESC_DET_CATALOGO AS DESC_PERFIL\r\n"
	        		+ "    FROM ttgral_usuarios USUARIOS\r\n"
	        		+ "    INNER JOIN ttgral_empleados EMPL ON EMPL.FTN_ID_EMPLEADO = USUARIOS.FTN_ID_EMPLEADO\r\n"
	        		+ "    LEFT JOIN tcgral_detalle_catalogos DET_CAT ON DET_CAT.FTN_ID_DET_CATALOGO = USUARIOS.FCN_ID_PERFIL\r\n"
	        		+ "    WHERE 1 = 1 \r\n");
	        
	        if(filter.getIdEmpleado() != null) {
	        	queryStr.append("        AND EMPL.FTN_ID_EMPLEADO = :idEmpleado \r\n");
	        }
	        if(filter.getNombre() != null) {
	        	queryStr.append("        AND EMPL.FTC_NOMBRE = :nombre \r\n");
	        }
	        if(filter.getUsuario() != null) {
	        	queryStr.append("        AND USUARIOS.FTC_USUARIO = :usuario \r\n");
	        }
	        if(filter.getIdPerfil() != null) {
	        	queryStr.append("        AND USUARIOS.FCN_ID_PERFIL = :idPerfil \r\n");
	        }
	        
	        Query query = entityManager.createNativeQuery(queryStr.toString());

	        if(filter.getIdEmpleado() != null) {
	        	query.setParameter("idEmpleado", filter.getIdEmpleado());
	        }
	        if(filter.getNombre() != null) {
	        	query.setParameter("nombre", filter.getNombre());
	        }
	        if(filter.getUsuario() != null) {
	        	query.setParameter("usuario", filter.getUsuario());
	        }
	        if(filter.getIdPerfil() != null) {
	        	query.setParameter("idPerfil", filter.getIdPerfil());
	        }
	        
	        return query.getResultList();
	        
		} catch(Exception e) {
			throw new SQLException(e.getLocalizedMessage(), e);
		}
	}

}
