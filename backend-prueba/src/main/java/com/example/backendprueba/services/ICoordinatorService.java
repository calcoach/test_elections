package com.example.backendprueba.services;

import java.util.List;

import com.example.backendprueba.models.Coordinator;
import com.example.backendprueba.models.Login;

public interface ICoordinatorService {

    public List<Coordinator> getAll();
    
    public void delete(Long id);
	
	public Coordinator save(Coordinator coordinator);
	
	public void update(Coordinator coordinator);
	
	public Coordinator findById(Long id);
	
	public Coordinator checkCredentials(Login login);
}
