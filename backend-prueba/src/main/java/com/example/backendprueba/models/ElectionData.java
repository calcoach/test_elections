package com.example.backendprueba.models;

public class ElectionData {
	
	private int year;
	private long democrat;
	private long republic;
	private long other;
	private String codecounty;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public long getDemocrat() {
		return democrat;
	}
	public void setDemocrat(long democrat) {
		this.democrat = democrat;
	}
	public long getRepublic() {
		return republic;
	}
	public void setRepublic(long republic) {
		this.republic = republic;
	}
	public long getOther() {
		return other;
	}
	public void setOther(long other) {
		this.other = other;
	}
	public String getCodecounty() {
		return codecounty;
	}
	public void setCodecounty(String codecounty) {
		this.codecounty = codecounty;
	}
	
}
