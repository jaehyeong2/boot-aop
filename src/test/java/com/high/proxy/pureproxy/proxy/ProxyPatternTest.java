package com.high.proxy.pureproxy.proxy;

import com.high.proxy.pureproxy.proxy.code.CacheProxy;
import com.high.proxy.pureproxy.proxy.code.ProxyPatternClient;
import com.high.proxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void proxyTest() {
        RealSubject realSubject = new RealSubject();
        CacheProxy proxy = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(proxy);
        client.execute();
        client.execute();
        client.execute();
    }
}
