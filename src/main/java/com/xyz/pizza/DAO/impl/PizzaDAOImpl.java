package com.xyz.pizza.DAO.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.xyz.pizza.DAO.PizzaDAO;
import com.xyz.pizza.beans.Order;
import com.xyz.pizza.beans.Pizza;
import com.xyz.pizza.utils.PizzaUtil;

@Repository
public class PizzaDAOImpl implements PizzaDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(PizzaDAOImpl.class);
	@Override
	public List<Order> getData(String inputFileName) throws Exception {
        List<Order> orderList = new ArrayList<Order>();		
		File file = null;
		try {
			file = new File(inputFileName);
			LOGGER.info("Input File Read Start");
			Scanner scan = new Scanner(file);
			String headers = scan.nextLine();
			while(scan.hasNextLine()) {
				String orderInfo = scan.nextLine();
				if(orderInfo != null && !"".equalsIgnoreCase(orderInfo)) {
					String[] info = orderInfo.split("\\W+");
					String name = null;
					Long time = null;
					for(int i=0;i<info.length;i++) {
						if(i%2==0) {
							name = info[i];
						}else {
							time = Long.valueOf(info[i]);
						}
						if(name!=null && time!=null) {
							Order order = new Order();
							Pizza pizza = new Pizza.PizzaBuilder(name).build();
							order.setPizza(pizza);
							order.setOrderTime(time.longValue());
							orderList.add(order);
							name=null;
							time = null;
						}	
					}
				}
			}
			Collections.sort(orderList);
			scan.close();
			LOGGER.info("Input File Read End");
			
		} catch(IOException ioe) {
			LOGGER.error("Error occurred while reading data from input file "+ioe.getMessage());
			throw ioe;
		} catch (Exception ex) {
			LOGGER.error("Error occurred while processing the file "+ex.getMessage());
			throw ex;
		}
		return orderList;
	}

	@Override
	public boolean writeData(List<Order> orders, String outputFileName) throws Exception {
		File file = new File(outputFileName);
		FileOutputStream fileoutputStream = null;
		BufferedWriter bw = null;
		boolean success = false;
		String line = "";
		try {
			LOGGER.info("Output File Write Start");
			fileoutputStream = new FileOutputStream(file);
			bw = new BufferedWriter(new OutputStreamWriter(fileoutputStream));
			bw.write(String.format("%5s\t%10s","NAME","TIME"));
			bw.newLine();
			for (Order order : orders) {
				line = String.format("%-10s\t%-20s", order.getPizza().getName(),PizzaUtil.convertEpochToUTC(order.getOrderTime() * 1000));
				bw.write(line);
				bw.newLine();
			}
			bw.flush();
			success = true;
		} catch (Exception e) {
			LOGGER.error("Error:" + e.getMessage(), e);
			throw e;
		} finally {
			bw.close();
			fileoutputStream.close();
		}
		LOGGER.info("Output File Write End");
		return success;
	}
	

}
