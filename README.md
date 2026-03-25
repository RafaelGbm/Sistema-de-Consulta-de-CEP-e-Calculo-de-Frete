# Sistema de Consulta de CEP e Cálculo de Frete

Este repositório contém dois projetos Spring Boot integrados via SOAP:
- **Producer:** Serviço SOAP para consulta de endereço e cálculo de frete.
- **Consumer:** Cliente SOAP que consome os serviços do producer.

## Como funciona
- O **producer** expõe dois métodos principais:
  - `consultarEndereco(cep)`: retorna logradouro, bairro, cidade e UF.
  - `calcularFrete(cepOrigem, cepDestino, peso)`: retorna valor e prazo estimado do frete.
- O **consumer** faz chamadas SOAP para o producer e exibe os resultados no console.
- O contrato é definido por arquivos XSD, garantindo validação dos dados.

## Como executar
1. Abra dois terminais.
2. No primeiro terminal, acesse a pasta `producer` e execute:
   - `mvn clean install`
   - `mvn spring-boot:run`
3. No segundo terminal, acesse a pasta `consumer` e execute:
   - `mvn clean install`
   - `mvn spring-boot:run`
4. O consumer irá consultar o serviço producer e mostrar os resultados no console.

## Possibilidades para futuras features
- Integração do producer com bancos de dados reais.
- Cálculo de frete com regras dinâmicas e integração com APIs externas.
- Autenticação/autorização de requisições.
- Dashboard para monitoramento de requisições.
- Documentação automática do WSDL.

---
Projeto simples, modular e pronto para expansão conforme novas necessidades.
