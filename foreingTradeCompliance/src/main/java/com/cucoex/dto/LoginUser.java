/**
 * 
 */
package com.cucoex.dto;

import javax.validation.constraints.NotBlank;

/**
 * @author enrique
 *
 */
public class LoginUser {

	/**
	 * 
	 */
	public LoginUser() {
		// TODO Auto-generated constructor stub
	}

	
	@NotBlank
    private String username;
    @NotBlank
    private String password;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
    
}
