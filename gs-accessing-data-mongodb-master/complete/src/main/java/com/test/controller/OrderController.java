package com.test.controller;

import javax.inject.Inject;
import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;

import com.test.model.Order;
import com.test.service.OrderService;

@Controller
@Path("/Order")
public class OrderController {

	@Inject
	private OrderService  OrderService;
	
	
	
	@Path("/getOrderDetailById")
	public Order getOrderDetailById()
	{
		return new Order();
	}
	 
	@Path("/updateOrderDetailById")
	public Order updateOrderDetailById()
	{
		return new Order();
	}
	
	
	@Path("/createOrder")
	public Order createOrder() 
	{
		return new Order();
	}
	
	
	@Path("/deleteOrder")
	public Order deleteOrder()
	{
		return new Order();
	}
	
	
	
	
}
