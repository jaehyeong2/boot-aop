package com.high;

import com.high.proxy.config.AppV1Config;
import com.high.proxy.config.AppV2Config;
import com.high.proxy.config.AppV3Config;
import com.high.proxy.config.v1_proxy.ConcreteProxyConfig;
import com.high.proxy.config.v1_proxy.InterfaceProxyConfig;
import com.high.proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import com.high.proxy.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import com.high.proxy.config.v3_proxyfactory.ProxyFactoryConfigV1;
import com.high.proxy.config.v3_proxyfactory.ProxyFactoryConfigV2;
import com.high.proxy.config.v4_postprocessor.BeanPostProcessorConfig;
import com.high.proxy.config.v5_autoproxy.AutoProxyConfg;
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
//@Import(DynamicProxyFilterConfig.class)
//@Import(ProxyFactoryConfigV1.class)
//@Import(ProxyFactoryConfigV2.class)
//@Import(BeanPostProcessorConfig.class)
@Import(AutoProxyConfg.class)
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
