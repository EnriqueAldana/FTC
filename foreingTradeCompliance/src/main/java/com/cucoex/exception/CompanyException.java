package com.cucoex.exception;

public class CompanyException extends Exception {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1448354866357125668L;

	public CompanyException() {
		super("Nombre de la empresa o Id no encontrado");
	}
	
	public CompanyException(String message) {
		super(message);
	}
	
}
