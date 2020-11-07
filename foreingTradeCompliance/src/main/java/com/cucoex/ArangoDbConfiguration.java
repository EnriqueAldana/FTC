package com.cucoex;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDB.Builder;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.AbstractArangoConfiguration;


//@Configuration
//@EnableArangoRepositories(basePackages = { "com.cucoex.repository.arangoDB" })
//@PropertySource(value={"classpath:application.properties"})
public class ArangoDbConfiguration extends AbstractArangoConfiguration{

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(ArangoDbConfiguration.class);
	
	
	@Value("${spring.arangodb.host}")
	private String arangoDBHost;	
	@Value("${spring.arangodb.port}")
	private int arangoDBPort;
	@Value("${spring.arangodb.user}")
	private String arangoDBUser;
	@Value("${spring.arangodb.password}")
	private String arangoDBPassword;
	@Value("${spring.arangodb.database}")
	private String arangoDBDatabase;
	
	public ArangoDbConfiguration() {
		
	}
	
			
			

	@Override
	public Builder arango() {
		 return new ArangoDB.Builder().host(arangoDBHost, arangoDBPort).user(arangoDBUser).password(arangoDBPassword);
		
	}

	@Override
	public String database() {
		
		return arangoDBDatabase;
	}

}
