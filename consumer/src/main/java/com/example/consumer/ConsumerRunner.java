package com.example.consumer;

import com.example.consumer.SoapClient;
import com.example.consumer.wsdl.ConsultaEnderecoResponse;
import com.example.consumer.wsdl.CalculaFreteResponse;

public class ConsumerRunner {
    public static void main(String[] args) {
        SoapClient client = new SoapClient();

        // Exemplo de consulta de endereço
        String cep = "01001-000";
        ConsultaEnderecoResponse enderecoResponse = client.consultarEndereco(cep);
        System.out.println("Endereço para CEP " + cep + ": " + enderecoResponse.getLogradouro() + ", " + enderecoResponse.getBairro() + ", " + enderecoResponse.getCidade() + " - " + enderecoResponse.getUf());

        // Exemplo de cálculo de frete
        String cepOrigem = "01001-000";
        String cepDestino = "20040-010";
        double peso = 2.5;
        CalculaFreteResponse freteResponse = client.calcularFrete(cepOrigem, cepDestino, peso);
        System.out.println("Frete de " + cepOrigem + " para " + cepDestino + " (" + peso + "kg): R$ " + freteResponse.getValor() + ", prazo: " + freteResponse.getPrazoEntrega() + " dias");
    }
}
