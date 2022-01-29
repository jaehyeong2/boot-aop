package com.high.proxy.config.v5_autoproxy;


import com.high.proxy.config.AppV1Config;
import com.high.proxy.config.AppV2Config;
import com.high.proxy.config.v3_proxyfactory.advice.LogTraceAdvice;
import com.high.trace.logtrace.LogTrace;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AutoProxyConfg {

//    @Bean
    public Advisor advisor1(LogTrace logTrace) {
        //포인트컷
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*","order*","save*");
        //어드바이스
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut,advice);
    }

//    @Bean
    public Advisor advisor2(LogTrace logTrace) {
        //포인트컷
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.high.app..*(..))");
        //어드바이스
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut,advice);
    }
    
}
