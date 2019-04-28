package com.labX.fram.service;

public class DataServiceNameResolver {

    private static final String DATA_SERVICE_SUFFIX = "DataService";

    private DataServiceNameResolver(){}

    public static String resolve(final String name){
        return name + DATA_SERVICE_SUFFIX;
    }
}
