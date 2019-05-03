package com.labX.fram.common.service;

import java.sql.ResultSet;
import java.util.Optional;
import java.util.function.Function;

import javax.json.JsonArray;

import com.labX.fram.service.SQLQuery;
import com.labX.fram.service.Service;

public interface ExecutorService extends Service {
	<R> Optional<R> execute(final SQLQuery query, final Function<ResultSet, R> resultExtractor);

	Optional<JsonArray> execute(final SQLQuery query);
}
