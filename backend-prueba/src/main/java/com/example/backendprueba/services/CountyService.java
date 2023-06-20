package com.example.backendprueba.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendprueba.data.ConnectionDatabase;
import com.example.backendprueba.models.County;
import com.example.backendprueba.models.CountyData;

@Service
public class CountyService implements ICrudService<County> {

	@Override
	public List<County> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public County save(County county) {
		// TODO Auto-generated method stub
		try {
			ConnectionDatabase database = new ConnectionDatabase();
			database.newConnect();
			PreparedStatement statement = database.getPreparedStatement(
					"INSERT INTO County (code_county, county, population, area) VALUES (?, ?, ?, ?)");

			statement.setString(1, county.getCodeCounty());
			statement.setString(2, county.getCounty());
			statement.setLong(3, county.getPopulation());
			statement.setLong(4, county.getArea());

			database.update(statement);
			database.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public County save(List<CountyData> countyData) {
		// TODO Auto-generated method stub
		try {
			ConnectionDatabase database = new ConnectionDatabase();
			database.newConnect();
			PreparedStatement statement = database.getPreparedStatement(
					"INSERT INTO County (code_county, county, population, area) VALUES (?, ?, ?, ?)");

			for (CountyData county : countyData) {

				statement.setString(1, String.valueOf(county.getCodecounty()));
				statement.setString(2, county.getCounty());
				statement.setLong(3, county.getPopulation());
				statement.setLong(4, county.getArea());

				statement.addBatch();

			}
			database.updateBatch(statement);
			database.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(County coordinator) {
		// TODO Auto-generated method stub

	}

	@Override
	public County findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
