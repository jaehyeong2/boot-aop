package com.high.aop.v2;

import com.high.trace.TraceId;
import com.high.trace.TraceStatus;
import com.high.trace.hellotrace.HelloTraceV1;
import com.high.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(TraceId traceId, String itemId){

        TraceStatus status = null;
        try{
            status = trace.beginSync(traceId,"OrderRepository.request()");

            // 로직
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외발생!");
            }
            sleep(1000);

            trace.end(status);
        } catch (Exception e){
            trace.exception(status,e);
            throw e;
        }
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
