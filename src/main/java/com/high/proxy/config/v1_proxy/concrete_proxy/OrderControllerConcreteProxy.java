package com.high.proxy.config.v1_proxy.concrete_proxy;
import com.high.aop.v2.OrderServiceV2;
import com.high.proxy.app.v2.OrderControllerV2;
import com.high.trace.TraceStatus;
import com.high.trace.hellotrace.HelloTraceV2;
import com.high.trace.logtrace.LogTrace;

public class OrderControllerConcreteProxy extends OrderControllerV2 {

    private final OrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(OrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderController.request()");
            //타겟 호출
            String result = target.request(itemId);
            logTrace.end(status);
            return result;

        } catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
