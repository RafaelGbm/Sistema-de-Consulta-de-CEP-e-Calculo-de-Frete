# Consumer (SOAP Client)

Este projeto consome o serviço SOAP exposto pelo Producer usando Spring Boot.

## Funcionalidades
- Consulta de endereço por CEP
- Cálculo de frete

## Boas práticas
- Geração de código a partir do WSDL
- Tratamento de SoapFault para erros
- Logs de requisição/resposta

## Como rodar
1. `mvn clean install`
2. `mvn spring-boot:run`
