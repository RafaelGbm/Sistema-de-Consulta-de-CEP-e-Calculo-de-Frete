package com.example.producer.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WebServiceConfig {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "endereco")
    public DefaultWsdl11Definition enderecoWsdl(XsdSchema enderecoSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("EnderecoPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://example.com/soap/endereco");
        wsdl11Definition.setSchema(enderecoSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema enderecoSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/endereco.xsd"));
    }

    @Bean(name = "frete")
    public DefaultWsdl11Definition freteWsdl(XsdSchema freteSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("FretePort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://example.com/soap/frete");
        wsdl11Definition.setSchema(freteSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema freteSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/frete.xsd"));
    }
}
