package com.xyz.pizza.DAO;

import java.util.List;

import com.xyz.pizza.beans.Order;


public interface PizzaDAO {

    public List<Order> getData(String inputFileName) throws Exception;
	public boolean writeData(List<Order> orders, String outputFileName) throws Exception;

}
