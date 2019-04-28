package com.labX.fram.service;

import com.labX.fram.response.Dataset;

import java.util.function.Function;

public interface DataService<Q extends Query, D extends Dataset<?>> extends Function<Q,D> {
}
