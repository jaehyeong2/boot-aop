package com.high.proxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteLogic {

    public String operation(){
        log.info("concrete 로짃실행");
        return "data";
    }
}
