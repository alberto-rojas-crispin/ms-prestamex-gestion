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
			
	        queryStr.append("	       USUARIOS.FTN_ID_USUARIO,\r\n"
	        		+ "        USUARIOS.FTC_USUARIO,\r\n"
	        		+ "        EMPL.NOMBRE, \r\n"
	        		+ "        EMPL.APELLIDO_PATERNO, \r\n"
	        		+ "        EMPL.APELLIDO_MATERNO, \r\n"
	        		+ "        EMPL.GENERO, \r\n"
	        		+ "        EMPL.NACIONALIDAD,\r\n"
	        		+ "        USUARIOS.FCB_VIGENCIA\r\n"
	        		+ "    FROM TTGRAL_USUARIOS USUARIOS\r\n"
	        		+ "    INNER JOIN GRAL_EMPLEADOS EMPL ON EMPL.ID_EMPLEADO = USUARIOS.FTN_ID_EMPLEADO\r\n"
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
