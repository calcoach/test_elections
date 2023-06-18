package com.example.backendprueba.models;

import java.math.BigInteger;

public class Coordinator {

	private BigInteger idCoordinator;
	private String name;
	private String password;
	private long document;
	private String email;
	
	public BigInteger getIdCoordinator() {
		return idCoordinator;
	}
	public void setIdCoordinator(BigInteger idCoordinator) {
		this.idCoordinator = idCoordinator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getDocument() {
		return document;
	}
	public void setDocument(long document) {
		this.document = document;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
