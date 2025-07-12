package mx.com.capacitarte.prestamex.gestion.enums;

public enum UsuariosConsultarEnum {

	FTN_ID_EMPLEADO(0),
	FTC_NOMBRE(1),
	FTC_APELLIDO_PATERNO(2),
	FTC_APELLIDO_MATERNO(3),
	FTC_TELEFONO(4),
	FTC_EMAIL(5),
	FTC_GENERO(6),
	FTC_DIRECCION(7),
	FTC_NACIONALIDAD(8),
	FTD_FECHA_NACIMIENTO(9),
	FCB_VIGENCIA(10),
	FTN_ID_USUARIO(11),
	FTC_USUARIO(12),
	FCN_ID_PERFIL(13),
	PERFIL(14),
	DESC_PERFIL(15),
	
	;
	
	private final int value;

	UsuariosConsultarEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UsuariosConsultarEnum fromValue(int value) {
        for (UsuariosConsultarEnum number : UsuariosConsultarEnum.values()) {
            if (number.getValue() == value) {
                return number;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
    
}
