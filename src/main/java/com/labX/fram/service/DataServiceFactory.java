package com.labX.fram.service;

import com.labX.fram.response.Dataset;

public interface DataServiceFactory {
    public <Q extends Query, D extends Dataset<?>, S extends DataService<Q, D>> S resolve(final String name);
}
