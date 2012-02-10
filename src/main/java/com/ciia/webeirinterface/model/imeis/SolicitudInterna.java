package com.ciia.webeirinterface.model.imeis;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class SolicitudInterna {
	@NotEmpty
	@Size(min = 0, max = 50)
	private String solicitud;
	
	@NotEmpty
	@Size(min = 0, max = 11)
	private String imei;
	
	@NotEmpty
	@Size(min = 0, max = 11)
	private String lista;
	
	
	
}
