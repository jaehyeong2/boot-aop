package com.high.proxy.config.v1_proxy.interface_proxy;

import com.high.proxy.app.v1.OrderRepositoryV1;
import com.high.trace.TraceStatus;
import com.high.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;

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
