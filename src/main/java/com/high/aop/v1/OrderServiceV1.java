package com.high.aop.v1;

import com.high.trace.TraceStatus;
import com.high.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 trace;


    public void orderItem(String itemId){

        TraceStatus status = null;
        try{
            status = trace.begin("OrderService.request()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e){
            trace.exception(status,e);
            throw e;
        }

    }
}
