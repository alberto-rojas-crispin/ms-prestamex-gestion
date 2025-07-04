package mx.com.capacitarte.prestamex.gestion.enums;

public enum MSPrestamexGestionResponseEnum {
	
	WS_BUSINESS_ERROR(	580, "ERROR_EN_LA_LOGICA_DE_NEGOCIO"),
	WS_DATA_ERROR(		581, "ERROR_EN_LA_PERSISTENCIA"),
	WS_CLIENT_ERROR(	582, "ERROR_AL_CONSUMIR_SERVICIO_EXTERNO"),
	WS_NOT_FOUND( 		1002, "NO_RECORS_FOUND"),
	
	;
	
	private final Integer codeResponse;
	private final String message;
	
	MSPrestamexGestionResponseEnum(Integer codeResponse, String message) {
		this.codeResponse	= codeResponse;
		this.message	= message;
	}

	public Integer getCodeResponse() {
		return codeResponse;
	}

	
	public String getMessage() {
		return message;
	}

}
