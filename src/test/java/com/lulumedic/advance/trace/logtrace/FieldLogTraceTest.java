package com.lulumedic.advance.trace.logtrace;

import com.lulumedic.advance.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldLogTraceTest {

    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus begin1 = trace.begin("begin1");
        TraceStatus begin2 = trace.begin("begin2");
        trace.end(begin2);
        trace.end(begin1);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus begin1 = trace.begin("begin1");
        TraceStatus begin2 = trace.begin("begin2");
        trace.exception(begin2, new IllegalStateException());
        trace.exception(begin1, new IllegalStateException());

    }

}