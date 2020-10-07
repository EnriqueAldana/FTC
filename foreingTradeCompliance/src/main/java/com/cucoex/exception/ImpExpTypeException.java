/**
 * 
 */
package com.cucoex.exception;

/**
 * @author enrique
 *
 */
public class ImpExpTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -586543560611733565L;

	/**
	 * 
	 */
	public ImpExpTypeException() {
		super("Nombre del tipo de Exp - Imp o Id no encontrado");
	}



	public ImpExpTypeException(String message) {
		super(message);
	}
	
}
