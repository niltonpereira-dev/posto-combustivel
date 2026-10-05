# Posto de Combustível

API REST para gerenciar tipos de combustível, bombas e abastecimentos de um posto. O projeto foi desenvolvido com Java, Spring Boot, Spring Web MVC, Spring Data JPA e PostgreSQL.

## Funcionalidades

- Cadastro, consulta, atualização e exclusão de tipos de combustível.
- Cadastro e consulta de bombas, associadas a um tipo de combustível.
- Registro de abastecimentos, calculando o valor total com base no preço por litro.
- Persistência em PostgreSQL.
- Documentação interativa da API via Springdoc OpenAPI/Swagger UI.

## Tecnologias

- Java 17
- Spring Boot 4.1.1
- Maven (Maven Wrapper incluído)
- PostgreSQL 16
- Docker Compose

## Pré-requisitos

- JDK 17 ou superior
- Docker e Docker Compose, para iniciar o banco de dados

## Como executar

1. Inicie o PostgreSQL na raiz do projeto:

   ```bash
   docker compose up -d
   ```

2. Inicie a aplicação:

   **Linux/macOS**

   ```bash
   ./mvnw spring-boot:run
   ```

   **Windows**

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

A API ficará disponível em `http://localhost:8080`.

> A configuração local atual cria/atualiza o esquema automaticamente (`ddl-auto: update`) e exibe as consultas SQL. As credenciais padrão do banco (`admin`/`123`) são apenas para desenvolvimento local; altere-as antes de qualquer uso em ambiente compartilhado ou de produção.

## Endpoints

### Tipos de combustível — `/tipos`

| Método   | Rota             | Descrição                       |
| -------- | ---------------- | ------------------------------- |
| `POST`   | `/tipos`         | Cadastra um tipo de combustível |
| `GET`    | `/tipos`         | Lista os tipos cadastrados      |
| `GET`    | `/tipos/{id}`    | Consulta um tipo pelo ID        |
| `PUT`    | `/tipos?id={id}` | Atualiza um tipo                |
| `DELETE` | `/tipos/{id}`    | Exclui um tipo                  |

Exemplo de corpo para criação/atualização:

```json
{
  "nome": "Gasolina",
  "precoPorLitro": 5.89
}
```

### Bombas de combustível — `/bombasDeCombustivel`

| Método | Rota                           | Descrição                   |
| ------ | ------------------------------ | --------------------------- |
| `POST` | `/bombasDeCombustivel`         | Cadastra uma bomba          |
| `GET`  | `/bombasDeCombustivel`         | Lista as bombas cadastradas |
| `GET`  | `/bombasDeCombustivel/{id}`    | Consulta uma bomba pelo ID  |
| `PUT`  | `/bombasDeCombustivel?id={id}` | Atualiza uma bomba          |

Exemplo de corpo para criação/atualização (substitua `1` pelo ID de um tipo existente):

```json
{
  "nomeDaBomba": "Bomba 1",
  "tiposDeCombustivel": {
    "id": 1
  }
}
```

### Abastecimentos — `/abastecimento`

| Método | Rota                                                     | Descrição                           |
| ------ | -------------------------------------------------------- | ----------------------------------- |
| `POST` | `/abastecimento?quantidadeEmLitro={litros}&idBomba={id}` | Registra um abastecimento           |
| `GET`  | `/abastecimento`                                         | Lista os abastecimentos registrados |

Exemplo:

```http
POST http://localhost:8080/abastecimento?quantidadeEmLitro=30&idBomba=1
```

O valor total é calculado pelo serviço a partir do preço por litro associado à bomba. O cadastro de tipo de combustível e bomba deve ser feito antes do abastecimento.

> A rota de exclusão de bombas não está listada porque o mapeamento atual do controller não declara o parâmetro `{id}` na rota, embora o método espere esse parâmetro. Para documentar/usar a exclusão, ajuste o mapeamento para `DELETE /bombasDeCombustivel/{id}`.

## Documentação da API

Com a aplicação em execução:

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Testes

Execute os testes com o Maven Wrapper:

```bash
./mvnw test
```

No Windows:

```powershell
.\mvnw.cmd test
```
