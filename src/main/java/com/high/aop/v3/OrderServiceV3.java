//package com.high.aop.v3;
//
//import com.high.trace.TraceId;
//import com.high.trace.TraceStatus;
//import com.high.trace.hellotrace.HelloTraceV2;
//import com.high.trace.logtrace.LogTrace;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class OrderServiceV3 {
//
//    private final OrderRepositoryV3 orderRepository;
//    private final LogTrace trace;
//
//    public void orderItem(String itemId){
//
//        TraceStatus status = null;
//        try{
//            status = trace.begin("OrderService.request()");
//            orderRepository.save(itemId);
//            trace.end(status);
//        } catch (Exception e){
//            trace.exception(status,e);
//            throw e;
//        }
//
//    }
//}
