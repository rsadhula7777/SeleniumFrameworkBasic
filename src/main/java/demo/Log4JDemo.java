package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JDemo {
	
	private static Logger logger=LogManager.getLogger(Log4JDemo.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("\n Hello World  \n");
		
		logger.info("This is information message");
		logger.info("This is error message");
		logger.error("Error");
		logger.fatal("Fatal");
		
		System.out.println("Completed");

	}

}
