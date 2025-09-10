package com.lulumedic.advance.app.v5;

import com.lulumedic.advance.trace.callback.TraceCallback;
import com.lulumedic.advance.trace.callback.TraceTemplate;
import com.lulumedic.advance.trace.logtrace.LogTrace;
import com.lulumedic.advance.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace logTrace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(logTrace);
    }

    public void orderItem(String itemId) {
        template.execute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }

}
