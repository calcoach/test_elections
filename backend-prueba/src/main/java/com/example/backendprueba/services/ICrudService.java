package com.example.backendprueba.services;

import java.util.List;

import com.example.backendprueba.models.Election;


public interface ICrudService <E>{

    public List<E> getAll();
    
    public void delete(Long id);
	
	public E save( E election);
	
	public void update(E object);
	
	public E findById(Long id);
	
}
