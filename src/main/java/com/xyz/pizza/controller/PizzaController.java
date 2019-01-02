package com.xyz.pizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xyz.pizza.beans.Order;
import com.xyz.pizza.service.PizzaSortService;

@Controller
public class PizzaController {
	@Autowired
	public PizzaSortService service;

	public List<Order> getData(String inputFileName) throws Exception{
		return service.getData(inputFileName);
	}
	
	public boolean writeData(List<Order> orders,String outputFileName) throws Exception{
		return service.writeData(orders, outputFileName);
	}
}
