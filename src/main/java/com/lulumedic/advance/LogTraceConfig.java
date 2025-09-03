package com.lulumedic.advance;

import com.lulumedic.advance.trace.logtrace.FieldLogTrace;
import com.lulumedic.advance.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }
}
