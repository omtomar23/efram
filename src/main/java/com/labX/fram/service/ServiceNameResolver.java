package com.labX.fram.service;

public class ServiceNameResolver {

    private static final String SERVICE_SUFFIX = "Service";

    private ServiceNameResolver(){}

    public static String resolve(final String name){
        return name + SERVICE_SUFFIX;
    }
}
