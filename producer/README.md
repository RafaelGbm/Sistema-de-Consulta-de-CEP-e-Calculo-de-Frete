# Producer (SOAP Service)

Este projeto é um serviço SOAP usando Spring Boot e Spring-WS.

## Funcionalidades
- consultarEndereco(cep): retorna logradouro, bairro, cidade, UF
- calcularFrete(cepOrigem, cepDestino, peso): retorna valor e prazo estimado

## Boas práticas
- Contract-first (XSD → WSDL → Java)
- Validação de schema XML
- Tratamento de SoapFault para erros
- Logs de requisição/resposta com interceptors

## Como rodar
1. `mvn clean install`
2. `mvn spring-boot:run`
