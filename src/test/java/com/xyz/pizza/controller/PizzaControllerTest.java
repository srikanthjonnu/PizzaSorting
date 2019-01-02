package com.xyz.pizza.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import com.xyz.pizza.beans.Order;
import com.xyz.pizza.beans.Pizza;
import com.xyz.pizza.service.PizzaSortService;

@RunWith(MockitoJUnitRunner.class)
public class PizzaControllerTest {

	@InjectMocks
	private PizzaController pizzaController = new PizzaController();
	
	@Mock
	private PizzaSortService service;
	

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void getData() throws Exception {
		Mockito.when(service.getData(new String())).thenReturn(getOrders());
		Assert.assertTrue(pizzaController.getData(ArgumentMatchers.anyString()).size()==1);
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void writeData() throws Exception {
		Mockito.when(service.writeData(ArgumentMatchers.any(ArrayList.class),
				ArgumentMatchers.anyString())).thenReturn(true);
		Assert.assertTrue(pizzaController.writeData(getOrders(), "outputFile.txt"));
		
	}
	
	
	@Test
	public void readData_Null() throws Exception {
		Mockito.when(service.getData(new String())).thenReturn(null);
		Assert.assertNull(pizzaController.getData(ArgumentMatchers.anyString()));
	}
	
	
	private List<Order> getOrders() {
		List<Order> orderList = new ArrayList<Order>();
		Order order = new Order();
		Pizza pizza = new Pizza.PizzaBuilder("sample").build();
		order.setPizza(pizza);
		order.setOrderTime(new Long(34512351));
		orderList.add(order);
		return orderList;
	}
}
