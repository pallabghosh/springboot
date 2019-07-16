package com.pg.testapps.usermgmt.controller.Exceptions;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String detais;
	
	public ExceptionResponse(Date timestamp, String message, String detais) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detais = detais;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetais() {
		return detais;
	}
	public void setDetais(String detais) {
		this.detais = detais;
	}
}
