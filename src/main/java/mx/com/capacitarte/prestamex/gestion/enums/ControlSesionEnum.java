package mx.com.capacitarte.prestamex.gestion.enums;

public enum ControlSesionEnum {

	FTN_ID_USUARIO(0),
	FTC_USUARIO(1),
	NOMBRE(2),
	APELLIDO_PATERNO(3),
	APELLIDO_MATERNO(4),
	GENERO(5),
	NACIONALIDAD(6),
	FCB_VIGENCIA(7),
	
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
