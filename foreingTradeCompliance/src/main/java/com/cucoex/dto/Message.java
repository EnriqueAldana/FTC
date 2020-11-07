package com.cucoex.dto;

public class Message {

	
	private String mensaje;
	
	
	
	/**
	 * @param mensaje
	 */
	public Message(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public Message() {
		
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
