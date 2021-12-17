package com.high.mvc2.converter.config;

import com.high.mvc2.converter.IntegerToStringConverter;
import com.high.mvc2.converter.IpPortToStringConverter;
import com.high.mvc2.converter.StringToIntegerConverter;
import com.high.mvc2.converter.StringToIpPortConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());
        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new IntegerToStringConverter());
    }
}
