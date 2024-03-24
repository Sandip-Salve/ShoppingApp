package com.app.shoppingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shoppingapp.dao.IOrderRepository;
import com.app.shoppingapp.entity.Order;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService{

	@Autowired
	private IOrderRepository orderRepo;
	
	@Override
	public Order addUserOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public Order updateUserOrder(Order order) {
		Order exiOrder = orderRepo.findById(order.getoId()).orElse(null);
		exiOrder.setProducts(order.getProducts());
		return orderRepo.save(exiOrder);
	}

	@Override
	public String deleteUserOrder(Order order) {
		orderRepo.deleteById(order.getoId());
		return "Deleted successfully.";
	}

}
