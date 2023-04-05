package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;

@Configuration
public class SpringConfig
{
	//Bean annotation is applied at the method level
	@Bean(name="ordersBusinessService", destroyMethod="destroy", initMethod="init")
	//@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	//@RequestScope
	//@SessionScope
	public OrdersBusinessServiceInterface getOrdersBusiness() 
	{
		//Return defines which java class is invoked
		return new OrdersBusinessService();
	}
}
