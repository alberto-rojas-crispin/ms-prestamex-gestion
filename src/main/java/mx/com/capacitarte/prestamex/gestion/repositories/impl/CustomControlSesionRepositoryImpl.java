package mx.com.capacitarte.prestamex.gestion.repositories.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import mx.com.capacitarte.prestamex.gestion.filters.LoginFilter;
import mx.com.capacitarte.prestamex.gestion.repositories.ICustomControlSesionRepository;

@Repository
@Slf4j
public class CustomControlSesionRepositoryImpl implements ICustomControlSesionRepository {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> consultarUsuarios(LoginFilter loginFilter) throws SQLException {
		try {
			log.info("consultarUsuarios");
			StringBuilder queryStr = new StringBuilder("SELECT \r\n");
			
	        queryStr.append("	   USUARIOS.FTN_ID_USUARIO,\r\n"
	        		+ "        EMPL.FTN_ID_EMPLEADO,"
	        		+ "        USUARIOS.FTC_USUARIO,\r\n"
	        		+ "        EMPL.FTC_NOMBRE, \r\n"
	        		+ "        EMPL.FTC_APELLIDO_PATERNO, \r\n"
	        		+ "        EMPL.FTC_APELLIDO_MATERNO, \r\n"
	        		+ "        EMPL.FTC_GENERO, \r\n"
	        		+ "        EMPL.FTC_NACIONALIDAD,\r\n"
	        		+ "        USUARIOS.FCB_VIGENCIA,\r\n"
	        		+ "        EMPL.FCB_VIGENCIA AS FCB_VIGENCIA_EMPLEADO,\r\n"
	        		+ "        USUARIOS.FCN_ID_PERFIL,\r\n"
	        		+ "        DET_CAT.FTC_DESC_DET_CATALOGO AS DESC_PERFIL,\r\n"
	        		+ "        FTC_VALOR_CATALOGO AS PERFIL\r\n"
	        		+ "    FROM ttgral_usuarios USUARIOS\r\n"
	        		+ "    INNER JOIN ttgral_empleados EMPL ON EMPL.FTN_ID_EMPLEADO = USUARIOS.FTN_ID_EMPLEADO\r\n"
	        		+ "    LEFT JOIN tcgral_detalle_catalogos DET_CAT ON DET_CAT.FTN_ID_DET_CATALOGO = USUARIOS.FCN_ID_PERFIL\r\n"
	        		+ "    WHERE \r\n"
	        		+ "        USUARIOS.FTC_USUARIO = :usuario \r\n"
	        		+ "        AND USUARIOS.FTC_PASSWORD = :password \r\n");
	        

	        Query query = entityManager.createNativeQuery(queryStr.toString());

	        query.setParameter("usuario", loginFilter.getUsuario());
	        query.setParameter("password", loginFilter.getPass());

	        return query.getResultList();
	        
		} catch(Exception e) {
			throw new SQLException(e.getLocalizedMessage(), e);
		}
	}
	

}
