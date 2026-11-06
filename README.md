# DocFlow API

Upload e processamento assíncrono de documentos (comprovantes, notas fiscais, contratos) com AWS.

O cliente envia o arquivo direto para o **S3** via presigned URL; o upload gera um evento numa fila **SQS**, um worker valida o arquivo, publica o resultado num tópico **SNS** e o dono recebe um e-mail pelo **SES**. Segredos ficam no **Secrets Manager** e configurações no **Parameter Store**.

> Projeto em construção. As integrações AWS entram por etapas.

## Stack

Java 21 · Spring Boot 4.1 · PostgreSQL 16 · Flyway · MapStruct · springdoc-openapi · Testcontainers · Spring Cloud AWS

## Como rodar

Pré-requisitos: JDK 21 e Docker em execução.

Crie o arquivo `.env` a partir do modelo e ajuste as credenciais se quiser:

```bash
cp .env.example .env
```

Suba a aplicação:

```bash
./mvnw spring-boot:run
```

O Spring Boot sobe o Postgres do `compose.yaml` automaticamente (porta 5433 no host).

- Swagger UI: http://localhost:8080/swagger-ui.html
- Health: http://localhost:8080/actuator/health

## Testes

```bash
./mvnw verify
```

Os testes de integração sobem um PostgreSQL com Testcontainers, então o Docker precisa estar em execução.
