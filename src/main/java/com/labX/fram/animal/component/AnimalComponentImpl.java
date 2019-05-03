package com.labX.fram.animal.component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labX.fram.animal.request.AnimalRequest;
import com.labX.fram.common.service.ExecutorService;
import com.labX.fram.component.AbstractCompoennt;
import com.labX.fram.service.SQLQuery;
import com.labX.fram.service.ServiceFactory;
import com.labX.fram.service.ServiceNameResolver;

@Component("animalComponent")
public class AnimalComponentImpl extends AbstractCompoennt implements AnimalComponent {

	private static final String READ_ALL_QUERY = "SELECT * FROM animals";
	
	@Autowired
	private ServiceFactory serviceFactory;

	@Override
	public JsonObject readAll(final AnimalRequest withType) {
		ExecutorService executorService = serviceFactory.resolve(ServiceNameResolver.resolve("executor"));

		SQLQuery query = new SQLQuery((connection) -> this.build(connection, READ_ALL_QUERY));

		Optional<JsonArray> result = executorService.execute(query);
		return Json.createObjectBuilder().add("data", result.isPresent() ? result.get() : null).build();
	}

	private PreparedStatement build(final Connection connection, final String query) {
		try {
			return connection.prepareStatement(query);
		} catch (SQLException e) {
			throw new RuntimeException("Probelm in query building");
		}
	}
}
