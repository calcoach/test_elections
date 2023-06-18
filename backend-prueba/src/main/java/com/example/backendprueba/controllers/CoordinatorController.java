package com.example.backendprueba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendprueba.models.Coordinator;
import com.example.backendprueba.models.Election;
import com.example.backendprueba.services.ICrudService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CoordinatorController {

	@Autowired
	ICrudService<Coordinator> coordinatorService;

	@PostMapping("/coordinator")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Coordinator createElection(@RequestBody Coordinator election) {
		System.out.println("Entre al controller jajajajja");
		
		return coordinatorService.save(election) ;
		
	}
}
