package com.labX.fram.service;

public interface ServiceFactory {
    <S extends Service> S resolve(final String name);
}
