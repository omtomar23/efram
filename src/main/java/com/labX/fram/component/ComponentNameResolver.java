package com.labX.fram.component;

public class ComponentNameResolver {
    private static final String COMMAND_SUFFIX = "Component";

    public static String resolve(final String name){
        return name + COMMAND_SUFFIX;
    }
}
