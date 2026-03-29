# Roteiro — Sistema de Consulta de CEP e Cálculo de Frete (5 min)

---

## INTRO — 0:00 a 0:30
**[Tela: slide ou IDE aberta no projeto]**

> "Olá! Hoje vou apresentar um projeto que desenvolvi usando **Web Services SOAP** com **Spring Boot**. O sistema tem dois serviços: um de **consulta de endereço por CEP** e outro de **cálculo de frete**. A arquitetura segue o modelo **Producer/Consumer** — vou explicar o que isso significa e mostrar o código funcionando."

---

## PARTE 1 — O que é SOAP e a arquitetura do projeto — 0:30 a 1:30
**[Tela: diagrama ou estrutura de pastas]**

> "SOAP é um protocolo de comunicação baseado em XML. Diferente de REST, ele usa um contrato bem definido chamado **WSDL** que descreve exatamente quais operações o serviço oferece e quais dados aceita."

> "O projeto tem duas aplicações Spring Boot independentes:
> - O **Producer** é o servidor SOAP — ele roda na porta 9090 e expõe os serviços.
> - O **Consumer** é o cliente — ele chama o Producer para usar esses serviços."

> "A comunicação acontece assim: o Consumer cria um objeto Java, o Spring serializa para XML via **JAXB**, envia via HTTP para o Producer, que processa e devolve a resposta em XML, que o Consumer desserializa de volta para objeto Java."

---

## PARTE 2 — O Producer: definindo o contrato com XSD — 1:30 a 2:30
**[Tela: arquivos `endereco.xsd` e `frete.xsd`]**

> "Tudo começa nos **esquemas XSD** — eles são o contrato do serviço. Aqui defino o que o serviço de endereço aceita e retorna, e o mesmo para frete."

> "O Maven usa esses XSDs para **gerar automaticamente as classes Java** via plugin JAXB2 — então não preciso escrever os modelos na mão."

**[Tela: `EnderecoEndpoint.java` e `FreteEndpoint.java`]**

> "Os Endpoints são o coração do Producer. Esse aqui recebe um CEP de 8 dígitos, valida o formato com regex, e retorna o endereço. Esse outro calcula o frete: recebe CEP de origem, destino e peso — e retorna o valor (peso vezes 10 reais) e o prazo fixo de 7 dias."

> "Se a validação falhar, uma exceção customizada é lançada e o Spring automaticamente converte em **SOAP Fault** — que é o padrão de erro do protocolo."

---

## PARTE 3 — Configuração do Web Service — 2:30 a 3:15
**[Tela: `WebServiceConfig.java` e `SoapLoggingConfig.java`]**

> "O `WebServiceConfig` registra os dois WSDLs — um para o serviço de endereço, outro para frete — e mapeia tudo no endpoint `/ws`."

> "O `SoapLoggingConfig` adiciona dois interceptors: um que **valida** as mensagens SOAP contra o XSD antes de processar, e outro que **loga** o XML de cada requisição e resposta. Isso é muito útil para debug."

---

## PARTE 4 — O Consumer — 3:15 a 4:15
**[Tela: `SoapClient.java` e `ConsumerRunner.java`]**

> "O Consumer usa o `WebServiceTemplate` do Spring para fazer as chamadas. Ele tem dois templates, um para cada serviço, cada um com seu próprio marshaller apontando para o pacote de classes geradas pelo JAXB."

> "O `ConsumerRunner` implementa `CommandLineRunner` — isso significa que ele roda automaticamente quando a aplicação sobe. Ele faz duas chamadas de teste: consulta o CEP `01001000` e calcula o frete de São Paulo para o Rio, com 2,5 kg. O resultado aparece no console."

---

## PARTE 5 — Demo ao vivo — 4:15 a 4:50
**[Tela: terminal com os dois projetos rodando]**

> "Vou subir os dois. Primeiro o Producer com `mvn spring-boot:run` na pasta producer... serviço disponível na porta 9090."

> "Agora o Consumer... e aqui ele já executa e imprime no console o endereço retornado e o valor do frete calculado."

---

## ENCERRAMENTO — 4:50 a 5:00

> "É isso! Um sistema SOAP completo com Spring Boot, validação por XSD, geração de classes com JAXB e arquitetura Producer/Consumer. O código está no GitHub. Valeu!"

---

**Dicas de apresentação:**
- Abra os arquivos na IDE enquanto fala sobre eles — mostra o código real, não slides.
- Deixe o terminal aberto antes de gravar para a demo não travar.
- A parte do WSDL gerado automaticamente (`http://localhost:9090/ws/endereco.wsdl`) pode ser boa para mostrar no navegador — impressiona bastante.
