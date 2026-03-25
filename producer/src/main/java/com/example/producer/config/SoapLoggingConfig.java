package com.example.producer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.interceptor.PayloadLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

import java.util.List;

@Configuration
public class SoapLoggingConfig extends WsConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(SoapLoggingConfig.class);

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(payloadLoggingInterceptor());
    }

    @Bean
    public PayloadLoggingInterceptor payloadLoggingInterceptor() {
        return new PayloadLoggingInterceptor();
    }
}
