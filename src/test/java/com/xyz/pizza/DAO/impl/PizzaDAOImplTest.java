package com.xyz.pizza.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.xyz.pizza.DAO.PizzaDAO;
import com.xyz.pizza.beans.Order;
import com.xyz.pizza.beans.Pizza;

@RunWith(MockitoJUnitRunner.class)
public class PizzaDAOImplTest {

	@InjectMocks
	PizzaDAO pizzaDao = new PizzaDAOImpl();
	
	
	/*@Before
	public void injectMocks() {
		MockitoAnnotations.initMocks(this);
	}*/
	
	@Test
	public void getData() throws Exception {
		Assert.assertNotNull(pizzaDao.getData("sampleOrders.txt"));
	}
	
	
	@Test
	public void writeData() throws Exception {
		Assert.assertSame(true, pizzaDao.writeData(getOrders(), "output.txt"));
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
