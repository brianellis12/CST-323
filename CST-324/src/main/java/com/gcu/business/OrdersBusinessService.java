package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrderDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

//implement interface to access metods
public class OrdersBusinessService implements OrdersBusinessServiceInterface 
{
	@Autowired
	OrderDataService service;
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");
	}

	@Override
	public List<OrderModel> getOrders() 
	{
		List<OrderEntity> ordersEntity = service.findAll();
		
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		for(OrderEntity entity : ordersEntity)
		{
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		
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
