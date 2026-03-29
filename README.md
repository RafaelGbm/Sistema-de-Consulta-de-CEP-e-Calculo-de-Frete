# Sistema de Consulta de CEP e Cálculo de Frete

Este repositório contém dois projetos Spring Boot:

- **Producer**: Serviço SOAP que fornece consulta de endereço por CEP e cálculo de frete.
- **Consumer**: Cliente SOAP que consome os serviços do Producer.

## Como rodar

### 1. Producer (serviço SOAP)

```bash
cd producer
mvn clean install
mvn spring-boot:run
```

O serviço ficará disponível em http://localhost:8080/ws

### 2. Consumer (cliente SOAP)

```bash
cd consumer
mvn clean install
mvn spring-boot:run
```

O Consumer executa exemplos de consulta de endereço e cálculo de frete ao iniciar.

## Funcionalidades

- Consulta de endereço por CEP
- Cálculo de frete entre dois CEPs

## Requisitos

- Java 11+
- Maven 3.6+
