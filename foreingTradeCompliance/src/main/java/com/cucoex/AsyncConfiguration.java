package com.cucoex;

import java.util.concurrent.Executor;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import com.cucoex.controller.CausalController;
@Configuration
@EnableAsync
public class AsyncConfiguration {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(CausalController.class);
	
	@Value("${spring.task.execution.pool.core-size}")
	private int corePoolSize;
	@Value("${spring.task.execution.pool.max-size}")
	private int maxPoolSize;
	@Value("${spring.task.execution.pool.queue-capacity}")
	private int queueCapacity;
	@Value("${spring.task.execution.thread-name-prefix}")
	private String threadNamePrefix;
 	
	
	
	public AsyncConfiguration() {
		log.info("Iniciando configuracion de tareas asincronas");
	
	}

	
	@Bean (name="taskExecutor")
	public Executor taskExecutor() {
		log.info("Creando la tarea ejecutable taskExecutor()");
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		 	executor.setCorePoolSize(this.corePoolSize);
		 	executor.setMaxPoolSize(this.maxPoolSize);
		 	executor.setQueueCapacity(this.queueCapacity);
		 	executor.setThreadNamePrefix(this.threadNamePrefix);
		 	executor.initialize();
		 	
		 	
		return executor;
		
	}
}
