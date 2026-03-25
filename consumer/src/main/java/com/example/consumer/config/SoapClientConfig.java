package com.example.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.example.consumer.SoapClient;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller enderecoMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.consumer.model.endereco");
        return marshaller;
    }

    @Bean
    public Jaxb2Marshaller freteMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.consumer.model.frete");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate enderecoTemplate(Jaxb2Marshaller enderecoMarshaller) {
        WebServiceTemplate template = new WebServiceTemplate();
        template.setMarshaller(enderecoMarshaller);
        template.setUnmarshaller(enderecoMarshaller);
        template.setDefaultUri("http://localhost:9090/ws");
        return template;
    }

    @Bean
    public WebServiceTemplate freteTemplate(Jaxb2Marshaller freteMarshaller) {
        WebServiceTemplate template = new WebServiceTemplate();
        template.setMarshaller(freteMarshaller);
        template.setUnmarshaller(freteMarshaller);
        template.setDefaultUri("http://localhost:9090/ws");
        return template;
    }

    @Bean
    public SoapClient soapClient(WebServiceTemplate enderecoTemplate, WebServiceTemplate freteTemplate) {
        return new SoapClient(enderecoTemplate, freteTemplate);
    }
}
