/**
 * 
 */
package com.cucoex.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cucoex.service.MonitorServiceImpl;

/**
 * @author enrique
 *
 */
@Component
public class ScheduledTasks {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
	
	@Autowired
	MonitorServiceImpl monitorService;
	

	/**
	 * 
	 */
	public ScheduledTasks() {
		
	}

	/* Schedule a Task Using Cron Expressions */
	/*
	 * Note that in this example, we're scheduling a task to be executed at 10:15 AM
	 * on the 15th day of every month
	 * cron = "0 15 10 15 * ?"
	 */
	//@Scheduled(cron = "0 15 10 15 * ?" , zone = "GMT-5")
	@Scheduled(cron = "${cron.expression.monitor}")
	public void scheduleTaskUsingCronExpression() {
	 
	    long now = System.currentTimeMillis() / 1000;
	    log.info(
	      "Ejecutando tarea programada para monitor - " + now);
	    currentTime();
	    monitorService.updateAllComplianceStatus();
	}
	/*
	 * Fixed Rate vs Fixed Delay
	 * 
	 * We can run a scheduled task using Spring's @Scheduled annotation, but based
	 * on the properties fixedDelay and fixedRate, the nature of execution changes.
	 * 
	 * The fixedDelay property makes sure that there is a delay of n millisecond
	 * between the finish time of an execution of a task and the start time of the
	 * next execution of the task.
	 * 
	 * This property is specifically useful when we need to make sure that only one
	 * instance of the task runs all the time. For dependent jobs, it is quite
	 * helpful.
	 * 
	 * The fixedRate property runs the scheduled task at every n millisecond. It
	 * doesn't check for any previous executions of the task.
	 */
	
	//@Scheduled(fixedDelay = 1000)  // Ejecuta cada tiempodescomentar para ejecutar
	//@Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}") // con los milis en el archivo de propiedades
	public void scheduleFixedDelayTask() {
	    log.info(
	      "Fixed delay task - " + System.currentTimeMillis() / 1000);
	}
	

	/*
	 * Note that scheduled tasks don't run in parallel by default. So even if we
	 * used fixedRate, the next task won't be invoked until the previous one is
	 * done.
	 */ 
	//@Scheduled(fixedRate = 1000) // descomentar para ejecutar. Espera un tiempo y ejecuta
	//@Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
	public void scheduleFixedRateTask() {
	    log.info(
	      "Fixed rate task - " + System.currentTimeMillis() / 1000);
	}
	
	
	/*
	 * If we want to support parallel behavior in scheduled tasks, we need to add
	 * the @Async annotation:
	 */
	
	// @Async
    // @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        log.info(
          "Fixed rate task async - " + System.currentTimeMillis() / 1000);
        Thread.sleep(2000);
    }
	
    
	/*
	 * Note how we're using both fixedDelay as well as initialDelay in this example.
	 * The task will be executed the first time after the initialDelay value, and it
	 * will continue to be executed according to the fixedDelay. This option is
	 * convenient when the task has a setup that needs to be completed.
	 */
    // @Scheduled(fixedDelay = 1000, initialDelay = 5000) 
    public void scheduleFixedRateWithInitialDelayTask() {
     
        long now = System.currentTimeMillis() / 1000;
        log.info(
          "Fixed rate task with one second initial delay - " + now);
    }
	
    private void currentTime() {
        log.info("Current Time      = {}", dateFormat.format(new Date()));
    }
	
}
