package mx.com.capacitarte.prestamex.gestion.repositories;

import java.sql.SQLException;
import java.util.List;

import mx.com.capacitarte.prestamex.gestion.filters.UsuarioFilter;

public interface ICustomUsuariosRepository {

	List<Object> consultarUsuarios(UsuarioFilter filter) throws SQLException;
	
}
