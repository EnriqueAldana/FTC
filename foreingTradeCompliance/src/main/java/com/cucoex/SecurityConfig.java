package com.cucoex;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cucoex.controller.CausalController;
import com.cucoex.security.JwtEntryPoint;
import com.cucoex.security.JwtTokenFilter;
import com.cucoex.service.UserService;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled= true)   YA TENEMOS UN BEAN REGISTRADO EN LOS FILTROS
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(CausalController.class);

	@Autowired
	UserService userDetailsService;
	@Autowired BCryptPasswordEncoder bcrypt;
	
	@Autowired
    JwtEntryPoint jwtEntryPoint;

	
	/*
	 * @Bean public JwtTokenFilter jwtTokenFilter(){ return new JwtTokenFilter(); }
	 */
   
	@Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

 
	  @Override protected void configure(AuthenticationManagerBuilder auth) throws
	  Exception{ 
		  
		  log.info("Entrando en configure de SecurityCOnfig");
	  
			/*
			 * auth .inMemoryAuthentication() .withUser("user") .password("123")
			 * .roles("USER") .and() .withUser("admin") .password("admin")
			 * .roles("USER","ADMIN");
			 */

	  auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt); 
	  }
	  
	  @Override protected void configure(HttpSecurity http) throws Exception{ 
		  
		  http.sessionManagement().maximumSessions(1);
		  //http.sessionManagement().invalidSessionUrl("/login.html");
		  http.sessionManagement().invalidSessionUrl("/login");
		  http.sessionManagement().sessionFixation().migrateSession();

		  
		  http.cors().and().csrf().disable()
		  .authorizeRequests().antMatchers("/","/api/**", "/login","/public/**","/webjars/**","/css/**","/assets/**","/img/**", "/vendor/**","/js/**","/private/webjars/**","/private/css/**","/private/assets/**","/private/img/**", "/private/vendor/**","/private/js/**").permitAll()
		  .anyRequest() .authenticated() 
		  .and()
		  	.formLogin().loginPage("/login").defaultSuccessUrl("/index", true).failureUrl("/login?error=true")
		  	.usernameParameter("username")
            .passwordParameter("password")
		  	.loginProcessingUrl("/login-post").permitAll()
		  .and()
		  .logout()
          .permitAll()
          .logoutSuccessUrl("/login?logout");
		  	//Hasta aqui la funcionalidad de Login funciona bien, lo siguiente es para REST
          /*.and()
          .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
          .and()
          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		  http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);*/
	  }
	  
	  
	  	@Bean 
	  	public BCryptPasswordEncoder passwordEncoder() {
	  
		 BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		 return bCryptPasswordEncoder;
		 }
	 
	  	
	  
	  	@Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	  

}
