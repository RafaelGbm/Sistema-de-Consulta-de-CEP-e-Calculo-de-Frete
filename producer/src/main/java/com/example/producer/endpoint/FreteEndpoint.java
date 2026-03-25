
package com.example.producer.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.producer.model.CalcularFreteRequest;
import com.example.producer.model.CalcularFreteResponse;

import java.math.BigDecimal;

@Endpoint
public class FreteEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/soap/frete";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "calcularFreteRequest")
    @ResponsePayload
    public CalcularFreteResponse calcularFrete(@RequestPayload CalcularFreteRequest request) {
        // Exemplo de cálculo de frete e validação
        CalcularFreteResponse response = new CalcularFreteResponse();
        String cepOrigem = request.getCepOrigem();
        String cepDestino = request.getCepDestino();
        BigDecimal peso = request.getPeso();
        if (cepOrigem == null || !cepOrigem.matches("\\d{8}") ||
            cepDestino == null || !cepDestino.matches("\\d{8}") ||
            peso == null || peso.compareTo(BigDecimal.ZERO) <= 0) {
            throw new SoapValidationException("Dados inválidos para cálculo de frete");
        }
        response.setValor(peso.multiply(new BigDecimal("10.00")));
        response.setPrazo(7);
        return response;
    }
}
