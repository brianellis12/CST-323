package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.business.SecurityBusinessService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity> 
{
	@Autowired
	private OrdersRepository ordersRepository;
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	Logger logger = LoggerFactory.getLogger(SecurityBusinessService.class);
	public OrderDataService(OrdersRepository ordersRepository, DataSource dataSource)
	{
		this.ordersRepository = ordersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<OrderEntity> findAll() 
	{
		logger.info("Entering OrderDataService.findAll()");
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		
		try {
			Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();
			
			orders = new ArrayList<OrderEntity>();
			ordersIterable.forEach(orders::add);		
		}
		catch (Exception e) 
		{
			logger.error("Exception in OrderDataService.findAll(): " + e);
		}
		logger.info("Exiting OrderDataService.findAll()");
		return orders;
	}

	public boolean create(OrderEntity order) 
	{
		logger.info("Entering OrderDataService.create()");
		String sql = "INSERT INTO order(order_no, product_name, price, quantity) VALUES(?,?,?,?)";
		try {
			jdbcTemplateObject.update(sql, order.getOrderNo(), order.getProductName(), order.getPrice(),
					order.getQuantity());			
		} catch (Exception e) {
			logger.error("Exception in OrderDataService.create(): " + e);
			return false;
		}
		logger.info("Exiting OrderDataService.create()");
		return true;
	}

}
