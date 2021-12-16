package com.high.aop.v4;

import com.high.trace.TraceStatus;
import com.high.trace.logtrace.LogTrace;
import com.high.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId){

            AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
                @Override
                protected Void call() {
                    orderRepository.save(itemId);
                    return null;
                }
            };
            template.execute("OrderService.orderItem()");
    }
}

