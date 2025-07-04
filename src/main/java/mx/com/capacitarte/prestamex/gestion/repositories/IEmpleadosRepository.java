package mx.com.capacitarte.prestamex.gestion.repositories;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import mx.com.capacitarte.prestamex.gestion.entity.EmpleadoEntity;

public interface IEmpleadosRepository extends CrudRepository<EmpleadoEntity, Integer>{
	
	Optional<EmpleadoEntity> findByIdEmpleado(Integer idEmpleado) throws SQLException;
	
}
