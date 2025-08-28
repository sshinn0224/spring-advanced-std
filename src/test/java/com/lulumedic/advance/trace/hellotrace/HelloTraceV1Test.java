package com.lulumedic.advance.trace.hellotrace;

import com.lulumedic.advance.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV1Test {

    @Test
    void begin_end() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello trace");

        trace.end(status);

    }

    @Test
    void begin_exception() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello trace");
        trace.exception(status, new IllegalStateException("hello trace exception"));
    }

}