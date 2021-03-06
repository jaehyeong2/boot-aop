package com.high.proxy.config.v2_dynamicproxy;

import com.high.proxy.app.v1.*;
import com.high.proxy.config.v2_dynamicproxy.handler.LogTraceBasicHandler;
import com.high.proxy.config.v2_dynamicproxy.handler.LogTraceFilterHandler;
import com.high.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyFilterConfig {

    private static final String[] PATTERNS = {"request","order*","save*"};

    @Bean
    public OrderControllerV1 orderControllerV1(LogTrace trace){
        OrderControllerV1 orderControllerV1 = new OrderControllerV1Impl(orderServiceV1(trace));
        OrderControllerV1 proxy = (OrderControllerV1) Proxy.newProxyInstance(orderControllerV1.getClass().getClassLoader(),
                new Class[]{OrderControllerV1.class},
                new LogTraceFilterHandler(orderControllerV1, trace, PATTERNS));

        return proxy;
    }

    @Bean
    public OrderServiceV1 orderServiceV1(LogTrace trace){
        OrderServiceV1 orderServiceV1 = new OrderServiceV1Impl(orderRepositoryV1(trace));
        OrderServiceV1 proxy = (OrderServiceV1) Proxy.newProxyInstance(orderServiceV1.getClass().getClassLoader(),
                new Class[]{OrderServiceV1.class},
                new LogTraceFilterHandler(orderServiceV1, trace, PATTERNS));

        return proxy;
    }

    @Bean
    public OrderRepositoryV1 orderRepositoryV1(LogTrace trace){
        OrderRepositoryV1 orderRepositoryV1 = new OrderRepositoryV1Impl();

        OrderRepositoryV1 proxy = (OrderRepositoryV1)Proxy.newProxyInstance(OrderRepositoryV1.class.getClassLoader(),
                new Class[]{OrderRepositoryV1.class},
                new LogTraceFilterHandler(orderRepositoryV1, trace, PATTERNS));

        return proxy;
    }
}
