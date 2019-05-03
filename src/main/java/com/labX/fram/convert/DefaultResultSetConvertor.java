package com.labX.fram.convert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import org.springframework.stereotype.Component;

@Component
public class DefaultResultSetConvertor implements Convertor<ResultSet, JsonArray> {

	@Override
	public JsonArray convert(final ResultSet input) {
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

		try {
			while (input.next()) {
				int rows = input.getMetaData().getColumnCount();
				Map<String, Object> rowData = new HashMap<>();
				for (int i = 0; i < rows; i++) {
					rowData.put(input.getMetaData().getColumnLabel(i + 1).toLowerCase(), input.getObject(i + 1));
				}

				arrayBuilder.add(Json.createObjectBuilder(rowData).build());
			}
		} catch (SQLException e) {
			throw new RuntimeException("ResultSet to JsonArray conversion failed", e);
		}

		return arrayBuilder.build();
	}

}
