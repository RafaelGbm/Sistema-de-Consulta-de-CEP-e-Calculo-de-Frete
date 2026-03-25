package com.example.producer.endpoint;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
public class SoapValidationException extends RuntimeException {
    public SoapValidationException(String message) {
        super(message);
    }
}
