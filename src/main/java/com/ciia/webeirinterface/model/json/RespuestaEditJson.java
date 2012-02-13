/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciia.webeirinterface.model.json;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 *
 * @author Sergio
 */
@JsonAutoDetect
public class RespuestaEditJson {
	private String status;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
