package com.lulumedic.advance.trace.strategy;

import com.lulumedic.advance.trace.strategy.code.strategy.ContextV2;
import com.lulumedic.advance.trace.strategy.code.strategy.Strategy;
import com.lulumedic.advance.trace.strategy.code.strategy.StrategyLogic1;
import com.lulumedic.advance.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV2Test() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }

    @Test
    void strategyV2Test2() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new Strategy() {

            @Override
            public void call() {
                log.info("비지니스 로직 1 실행");
            }
        });

        contextV2.execute(new Strategy() {

            @Override
            public void call() {
                log.info("비지니스 로직 1 실행");
            }
        });
    }

    @Test
    void strategyV2Test3() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(() -> log.info("비지니스 로직 1 실행"));
        contextV2.execute(() -> log.info("비지니스 로직 1 실행"));
    }

}
