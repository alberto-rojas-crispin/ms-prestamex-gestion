package mx.com.capacitarte.prestamex.gestion.repositories;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import mx.com.capacitarte.prestamex.gestion.entity.UsuarioEntity;

public interface IUsuariosRepository extends CrudRepository<UsuarioEntity, Long> {

	Optional<UsuarioEntity> findByUsuario(String usuario) throws SQLException;
	
}
