package mx.com.capacitarte.prestamex.gestion.repositories;

import java.sql.SQLException;
import java.util.List;

import mx.com.capacitarte.prestamex.gestion.filters.LoginFilter;

public interface ICustomControlSesionRepository {

	List<Object> consultarUsuarios(LoginFilter loginFilter) throws SQLException;
	
}
