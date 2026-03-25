package com.example.consumer;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.consumer.model.endereco.ConsultarEnderecoResponse;
import com.example.consumer.model.frete.CalcularFreteResponse;

@Component
public class ConsumerRunner implements CommandLineRunner {

    private final SoapClient soapClient;

    public ConsumerRunner(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @Override
    public void run(String... args) {
        String cep = "01001000";
        System.out.println("=== Consultando endereco para CEP: " + cep + " ===");
        ConsultarEnderecoResponse enderecoResponse = soapClient.consultarEndereco(cep);
        System.out.println("Logradouro: " + enderecoResponse.getLogradouro());
        System.out.println("Bairro: " + enderecoResponse.getBairro());
        System.out.println("Cidade: " + enderecoResponse.getCidade());
        System.out.println("UF: " + enderecoResponse.getUf());

        String cepOrigem = "01001000";
        String cepDestino = "20040010";
        BigDecimal peso = new BigDecimal("2.5");
        System.out.println("\n=== Calculando frete ===");
        System.out.println("Origem: " + cepOrigem + " | Destino: " + cepDestino + " | Peso: " + peso + "kg");
        CalcularFreteResponse freteResponse = soapClient.calcularFrete(cepOrigem, cepDestino, peso);
        System.out.println("Valor: R$ " + freteResponse.getValor());
        System.out.println("Prazo: " + freteResponse.getPrazo() + " dias");
    }
}
