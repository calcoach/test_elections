package com.example.backendprueba.config;

import java.sql.SQLException;

import com.example.backendprueba.data.ConnectionDatabase;

public class Config {
	static String sqlTableElection = "CREATE TABLE IF NOT EXISTS Election (\r\n"
			+ "  id_election SERIAL PRIMARY KEY,\r\n"
			+ "  year INT,\r\n"
			+ "  vote_count BIGINT,\r\n"
			+ "  political_party VARCHAR(50),\r\n"
			+ "  code_county VARCHAR(50)\r\n"
			+ ");\r\n"
			+ "";
	
	static String sqlTableCounty = "CREATE TABLE IF NOT EXISTS County (\r\n"
			+ "  id SERIAL PRIMARY KEY,\r\n"
			+ "  code_county INT,\r\n"
			+ "  county VARCHAR(50),\r\n"
			+ "  population BIGINT,\r\n"
			+ "  area BIGINT\r\n"
			+ ");\r\n"
			+ "";
	
	static String sqlTableCoordinator = "CREATE TABLE IF NOT EXISTS Coordinator (\r\n"
			+ "  id_coordinator SERIAL PRIMARY KEY,\r\n"
			+ "  name VARCHAR(50),\r\n"
			+ "  document BIGINT,\r\n"
			+ "  email VARCHAR(50),\r\n"
			+ "  password VARCHAR(50)\r\n"
			+ ");\r\n"
			+ "";

	public static void config() {
		try {
			ConnectionDatabase database = new ConnectionDatabase();
			database.executeUpdate(sqlTableElection);
			database.executeUpdate(sqlTableCounty);
			database.executeUpdate(sqlTableCoordinator);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
