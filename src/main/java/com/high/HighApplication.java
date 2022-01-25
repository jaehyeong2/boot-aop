package com.high;

import com.high.proxy.config.AppV1Config;
import com.high.proxy.config.AppV2Config;
import com.high.proxy.config.AppV3Config;
import com.high.proxy.config.v1_proxy.ConcreteProxyConfig;
import com.high.proxy.config.v1_proxy.InterfaceProxyConfig;
import com.high.proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import com.high.proxy.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import com.high.trace.logtrace.LogTrace;
import com.high.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;


//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
@Import(DynamicProxyFilterConfig.class)
@SpringBootApplication(scanBasePackages = "com.high.aop")
public class HighApplication {

	public static void main(String[] args) {
		SpringApplication.run(HighApplication.class, args);
	}

	@Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

}
