//package com.gcu.data.mapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;
//
//import com.gcu.data.entity.OrderEntity;
//
//public class OrderRowMapper implements RowMapper<OrderEntity> 
//{
//
//	@Override
//	public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException 
//	{			
//		return new OrderEntity(rs.getLong("id"), rs.getString("order_no"), rs.getString("product_name"), rs.getFloat("price"), rs.getInt("quantity"));
//	}
//
//}
