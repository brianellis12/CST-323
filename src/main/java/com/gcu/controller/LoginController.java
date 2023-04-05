package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;


@Controller
@RequestMapping("/login")
public class LoginController
{
	// Dependency Injection
	//We can use auto wiring on properties, setters, and constructors
	//Using autowired on a property  eliminates the need for getters and setters
	// When autowiring a property in bean the property's class type is used
	//for searching a matching bean definition in the configuration file
	// If a bean is found, it is injected into the property.
	// In this case, autowiring to SpringConfig getOrdersBuisness method.
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	@Autowired
	private SecurityBusinessService security;
	
	Logger logger = LoggerFactory.getLogger(SecurityBusinessService.class);
	@GetMapping("/")
	public String display(Model model) {
		logger.info("Entering LoginController.display()");
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		
		logger.info("Exiting LoginController.display()");
		return "login";
	}
	
	
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		logger.info("Entering LoginController.doLogin()");
		//Check for validation errors
		if(bindingResult.hasErrors()) 
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		//make a call to the SecurityBusinessService
		security.authenticate(loginModel.getUsername(), loginModel.getPassword());
		
		//make a call to the OrdersBuisnessService
		service.test();		
		
		
		//Display the Orders View
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", service.getOrders());
		//Print the form values out
		//System.out.println(String.format("Form with Username of %s and Password of %s", loginModel.getUsername(), loginModel.getPassword()));
		
		logger.info("Exiting LoginController.doLogin()");
		
		//Navigate back to the Login View
		return "orders";
	}
	
	
}
