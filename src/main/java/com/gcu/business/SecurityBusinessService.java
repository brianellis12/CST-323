package com.gcu.business;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class SecurityBusinessService 
{
	Logger logger = LoggerFactory.getLogger(SecurityBusinessService.class);
	public boolean authenticate(String username, String password) 
	{
		logger.info("Entering SecurityBusinessService.authenticate()");
		System.out.println(String.format("Hello from the SecurityBusinessService with a username of %s and a password of %s", username, password));
		logger.info("Exiting SecurityBusinessService.authenticate()");
		return true;
		
	}
}
