package com.xyz.pizza.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.pizza.beans.Order;
import com.xyz.pizza.DAO.PizzaDAO;
import com.xyz.pizza.service.PizzaSortService;

@Service
public class PizzaSortServiceImpl implements PizzaSortService{

	@Autowired
	public PizzaDAO pizzaDAO;
	
	@Override
	public List<Order> getData(String inputFileName) throws Exception {
		// TODO Auto-generated method stub
		return pizzaDAO.getData(inputFileName);
	}

	@Override
	public boolean writeData(List<Order> orders, String outputFileName) throws Exception {
		// TODO Auto-generated method stub
		return pizzaDAO.writeData(orders, outputFileName);
	}

}
