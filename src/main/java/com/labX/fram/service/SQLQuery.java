package com.labX.fram.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.function.Function;

public class SQLQuery implements Query {
	
	private Function<Connection, PreparedStatement> queryBuilder;

	public SQLQuery(Function<Connection, PreparedStatement> queryBuilder) {
		this.queryBuilder = queryBuilder;
	}
	
	public PreparedStatement apply(final Connection connection) {
		return queryBuilder.apply(connection);
	}
	
}
