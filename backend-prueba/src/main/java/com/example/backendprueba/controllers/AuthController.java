package com.example.backendprueba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendprueba.models.Login;
import com.example.backendprueba.services.CoordinatorService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class AuthController {
	
	@Autowired
	CoordinatorService coordinatorService;

	@PostMapping("/login")
	public String login(@RequestBody Login login) {
		if(( coordinatorService).checkCredentials(login)!=null) {
			return "Autenticated";
		}		
		return "Autentication Failed";
	}
}
