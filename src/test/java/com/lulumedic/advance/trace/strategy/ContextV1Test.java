package com.lulumedic.advance.trace.strategy;

import com.lulumedic.advance.trace.strategy.code.strategy.ContextV1;
import com.lulumedic.advance.trace.strategy.code.strategy.Strategy;
import com.lulumedic.advance.trace.strategy.code.strategy.StrategyLogic1;
import com.lulumedic.advance.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비지니스 로직 실행
        log.info("비지니스 로직1 실행");
        // 비지니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("resultTime = {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비지니스 로직 실행
        log.info("비지니스 로직1 실행");
        // 비지니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("resultTime = {}", resultTime);
    }

    /**
     * 전략 패턴 사용
     */
    @Test
    void strategyV1Test() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
    }

    @Test
    void strategyV2Test() {
        Strategy logic1 = new Strategy() {

            @Override
            public void call() {
                log.info("비지니스 로직 1 실행");
            }
        };

        ContextV1 contextV1 = new ContextV1(logic1);
        contextV1.execute();
        log.info("logic1 class = {}", logic1.getClass());

        Strategy logic2 = new Strategy() {

            @Override
            public void call() {
                log.info("비지니스 로직 2 실행");
            }
        };

        ContextV1 contextV2 = new ContextV1(logic2);
        contextV2.execute();
        log.info("logic2 class = {}", logic2.getClass());
    }

    @Test
    void strategyV3Test() {
        ContextV1 contextV1 = new ContextV1(new Strategy() {

            @Override
            public void call() {
                log.info("비지니스 로직 1 실행");
            }
        });
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(new Strategy() {

            @Override
            public void call() {
                log.info("비지니스 로직 2 실행");
            }
        });
        contextV2.execute();

    }

    @Test
    void strategyV4Test() {
        ContextV1 contextV1 = new ContextV1(() -> log.info("비지니스 로직 1 실행"));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(() -> log.info("비지니스 로직 2 실행"));
        contextV2.execute();
    }

}
