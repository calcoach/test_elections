package com.example.backendprueba.models;

public class CountyData {

	private String codecounty;
	private String county;
	private long population;
	private long area;
	
	
	public CountyData(String codecounty, String county, long population, long area) {
		super();
		this.codecounty = codecounty;
		this.county = county;
		this.population = population;
		this.area = area;
	}
	public String getCodecounty() {
		return codecounty;
	}
	public void setCodecounty(String codecounty) {
		this.codecounty = codecounty;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public long getArea() {
		return area;
	}
	public void setArea(long area) {
		this.area = area;
	}
	
	
	
}
