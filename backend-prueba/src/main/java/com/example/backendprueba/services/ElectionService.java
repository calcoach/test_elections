package com.example.backendprueba.services;

import com.example.backendprueba.models.Election;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendprueba.data.ConnectionDatabase;

@Service
public class ElectionService implements ICrudService<Election> {

	@Override
	public Election save(Election election) {
		// TODO Auto-generated method stub
try {
	        ConnectionDatabase database = new ConnectionDatabase();
			PreparedStatement statement = database.getPreparedStatement
					("INSERT INTO Election ( year, vote_count, political_party, code_county) VALUES (?, ?, ?, ?)");
			
			statement.setInt(1, election.getYear());
			statement.setLong(2, election.getVotecount());
            
            statement.setString(3, election.getPoliticalParty());
            statement.setString(4, election.getCodecounty());
            
            database.update(statement);
            database.closeConnection();
            return election;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return null;
	}

	@Override
	public List<Election> getAll() {
		// TODO Auto-generated method stub
		

		try {
			
			ConnectionDatabase database = new ConnectionDatabase();
			ResultSet rs = database.executeQuery("SELECT * FROM alumno");
			
			while (rs.next()) {
				System.out.print(rs.getInt("alumno_id") + "\t");
				System.out.print(rs.getInt("creditos_inscritos") + "\t");
				System.out.print(rs.getString("facultad") + "\t");
				System.out.print(rs.getString("firs_name") + "\t");
				System.out.println("");
			}
			
			database.closeConnection();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Election object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Election findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
