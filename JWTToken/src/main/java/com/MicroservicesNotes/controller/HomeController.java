package com.MicroservicesNotes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
	
	//http://localhost:8080/Home/users
	@RequestMapping("/welcome")
	public String HomeGetUser() {
		String text ="Ankesh";
		text+="kumar";
		return text;
		
	}

}
