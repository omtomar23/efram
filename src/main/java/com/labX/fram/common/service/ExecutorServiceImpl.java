package com.labX.fram.common.service;

import java.sql.ResultSet;
import java.util.Optional;
import java.util.function.Function;

import javax.json.JsonArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labX.fram.datasource.JDBCDataSource;
import com.labX.fram.service.SQLQuery;

@Component("executorService")
public class ExecutorServiceImpl implements ExecutorService {

	@Autowired
	private JDBCDataSource dataSource;

	@Override
	public <R> Optional<R> execute(final SQLQuery query, final Function<ResultSet, R> resultExtractor) {
		return dataSource.get(query, resultExtractor);
	}

	@Override
	public Optional<JsonArray> execute(final SQLQuery query) {
		return dataSource.get(query);
	}

}
