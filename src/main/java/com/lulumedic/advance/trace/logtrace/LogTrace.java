package com.lulumedic.advance.trace.logtrace;

import com.lulumedic.advance.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
