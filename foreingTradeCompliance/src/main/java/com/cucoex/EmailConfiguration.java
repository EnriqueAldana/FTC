/**
 * 
 */
package com.cucoex;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import java.util.Properties;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;


/**
 * @author enrique
 *
 */
@ComponentScan(basePackages = { "com.cucoex.mail" })
@PropertySource(value={"classpath:application.properties"})
public class EmailConfiguration {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(EmailConfiguration.class);

	/**user: cucoex@dimemex.site
	 * Pass. cucoex2020
	 * server: 
	 * Non-SSL Settings (NOT Recommended)
		Username:	cucoex@dimemex.site
		Password:	Use the email account’s password.
		Incoming Server:	mail.dimemex.site
		IMAP Port: 143 POP3 Port: 110
		Outgoing Server:	mail.dimemex.site
		SMTP Port: 26
	 */
	public EmailConfiguration() {
		log.info("Iniciando la configuracion del componente Email");
	}

	
	 	@Value("${spring.mail.host}")
	    private String mailServerHost;

	    @Value("${spring.mail.port}")
	    private Integer mailServerPort;

	    @Value("${spring.mail.username}")
	    private String mailServerUsername;

	    @Value("${spring.mail.password}")
	    private String mailServerPassword;

	    @Value("${spring.mail.properties.mail.smtp.auth}")
	    private String mailServerAuth;

	    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
	    private String mailServerStartTls;

	    @Value("${spring.mail.templates.path}")
	    private String mailTemplatesPath;
	    
	    @Bean
	    public JavaMailSender getJavaMailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        
	        mailSender.setHost(mailServerHost);
	        mailSender.setPort(mailServerPort);
	        
	        mailSender.setUsername(mailServerUsername);
	        mailSender.setPassword(mailServerPassword);
	        
	        Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", mailServerAuth);
	        props.put("mail.smtp.starttls.enable", mailServerStartTls);
	        props.put("mail.debug", "true");
	        
	        return mailSender;
	    }
	    
	    @Bean
	    public SimpleMailMessage templateSimpleMessage() {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setText("This is the test email template for your email:\n%s\n");
	        return message;
	    }
	    
	    @Bean
	    public SpringTemplateEngine thymeleafTemplateEngine(ITemplateResolver templateResolver) {
	        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	        templateEngine.setTemplateResolver(templateResolver);
	        templateEngine.setTemplateEngineMessageSource(emailMessageSource());
	        return templateEngine;
	    }

	    @Bean
	    public ITemplateResolver thymeleafClassLoaderTemplateResolver() {
	        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	        templateResolver.setPrefix(mailTemplatesPath + "/");
	        templateResolver.setSuffix(".html");
	        templateResolver.setTemplateMode("HTML");
	        templateResolver.setCharacterEncoding("UTF-8");
	        return templateResolver;
	    }


	    
	    @Bean 
	    public FreeMarkerConfigurer freemarkerClassLoaderConfig() {
	        Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);
	        TemplateLoader templateLoader = new ClassTemplateLoader(this.getClass(), "/" + mailTemplatesPath);
	        configuration.setTemplateLoader(templateLoader);
	        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
	        freeMarkerConfigurer.setConfiguration(configuration);
	        return freeMarkerConfigurer; 
	    }
	    

	    @Bean
	    public ResourceBundleMessageSource emailMessageSource() {
	        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	        messageSource.setBasename("/mailMessages");
	        return messageSource;
	    }
}
