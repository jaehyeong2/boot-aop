package com.high.proxy.proxyfactory;

import com.high.proxy.common.advice.TimeAdvice;
import com.high.proxy.common.service.ConcreteService;
import com.high.proxy.common.service.ServiceImpl;
import com.high.proxy.common.service.ServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

@Slf4j
public class ProxyFactoryTest {

    @Test
    @DisplayName("인터페이스가 있으면 jdk 동적 프록시 사용")
    void interfaceProxy(){
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("targetClass = {}",target.getClass());
        log.info("proxyClass = {}",proxy.getClass());

        proxy.save();
    }

    @Test
    @DisplayName("구체 클래스만 있으면 cglib 사용")
    void concreteProxy(){
        ConcreteService target = new ConcreteService();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();
        log.info("targetClass = {}",target.getClass());
        log.info("proxyClass = {}",proxy.getClass());

        proxy.call();
    }

    @Test
    @DisplayName("proxyTargetClass 옵션을 사용하면 인터페이스 있어도 cglib 사용, 클래스 기반 프록시 사용")
    void proxyTargetProxy(){
        ServiceInterface target = new ServiceImpl();

        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAdvice(new TimeAdvice());

        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("targetClass = {}",target.getClass());
        log.info("proxyClass = {}",proxy.getClass());

        proxy.save();
    }
}
