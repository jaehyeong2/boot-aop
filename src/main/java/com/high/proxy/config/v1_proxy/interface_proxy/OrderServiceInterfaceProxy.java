package com.high.proxy.config.v1_proxy.interface_proxy;

import com.high.proxy.app.v1.OrderServiceV1;
import com.high.trace.TraceStatus;
import com.high.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderServiceV1 {

    private final OrderServiceV1 target;
    private final LogTrace logTrace;

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
