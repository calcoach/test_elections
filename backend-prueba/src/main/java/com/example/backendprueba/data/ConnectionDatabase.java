package com.example.backendprueba.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDatabase {
	
	Statement stmt;
	ResultSet rs;
	Connection conn;
	
	
	public ConnectionDatabase() throws SQLException {
		this.stmt = null;
		this.rs = null;
		this.conn = null;
	}
	

	public  Connection connect() {
		//LoadDriver.load();
		
		
			try {
			    this.conn =
			       DriverManager.getConnection("jdbc:mysql://localhost/db_elections?" +
			                                   "user=root&password=12345");

			    // Do something with the Connection
			    System.out.println("CONECTADO A LA DATABASE");

			   
			} catch (SQLException ex) {
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
			
			return this.conn;
			
		
	}	
	
	public void closeConnection() throws SQLException {
		
		if(rs != null & stmt !=null) {
			this.rs.close();
			 
			this.stmt.close();
			
			this.conn.close();
			System.out.println("CONECCION CERADA");
		}
	    
	}
	
	public ResultSet executeQuery(String query) {
		
		Connection conn = this.connect();

		try {
			this.stmt = conn.createStatement();
		    rs = stmt.executeQuery(query);

		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...

		    if (stmt.execute(query)) {
		        rs = stmt.getResultSet();
		        
		        return rs;
		    }

		    // Now do something with the ResultSet ....
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		return rs;
	}
	
	public void executeUpdate(String sql) {
		Connection conn = this.connect();
		try {
			  //stmt = conn.prepareStatement();  
			  stmt = conn.createStatement();

			  stmt.execute(sql); 
			  stmt.close();	           
			} catch (SQLException sqle) { 
			  System.out.println("Error en la ejecución: " 
			    + sqle.getErrorCode() + " " + sqle.getMessage());    
			}
	}
	
	 public PreparedStatement getPreparedStatement(String query) throws SQLException {
		 this.conn = this.connect();
		 try {

			 PreparedStatement statement = conn.prepareStatement(query);
	         return statement;
	        } catch (SQLException e) {
	            System.out.println("Error while inserting data into County table: " + e.getMessage());
	        }
		 throw new SQLException();
	 }
	
	public void update(PreparedStatement pst) {
	
		 try  {
	            pst.executeUpdate();
	            this.closeConnection();
	            System.out.println("Data inserted successfully into County table.");
	        } catch (SQLException e) {
	            System.out.println("Error while inserting data into County table: " + e.getMessage());
	        }
	}
	


}
