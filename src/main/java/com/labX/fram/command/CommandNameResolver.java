package com.labX.fram.command;

public class CommandNameResolver {
    private static final String COMMAND_SUFFIX = "Command";

    public static String resolve(final String name){
        return name + COMMAND_SUFFIX;
    }
}
