package com.app.shoppingapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.shoppingapp.entity.Order;
import com.app.shoppingapp.service.IOrderService;

@RestController
public class OrderController {

	@Autowired
	private IOrderService orderService;
	
	protected Logger log = LogManager.getLogger();
	
	@PostMapping("/addOrder")
	public ResponseEntity<Object> addOrder(@RequestBody Order order){
		log.info("Inside OrderController's addOrder : "+order);
		Order addedUserOrder = orderService.addUserOrder(order);
		return new ResponseEntity<Object> (addedUserOrder, HttpStatus.CREATED);
	}
	
	@PostMapping("/updateOrder")
	public ResponseEntity<Object> updateOrder(@RequestBody Order order){
		log.info("Inside OrderController's updateOrder : "+order);
		Order updatedUserOrder = orderService.updateUserOrder(order);
		return new ResponseEntity<Object> (updatedUserOrder, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/cancelOrder")
	public ResponseEntity<Object> cancelOrder(@RequestBody Order order){
		log.info("Inside OrderController's deleteOrder : "+order);
		String deletedOrderStaus = orderService.deleteUserOrder(order);
		return new ResponseEntity<Object> (deletedOrderStaus, HttpStatus.OK);
	}
	
}
