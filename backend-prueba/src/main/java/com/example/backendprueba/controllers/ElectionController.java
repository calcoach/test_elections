package com.example.backendprueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendprueba.models.Election;
import com.example.backendprueba.models.ElectionData;
import com.example.backendprueba.services.ElectionService;
import com.example.backendprueba.services.ICrudService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ElectionController {
	
	@Autowired
	ElectionService electionService;

	@PostMapping("/election")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Election createElection(@RequestBody Election election) {
		electionService.save(election);
		return election;
	}
	
	@GetMapping("/election")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Election> getAllElection() {
		
		electionService.getAll();
		
		return null;
	}
	
	@PostMapping("/electiondata")
	@ResponseStatus(value = HttpStatus.CREATED)
	public List<ElectionData> createElectionData(@RequestBody List<ElectionData> electionsData) {
		this.electionService.save(electionsData);
		
		return electionsData;
	}
	
}
