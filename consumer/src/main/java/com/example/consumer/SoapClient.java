package com.example.consumer;

import com.example.consumer.wsdl.EnderecoPortService;
import com.example.consumer.wsdl.EnderecoPort;
import com.example.consumer.wsdl.FretePortService;
import com.example.consumer.wsdl.FretePort;
import com.example.consumer.wsdl.ConsultaEnderecoRequest;
import com.example.consumer.wsdl.ConsultaEnderecoResponse;
import com.example.consumer.wsdl.CalculaFreteRequest;
import com.example.consumer.wsdl.CalculaFreteResponse;

public class SoapClient {
    private final EnderecoPort enderecoPort;
    private final FretePort fretePort;

    public SoapClient() {
        this.enderecoPort = new EnderecoPortService().getEnderecoPortSoap11();
        this.fretePort = new FretePortService().getFretePortSoap11();
    }

    public ConsultaEnderecoResponse consultarEndereco(String cep) {
        ConsultaEnderecoRequest request = new ConsultaEnderecoRequest();
        request.setCep(cep);
        return enderecoPort.consultaEndereco(request);
    }

    public CalculaFreteResponse calcularFrete(String cepOrigem, String cepDestino, double peso) {
        CalculaFreteRequest request = new CalculaFreteRequest();
        request.setCepOrigem(cepOrigem);
        request.setCepDestino(cepDestino);
        request.setPeso(peso);
        return fretePort.calculaFrete(request);
    }
}
