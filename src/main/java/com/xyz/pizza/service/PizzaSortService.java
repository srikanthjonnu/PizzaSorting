package com.xyz.pizza.service;

import java.util.List;

import com.xyz.pizza.beans.Order;

public interface PizzaSortService {

	public List<Order> getData(String inputFileName) throws Exception;
	
	public boolean writeData(List<Order> orders, String outputFileName) throws Exception;
}
