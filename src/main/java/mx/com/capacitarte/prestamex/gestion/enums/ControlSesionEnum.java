package mx.com.capacitarte.prestamex.gestion.enums;

public enum ControlSesionEnum {

	FTN_ID_USUARIO(0),
	FTN_ID_EMPLEADO(1),
	FTC_USUARIO(2),
	NOMBRE(3),
	APELLIDO_PATERNO(4),
	APELLIDO_MATERNO(5),
	GENERO(6),
	NACIONALIDAD(7),
	FCB_VIGENCIA(8),
	FCB_VIGENCIA_EMPLEADO(9),
	FCN_ID_PERFIL(10),
	DESC_PERFIL(11),
	PERFIL(12),
	
	;
	
	private final int value;

	ControlSesionEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ControlSesionEnum fromValue(int value) {
        for (ControlSesionEnum number : ControlSesionEnum.values()) {
            if (number.getValue() == value) {
                return number;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
    
}
