package com.labX.fram.service;

import com.labX.fram.response.Dataset;

public interface DataServiceFactory {
    public <Q extends Query, D extends Dataset<?>> DataService<Q, D> resolve(final String name);
}
