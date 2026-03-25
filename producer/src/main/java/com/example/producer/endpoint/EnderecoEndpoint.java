
package com.example.producer.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.producer.model.ConsultarEnderecoRequest;
import com.example.producer.model.ConsultarEnderecoResponse;

@Endpoint
public class EnderecoEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/soap/endereco";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "consultarEnderecoRequest")
    @ResponsePayload
    public ConsultarEnderecoResponse consultarEndereco(@RequestPayload ConsultarEnderecoRequest request) {
        // Exemplo de validação de CEP e resposta
        ConsultarEnderecoResponse response = new ConsultarEnderecoResponse();
        String cep = request.getCep();
        if (cep == null || !cep.matches("\\d{8}")) {
            throw new SoapValidationException("CEP inválido");
        }
        response.setLogradouro("Rua Exemplo " + cep);
        response.setBairro("Centro");
        response.setCidade("Cidade Exemplo");
        response.setUf("SP");
        return response;
    }
}
