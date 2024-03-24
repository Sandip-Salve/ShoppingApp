package com.app.shoppingapp.service;

import com.app.shoppingapp.entity.Order;

public interface IOrderService {

	public Order addUserOrder(Order order);
	
	public Order updateUserOrder(Order order);
	
	public String deleteUserOrder(Order order);
}
