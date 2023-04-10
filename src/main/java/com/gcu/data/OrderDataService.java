package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

//import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import com.gcu.business.SecurityBusinessService;
import com.gcu.data.entity.OrderEntity;
//import com.gcu.data.repository.OrdersRepository;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity> 
{
	//@Autowired
	//private OrdersRepository ordersRepository;
	
	//@SuppressWarnings("unused")
	//private DataSource dataSource;
	//private JdbcTemplate jdbcTemplateObject;
	
	Logger logger = LoggerFactory.getLogger(SecurityBusinessService.class);
	public OrderDataService()//OrdersRepository ordersRepository, DataSource dataSource)
	{
		//this.ordersRepository = ordersRepository;
		//this.dataSource = dataSource;
		//this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<OrderEntity> findAll() 
	{
		logger.info("Entering OrderDataService.findAll()");
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		
		orders.add(new OrderEntity(0L, "0000000001", "Product 1", 1.00f, 1));
		orders.add(new OrderEntity(1L, "0000000002", "Product 2", 2.00f, 2));
		orders.add(new OrderEntity(2L, "0000000003", "Product 3", 3.00f, 3));
		orders.add(new OrderEntity(3L, "0000000004", "Product 4", 4.00f, 4));
		orders.add(new OrderEntity(4L, "0000000005", "Product 5", 5.00f, 5));
		orders.add(new OrderEntity(5L, "0000000006", "Product 6", 6.00f, 6));
		orders.add(new OrderEntity(6L, "0000000007", "Product 7", 7.00f, 7));
		orders.add(new OrderEntity(7L, "0000000008", "Product 8", 8.00f, 8));
		orders.add(new OrderEntity(8L, "0000000009", "Product 9", 9.00f, 9));
		orders.add(new OrderEntity(9L, "0000000010", "Product 10", 10.00f, 10));
		orders.add(new OrderEntity(10L, "0000000100", "Product 100", 100.00f, 100));
		logger.info("Exiting OrderDataService.findAll()");
		return orders;
	}

	public boolean create(OrderEntity order) 
	{
//		logger.info("Entering OrderDataService.create()");
//		String sql = "INSERT INTO order(order_no, product_name, price, quantity) VALUES(?,?,?,?)";
//		try {
//			jdbcTemplateObject.update(sql, order.getOrderNo(), order.getProductName(), order.getPrice(),
//					order.getQuantity());			
//		} catch (Exception e) {
//			logger.error("Exception in OrderDataService.create(): " + e);
//			return false;
//		}
//		logger.info("Exiting OrderDataService.create()");
		return true;
	}

}
