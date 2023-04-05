package com.gcu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.SecurityBusinessService;
@Controller
@RequestMapping("/")
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(SecurityBusinessService.class);
	@GetMapping("/")
	public String Home(Model model) {
		logger.info("Entering HomeController.Home()");
		model.addAttribute("welcomeMessage", "Welcome to CST-339 Topic 2 Activity");
		
		logger.info("Exiting HomeController.Home()");
		return "home";
	}
}
