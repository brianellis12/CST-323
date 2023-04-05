package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrderDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//implement interface to access methods
public class OrdersBusinessService implements OrdersBusinessServiceInterface 
{
	@Autowired
	OrderDataService service;
	Logger logger = LoggerFactory.getLogger(OrdersBusinessService.class);
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");
	}

	@Override
	public List<OrderModel> getOrders() 
	{
		logger.info("Entering OrdersBusinessService.getOrders()");
		List<OrderEntity> ordersEntity = service.findAll();
		
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		for(OrderEntity entity : ordersEntity)
		{
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		
		logger.info("Exiting OrdersBusinessService.getOrders()");
		return ordersDomain;
	}

	@Override
	public void init() {
		System.out.println("OrdersBusinessService init method");		
	}

	@Override
	public void destroy() {
		System.out.println("OrdersBusinessService destroy method");
		
	}

}
