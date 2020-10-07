/**
 * 
 */
package com.cucoex.exception;

/**
 * @author enrique
 *
 */
public class CausalException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6331622818783408655L;



	/**
	 * 
	 */
	public CausalException() {
		super("Nombre del Causal o Id no encontrado");
		
	}


	
	public CausalException(String message) {
		super(message);
	}
	
}
