package com.example.backendprueba.models;

public class Election {

	private int idElection;
	private int year;
	private long votecount;
	private String politicalParty;
	private String codecounty;
	
	
	public Election() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Election( int year, long votecount, String politicalParty, String codecounty) {
		super();
		this.idElection = idElection;
		this.year = year;
		this.votecount = votecount;
		this.politicalParty = politicalParty;
		this.codecounty = codecounty;
	}



	public int getIdElection() {
		return idElection;
	}

	public void setIdElection(int idElection) {
		this.idElection = idElection;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public long getVotecount() {
		return votecount;
	}

	public void setVotecount(long votecount) {
		this.votecount = votecount;
	}

	public String getPoliticalParty() {
		return politicalParty;
	}

	public void setPoliticalParty(String politicalParty) {
		this.politicalParty = politicalParty;
	}



	public String getCodecounty() {
		return codecounty;
	}



	public void setCodecounty(String codecounty) {
		this.codecounty = codecounty;
	}
	
}
