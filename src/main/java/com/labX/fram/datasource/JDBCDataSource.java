package com.labX.fram.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.json.JsonArray;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labX.fram.convert.DefaultResultSetConvertor;
import com.labX.fram.service.SQLQuery;

@Component
public class JDBCDataSource {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private DefaultResultSetConvertor resultSetConvertor;

	@Transactional
	public Optional<JsonArray> get(final SQLQuery query) {
		return get((connection) -> query.apply(connection), (resultSet) -> resultSetConvertor.convert(resultSet));
	}

	@Transactional
	public <T> Optional<T> get(final SQLQuery query, final Function<ResultSet, T> resultExtractor) {
		return get((connection) -> query.apply(connection), resultExtractor);
	}

	@Transactional
	public Optional<JsonArray> get(final Function<Connection, PreparedStatement> prepareStatementProvider) {
		return get(prepareStatementProvider, (resultSet) -> resultSetConvertor.convert(resultSet));
	}

	@Transactional
	public <T> Optional<T> get(final Function<Connection, PreparedStatement> prepareStatementProvider,
			final Function<ResultSet, T> resultExtractor) {
		final List<T> results = new ArrayList<>();
		Session session = entityManager.unwrap(Session.class);
		session.doWork(connection -> {
			try (ResultSet res = prepareStatementProvider.apply(connection).executeQuery()) {
				results.add(resultExtractor.apply(res));
			} catch (SQLException e) {
				throw new RuntimeException("Problem in execution of query", e);
			}
		});

		return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
	}

	@Transactional
	public void put(final Function<Connection, PreparedStatement> prepareStatementProvider) {
		Session session = entityManager.unwrap(Session.class);
		session.doWork(connection -> {
			try {
				prepareStatementProvider.apply(connection).execute();
			} catch (SQLException e) {
				throw new RuntimeException("Problem in execution of query", e);
			}
		});
	}

}
