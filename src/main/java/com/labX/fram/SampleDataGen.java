package com.labX.fram;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import javax.json.JsonArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labX.fram.datasource.JDBCDataSource;

@Component
public class SampleDataGen {

	@Autowired
	private JDBCDataSource dataSource;

	public void gen() {

		String drop_sql = "DROP TABLE IF EXISTS animals";
		dataSource.put((connection) -> {
			try {
				return connection.prepareStatement(drop_sql);
			} catch (SQLException e) {
				throw new RuntimeException("Problem in drop query building.", e);
			}
		});
		
		String create_sql = "CREATE TABLE animals (type varchar(255), age float, gender varchar(1), color varchar(255))";
		dataSource.put((connection) -> {
			try {
				return connection.prepareStatement(create_sql);
			} catch (SQLException e) {
				throw new RuntimeException("Problem in insert query building.", e);
			}
		});

		String insert_sql = "INSERT INTO animals VALUES(?, ?, ?, ?)";
		dataSource.put((connection) -> {
			try {
				PreparedStatement prepareStatement = connection.prepareStatement(insert_sql);
				prepareStatement.setString(1, "Cow");
				prepareStatement.setDouble(2, 2.4);
				prepareStatement.setString(3, "M");
				prepareStatement.setString(4, "Black");
				return prepareStatement;
			} catch (SQLException e) {
				throw new RuntimeException("Problem in insert query building.", e);
			}
		});
		
		String read_sql = "SELECT * from animals";
		Optional<JsonArray> optional = dataSource.get((connection) -> {
			try {
				return connection.prepareStatement(read_sql);
			} catch (SQLException e) {
				throw new RuntimeException("Problem in select query building.", e);
			}
		});
		
		System.out.println(optional.get());

	}
}
