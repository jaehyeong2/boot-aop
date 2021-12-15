package com.high.aop.v2;

import com.high.aop.v1.OrderRepositoryV1;
import com.high.trace.TraceId;
import com.high.trace.TraceStatus;
import com.high.trace.hellotrace.HelloTraceV1;
import com.high.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId){

        TraceStatus status = null;
        try{
            status = trace.beginSync(traceId,"OrderService.request()");
            orderRepository.save(status.getTraceId(),itemId);
            trace.end(status);
        } catch (Exception e){
            trace.exception(status,e);
            throw e;
        }

    }
}
