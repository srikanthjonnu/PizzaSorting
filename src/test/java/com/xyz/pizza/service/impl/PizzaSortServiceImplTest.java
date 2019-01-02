package com.xyz.pizza.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.xyz.pizza.DAO.PizzaDAO;
import com.xyz.pizza.DAO.impl.PizzaDAOImpl;
import com.xyz.pizza.beans.Order;
import com.xyz.pizza.beans.Pizza;
import com.xyz.pizza.service.PizzaSortService;

@RunWith(MockitoJUnitRunner.class)
public class PizzaSortServiceImplTest {

	@InjectMocks
	PizzaSortService service = new PizzaSortServiceImpl();
	
	@Mock
	PizzaDAO pizzaDao = new PizzaDAOImpl();
	
	@Test
	public void getData() throws Exception {
		Mockito.when(pizzaDao.getData(ArgumentMatchers.anyString())).thenReturn(getOrders());
		Assert.assertTrue(service.getData(new String()).size()==1);
	}
	
	/**
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void writeData() throws Exception {
		Mockito.when(pizzaDao.writeData(ArgumentMatchers.any(ArrayList.class),ArgumentMatchers.anyString())).thenReturn(true);
		Assert.assertTrue(service.writeData(getOrders(), "outputFile.txt"));
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	public void getData_Null() throws Exception {
		Mockito.when(pizzaDao.getData(ArgumentMatchers.anyString())).thenReturn(null);
		Assert.assertNull(service.getData(ArgumentMatchers.anyString()));
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
