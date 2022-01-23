//package com.high.aop.v1;
//
//import com.high.trace.TraceStatus;
//import com.high.trace.hellotrace.HelloTraceV1;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//@RequiredArgsConstructor
//@Repository
//public class OrderRepositoryV1 {
//
//    private final HelloTraceV1 trace;
//
//    public void save(String itemId){
//
//        TraceStatus status = null;
//        try{
//            status = trace.begin("OrderRepository.request()");
//
//            // 로직
//            if(itemId.equals("ex")){
//                throw new IllegalStateException("예외발생!");
//            }
//            sleep(1000);
//
//            trace.end(status);
//        } catch (Exception e){
//            trace.exception(status,e);
//            throw e;
//        }
//    }
//
//    private void sleep(int millis) {
//        try{
//            Thread.sleep(millis);
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
//
//
//}
