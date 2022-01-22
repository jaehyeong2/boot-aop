package com.high.proxy.config.v1_proxy.concrete_proxy;

import com.high.proxy.app.v2.OrderRepositoryV2;
import com.high.proxy.app.v2.OrderServiceV2;
import com.high.trace.TraceStatus;
import com.high.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderService.orderItem()");
            //타겟 호출
            target.orderItem(itemId);
            logTrace.end(status);

        } catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }
}
