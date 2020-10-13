/**
 * 
 */
package com.cucoex.controller;

import javax.mail.MessagingException;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cucoex.service.EmailService;
import com.cucoex.util.Utileria;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author enrique
 *
 */
@Controller
public class EmailController {
	
	@Autowired
    public EmailService emailService;
 
private static final org.slf4j.Logger log = LoggerFactory.getLogger(EmailController.class);

	/**
	 * 
	 */
	public EmailController() {
		
	}
	
	@GetMapping({"/emailTest"})
	public String emailTest(Model model) {
		
		  log.info("Enviando correos");
		  log.info(Utileria.getCalendarTodayDate().toString());
			/*
			 * emailService.sendSimpleMessage("enrique@dimemex.site",
			 * "Mensaje simple de texto",
			 * "Este es un mensaje simple de texto para efectos de pruebas");
			 * log.info(Utileria.getCalendarTodayDate().toString()); String htmlString ="" +
			 * "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" +
			 * "<title>Mensaje de prueba CuCoEx</title>\n" + "</head>\n" + "<body>\n" + "\n"
			 * + "<h1>Este es un titulo h1</h1>\n" + "<p>Esto es un parrafo.</p>\n" + "\n" +
			 * "</body>\n" + "</html>"; try {
			 * log.info(Utileria.getCalendarTodayDate().toString());
			 * emailService.sendHtmlMessage("enrique@dimemex.site", "Mensaje en HTML",
			 * htmlString); log.info(Utileria.getCalendarTodayDate().toString()); } catch
			 * (MessagingException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
		  
		  // Enviar email mediante plantilla
		  
		  Map<String,Object> map= new HashMap<String,Object>(); 
		  map.put("causalStatusDescription", new String("Causal Conforme")); 
		  map.put("causalStatus", new String("2")); 
		  map.put("companyName", new String("Ingenieria en Computo")); 
		  map.put("impexpTypeDescription", new String("Autos Usados"));
		  map.put("causalDescription", new String("eFiema debera estar vigente"));
		  map.put("senderName", new String("Sistema de notificación "));
		  
		  
		  
		  try { log.info(Utileria.getCalendarTodayDate().toString());
		  emailService.sendMessageUsingThymeleafTemplate("enrique@dimemex.site",
		  "La causal " + "38" + " ha cambiado su estado", map);
		  log.info(Utileria.getCalendarTodayDate().toString()); } catch (IOException |
		  MessagingException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }
		  
		  log.info(Utileria.getCalendarTodayDate().toString());
		  
		model.addAttribute("companyName", "Empresa patito Feo");
		model.addAttribute("impexpTypeDescription", "AUTOS USADOS");
		model.addAttribute("causalStatus", "Causal Cumplida");
		model.addAttribute("causalDescription", "Descripcion de la causal");
		model.addAttribute("senderName", "Sistema de notificación");
		
	
		return "eMail";
		
	}
	

}
