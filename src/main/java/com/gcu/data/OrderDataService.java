package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
//import com.gcu.data.repository.OrdersRepository;
import com.gcu.model.OrderModel;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity> 
{
//	@Autowired
//	private OrdersRepository ordersRepository;
//	
//	@SuppressWarnings("unused")
//	private DataSource dataSource;
//	private JdbcTemplate jdbcTemplateObject;
//	
//	public OrderDataService(OrdersRepository ordersRepository, DataSource dataSource)
//	{
//		this.ordersRepository = ordersRepository;
//		this.dataSource = dataSource;
//		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
//	}

	public List<OrderEntity> findAll() 
	{
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		orders.add(new OrderEntity(0L, "0000000001", "Product 1", 1.00f, 1));
		orders.add(new OrderEntity(1L, "0000000002", "Product 2", 2.00f, 2));
		orders.add(new OrderEntity(2L, "0000000003", "Product 3", 3.00f, 3));
		orders.add(new OrderEntity(3L, "0000000004", "Product 4", 4.00f, 4));
		orders.add(new OrderEntity(4L, "0000000005", "Product 5", 5.00f, 5));

		return orders;
	}

	
	public OrderEntity findById(int id) {
		
		return null;
	}

	
	public boolean create(OrderEntity order) 
	{
//		String sql = "INSERT INTO order(order_no, product_name, price, quantity) VALUES(?,?,?,?)";
//		try {
//			jdbcTemplateObject.update(sql, order.getOrderNo(), order.getProductName(), order.getPrice(),
//					order.getQuantity());			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
		return true;
	}
		
	

	
	public boolean update(OrderEntity t) {
		
		return true;
	}

	
	public boolean delete(OrderEntity t) {
		
		return true;
	}

}
