package com.high.trace.logtrace;

import com.high.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status,Exception e);
}
