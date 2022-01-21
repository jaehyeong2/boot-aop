package com.high.proxy.pureproxy.decorator;

import com.high.proxy.pureproxy.decorator.code.*;
import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

    @Test
    public void noDecorator(){
        RealComponent component = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(component);
        client.execute();
    }

    @Test
    public void Decorator1(){
        RealComponent component = new RealComponent();
        Component decorator = new MessageDecorator(component);
        DecoratorPatternClient client = new DecoratorPatternClient(decorator);
        client.execute();
    }

    @Test
    public void Decorator2(){
        RealComponent component = new RealComponent();
        Component messageDecorator = new MessageDecorator(component);
        Component timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
        client.execute();
    }
}
