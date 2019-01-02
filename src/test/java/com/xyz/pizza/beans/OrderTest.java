package com.xyz.pizza.beans;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class OrderTest {

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	@Test
	public void getPizza() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Order order = getOrderBean();
		final Field field = order.getClass().getDeclaredField("pizza");
		field.setAccessible(true);
		
		Pizza pizza = new Pizza.PizzaBuilder("sample").build();
		field.set(order, pizza);
		final Pizza pizzaObj = order.getPizza();
		Assert.assertEquals("Field wasn't retreived properly", pizzaObj, pizza);
	}
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	@Test
	public void setPizza() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Order order = getOrderBean();
		Pizza pizza = new Pizza.PizzaBuilder("sample").build();
		order.setPizza(pizza);
		final Field field = order.getClass().getDeclaredField("pizza");
		field.setAccessible(true);
		Assert.assertEquals("Fields didn't match", field.get(order), pizza);
	}
	

	@Test
	public void getOrderTime() {
		Order order = getOrderBean();
		Assert.assertEquals(order.getOrderTime(), 1477491887);
	}
	

	@Test
	public void setTime() {
		Order order = getOrderBean();
		order.setOrderTime(new Long(1477491887));
		Assert.assertEquals(order.getOrderTime(), 1477491887);
	}
	

	@Test
	public void compareToTest() {
		Order order = new Order();
		order.setOrderTime(new Long(1477491887));
		Assert.assertSame(0,  order.compareTo(order));
	}
	

	private Order getOrderBean() {
		Order order = new Order();
		Pizza pizza = new Pizza.PizzaBuilder("SamplePizza").build();		
		order.setPizza(pizza);
		order.setOrderTime(new Long(1477491887));
		return order;
	}
	
}
