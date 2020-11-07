package com.cucoex;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/*
 * habilitamos la configuracion para validar si metodos pueden ser utilizados por los roles
 */
@Configuration
@EnableGlobalMethodSecurity(
		prePostEnabled=true
)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

}