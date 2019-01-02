package com.xyz.pizza.beans;

public class Order implements Comparable {

	private Pizza pizza;
	
	private long orderTime;

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public long getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(long orderTime) {
		this.orderTime = orderTime;
	}

	@Override
	public int compareTo(Object o) {
		Order newOrder = (Order)o;
		return this.getOrderTime()== newOrder.getOrderTime()?0:this.getOrderTime() > newOrder.getOrderTime()?1:-1;
	}
}
