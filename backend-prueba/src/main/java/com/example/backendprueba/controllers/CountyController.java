package com.example.backendprueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendprueba.models.County;
import com.example.backendprueba.models.CountyData;
import com.example.backendprueba.models.Election;
import com.example.backendprueba.models.ElectionData;
import com.example.backendprueba.services.CountyService;
import com.example.backendprueba.services.ICrudService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CountyController {
	@Autowired
	CountyService electionService;

	@PostMapping("/county")
	@ResponseStatus(value = HttpStatus.CREATED)
	public County createCounty(@RequestBody County election) {
		electionService.save(election);
		return election;
	}
	
	@PostMapping("/countydata")
	@ResponseStatus(value = HttpStatus.CREATED)
	public List<CountyData> createElectionData(@RequestBody List<CountyData> electionsData) {
			electionService.save((List<CountyData>) electionsData);
	
		return electionsData;
	}
	
}
