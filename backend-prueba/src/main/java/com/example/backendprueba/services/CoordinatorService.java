package com.example.backendprueba.services;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backendprueba.data.ConnectionDatabase;
import com.example.backendprueba.models.Coordinator;
import com.example.backendprueba.models.Login;

@Service
public class CoordinatorService implements ICrudService<Coordinator> {

	@Override
	public List<Coordinator> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Coordinator save(Coordinator coordinator) {
		// TODO Auto-generated method stub
		try {
			
			ConnectionDatabase database = new ConnectionDatabase();
			PreparedStatement statement = database.getPreparedStatement
					("INSERT INTO Coordinator ( name, document, email, password) VALUES (?, ?, ?, ?)");
			
			statement.setString(1, coordinator.getName());
			statement.setLong(2, coordinator.getDocument());
            
            statement.setString(3, coordinator.getEmail());
            statement.setString(4, coordinator.getPassword());
            
            database.update(statement);
            return coordinator;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Coordinator coordinator) {
		// TODO Auto-generated method stub

	}

	@Override
	public Coordinator findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Coordinator checkCredentials(Login login) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM coordinator WHERE email =\'"+login.getEmail()+"\' AND password=\'"+login.getPassword()+"\';";
		
		try {
			ConnectionDatabase database = new ConnectionDatabase();
			ResultSet rs = database.executeQuery(query);
			
			if(rs!=null) {
				while (rs.next()) {
					Coordinator coordinator = new Coordinator();
					coordinator.setIdCoordinator(new BigInteger( rs.getObject("id_coordinator").toString()));
					coordinator.setEmail(rs.getString("name"));
					coordinator.setDocument((long)rs.getObject("document"));
					coordinator.setEmail(rs.getString("email"));
					coordinator.setPassword(rs.getString("password"));
					
					return coordinator;
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
