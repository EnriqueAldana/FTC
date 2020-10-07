/**
 * 
 */
package com.cucoex.exception;

/**
 * @author enrique
 *
 */
public class ComplianceException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6331622818783408655L;



	/**
	 * 
	 */
	public ComplianceException() {
		super("Nombre del cumplimiento o Id no encontrado");
		
	}


	
	public ComplianceException(String message) {
		super(message);
	}
	
}
