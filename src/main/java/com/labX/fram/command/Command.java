package com.labX.fram.command;

import com.labX.fram.request.Request;
import com.labX.fram.response.Dataset;

import java.util.function.Function;

public interface Command<I extends Request, O extends Dataset<?>> extends Function<I,O> {
}
