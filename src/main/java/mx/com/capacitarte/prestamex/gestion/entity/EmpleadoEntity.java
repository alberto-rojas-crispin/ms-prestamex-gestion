package mx.com.capacitarte.prestamex.gestion.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ttgral_empleados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmpleadoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FTN_ID_EMPLEADO")
	private Integer idEmpleado;

	@Column(name = "FTC_NOMBRE")
	private String nombre;

	@Column(name = "FTC_APELLIDO_PATERNO")
	private String apPaterno;

	@Column(name = "FTC_APELLIDO_MATERNO")
	private String apMaterno;

	@Column(name = "FTC_EMAIL")
	private String correoElectronico;

	@Column(name = "FTC_TELEFONO")
	private String telefono;
	
	@Column(name = "FTC_DIRECCION")
	private String direccion;
	
	@Column(name = "FTC_GENERO")
	private String genero;
	
	@Column(name = "FTC_NACIONALIDAD")
	private String nacionalidad;
	
	@Column(name = "FTD_FECHA_NACIMIENTO")
	private Date fechaNacimiento;
	
	@Column(name = "FCB_VIGENCIA")
	private Boolean vigencia;

	//@Column(name = "FTD_FECHA_CREACION")
	//private ZonedDateTime fechaCreacion;

	@Column(name = "FTC_USUARIO_CREACION")
	private String usuarioCreacion;

	@Column(name = "FTC_USUARIO_ACTUALIZA")
	private String usuarioActualiza;
	
	@Column(name = "FTD_FECHA_ACTUALIZA")
	private ZonedDateTime fechaActualiza;
	
}
