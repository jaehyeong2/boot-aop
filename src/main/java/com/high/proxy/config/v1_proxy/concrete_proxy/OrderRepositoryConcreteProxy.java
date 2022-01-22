package com.high.proxy.config.v1_proxy.concrete_proxy;

import com.high.proxy.app.v2.OrderRepositoryV2;
import com.high.trace.TraceStatus;
import com.high.trace.logtrace.LogTrace;

public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final LogTrace logTrace;

    public OrderRepositoryConcreteProxy(OrderRepositoryV2 target, LogTrace logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderRepository.request()");
            //타겟 호출
            target.save(itemId);
            logTrace.end(status);

        } catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }
}
