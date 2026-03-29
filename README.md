## Nomes e RM’S

Vinicius Monteiro Araújo - 55508<br>
Guilherme Almeida - 555180<br>
Rafael Duarte de Freitas - 558644<br>
Rafael Gaspar Bragança Martins - 557228<br>
Luiz Gustavo da Silva - 558358<br>

# Sistema de Consulta de CEP e Cálculo de Frete

Sistema de Web Services **SOAP** construído com **Spring Boot**, seguindo a arquitetura **Producer/Consumer**. O projeto demonstra como criar e consumir serviços SOAP, utilizando contratos XSD, geração automática de classes via JAXB e validação de mensagens XML.

---

## Arquitetura

```
Consumer (porta 8081)          Producer (porta 9090)
        |                               |
        |------- SOAP over HTTP ------->|
        |     (XML serializado via      |
        |          JAXB)                |
        |<------ Resposta XML ----------|
```

O **Producer** é o servidor SOAP — expõe dois serviços no endpoint `/ws`. O **Consumer** é o cliente — ao iniciar, chama o Producer automaticamente e imprime os resultados no console.

---

## Funcionalidades

### Consulta de Endereço por CEP

- **Entrada:** CEP (8 dígitos)
- **Saída:** logradouro, bairro, cidade e UF
- **Validação:** formato obrigatório de 8 dígitos numéricos

### Cálculo de Frete

- **Entrada:** CEP de origem, CEP de destino e peso (em kg)
- **Saída:** valor do frete (peso × R$ 10,00) e prazo (7 dias fixos)
- **Validação:** CEPs com 8 dígitos e peso maior que zero

Erros de validação retornam um **SOAP Fault** ao cliente, seguindo o padrão do protocolo.

---

## Tecnologias

- Java 11+
- Spring Boot 2.7
- Spring Web Services (SOAP)
- JAXB2 — geração automática de classes Java a partir dos esquemas XSD
- WSDL — contrato do serviço gerado automaticamente pelo Spring
- Maven 3.6+

---

## Como rodar

### 1. Producer (servidor SOAP)

```bash
cd producer
mvn clean install
mvn spring-boot:run
```

Serviço disponível em: `http://localhost:9090/ws`

WSDLs disponíveis em:

- `http://localhost:9090/ws/endereco.wsdl`
- `http://localhost:9090/ws/frete.wsdl`

### 2. Consumer (cliente SOAP)

```bash
cd consumer
mvn clean install
mvn spring-boot:run
```

Ao iniciar, o Consumer executa automaticamente dois exemplos:

1. Consulta o endereço do CEP `01001000`
2. Calcula o frete de `01001000` (SP) para `20040010` (RJ) com 2,5 kg

Os resultados são impressos no console.

---

## Estrutura do Projeto

```
├── producer/
│   ├── src/main/java/com/example/producer/
│   │   ├── endpoint/          # EnderecoEndpoint, FreteEndpoint
│   │   └── config/            # WebServiceConfig, SoapLoggingConfig
│   └── src/main/resources/
│       └── xsd/               # endereco.xsd, frete.xsd (contratos)
│
└── consumer/
    ├── src/main/java/com/example/consumer/
    │   ├── SoapClient.java    # Lógica de chamada SOAP
    │   ├── ConsumerRunner.java # Executa os exemplos ao iniciar
    │   └── config/            # SoapClientConfig
    └── src/main/resources/
        └── xsd/               # Mesmos XSDs do producer
```

---

Para dúvidas ou sugestões, abra uma issue.
