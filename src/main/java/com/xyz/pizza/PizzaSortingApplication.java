package com.xyz.pizza;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import com.xyz.pizza.beans.Order;
import com.xyz.pizza.controller.PizzaController;

@SpringBootApplication
public class PizzaSortingApplication extends SpringBootServletInitializer{

	private static final Logger LOGGER = LoggerFactory.getLogger(PizzaSortingApplication.class);
	
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PizzaSortingApplication.class);
	}
	
	public static void main(String[] args) {
		
	   try {	
		ApplicationContext appCtx = SpringApplication.run(PizzaSortingApplication.class,args);
		
		PizzaController controller = appCtx.getBean(PizzaController.class);
		if (args.length == 3) {
			List<Order> orders = controller.getData(args[1]);
			boolean flag = controller.writeData(orders, args[2]);
			if (flag) {
				LOGGER.info("Data Written to output file successfully");
			}
		} else {
			throw new Exception("Invalid Parameters.Expected Source and Destination files.");
		}
		
	   }catch (Exception e) {
		   e.printStackTrace();
		   LOGGER.error("Error in initializing the application"+e.getMessage());
 	   }
		
	}

}

