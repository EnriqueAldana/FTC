/**
 * 
 */
package com.cucoex;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.EnableScheduling;




/**
 * @author enrique
 *
 */
@Configuration
@EnableScheduling
public class WebConfig {

	
	
	/**
	 * 
	 */
	public WebConfig() {
		System.out.println("Iniciando configuracion del aplicativo CuCoEx");
	}

	@Bean
    public SimpleMailMessage templateSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("This is the test email template for your email:\n%s\n");
        return message;
    }
	
}
