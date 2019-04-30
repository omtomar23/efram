package com.labX.fram.command;

import com.labX.fram.request.Request;
import com.labX.fram.response.Dataset;
import org.springframework.stereotype.Component;

@Component
public interface CommandFactory {
    <I extends Request, O extends Dataset<?>, C extends Command<I,O>> C resolve(final String name);
}
