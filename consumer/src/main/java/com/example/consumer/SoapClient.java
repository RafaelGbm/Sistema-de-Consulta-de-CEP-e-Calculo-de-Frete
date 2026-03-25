package com.example.consumer;

import com.example.consumer.model.endereco.ConsultarEnderecoRequest;
import com.example.consumer.model.endereco.ConsultarEnderecoResponse;
import com.example.consumer.model.frete.CalcularFreteRequest;
import com.example.consumer.model.frete.CalcularFreteResponse;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigDecimal;

public class SoapClient {

    private final WebServiceTemplate enderecoTemplate;
    private final WebServiceTemplate freteTemplate;

    public SoapClient(WebServiceTemplate enderecoTemplate, WebServiceTemplate freteTemplate) {
        this.enderecoTemplate = enderecoTemplate;
        this.freteTemplate = freteTemplate;
    }

    public ConsultarEnderecoResponse consultarEndereco(String cep) {
        ConsultarEnderecoRequest request = new ConsultarEnderecoRequest();
        request.setCep(cep);
        return (ConsultarEnderecoResponse) enderecoTemplate.marshalSendAndReceive(request);
    }

    public CalcularFreteResponse calcularFrete(String cepOrigem, String cepDestino, BigDecimal peso) {
        CalcularFreteRequest request = new CalcularFreteRequest();
        request.setCepOrigem(cepOrigem);
        request.setCepDestino(cepDestino);
        request.setPeso(peso);
        return (CalcularFreteResponse) freteTemplate.marshalSendAndReceive(request);
    }
}
