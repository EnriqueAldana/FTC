/**
 * 
 */
package com.cucoex.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cucoex.controller.CuCoExRESTController;
import com.cucoex.service.IUserService;
import com.cucoex.service.UserService;

/**
 * @author enrique
 *
 */
public class JwtTokenFilter extends OncePerRequestFilter {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(JwtTokenFilter.class);

	@Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserService userDetailsService;
    
    
    @Autowired
	private IUserService userRepo;
    
	/**
	 * 
	 */
	public JwtTokenFilter() {
		
	}
	
	
    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer"))
            return header.replace("Bearer ", "");
        return null;
    }

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
            String token = getToken(request);
            if(token != null && jwtProvider.validateToken(token)){
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                com.cucoex.entity.User foundedUser =null;
  				  foundedUser = userRepo.getUserByUsername(nombreUsuario);
  				//Mandar autenticacion con email de usuario
                UserDetails userDetails = userDetailsService.loadUserByUsername(foundedUser.getEmail());

                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e){
            log.error("fail en el método doFilter " + e.getMessage());
        }
        filterChain.doFilter(request, response);
		
	}
    
    
    
}
