/**
 * 
 */
package com.cucoex.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.cucoex.controller.CuCoExRESTController;

/**
 * @author enrique
 *
 */
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint{

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(JwtEntryPoint.class);
	/**
	 * 
	 */
	public JwtEntryPoint() {
		
	}

	@Override
	public void commence(HttpServletRequest req, HttpServletResponse res,
			AuthenticationException authException) throws IOException, ServletException {
		log.error("fail en el método commence");
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no autorizado");
		
	}

}
