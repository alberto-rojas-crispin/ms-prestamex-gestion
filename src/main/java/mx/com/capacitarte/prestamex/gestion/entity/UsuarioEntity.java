package mx.com.capacitarte.prestamex.gestion.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

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
@Table(name = "ttgral_usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UsuarioEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FTN_ID_USUARIO")
	private Long idUsuario;

	@Column(name = "FTN_ID_EMPLEADO")
	private Integer idEmpleado;

	@Column(name = "FTC_USUARIO")
	private String usuario;

	@Column(name = "FTC_PASSWORD")
	private String password;

	@Column(name = "FCN_ID_PERFIL")
	private Integer idPerfil;

	@Column(name = "FCB_VIGENCIA")
	private Boolean vigencia;

	//@Column(name = "FTD_FECHA_CREACION")
	//private ZonedDateTime fechaCreacion;

	@Column(name = "FTC_USUARIO_CREACION")
	private String usuarioCreacion;

}
