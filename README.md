# Library API — Projeto do Curso Spring Boot Expert: JPA, REST, JWT, OAuth2 com Docker e AWS

API REST desenvolvida com **Spring Boot 3**, **JPA/Hibernate** e **PostgreSQL**. 
O sistema implementa o gerenciamento completo de **Livros** e **Autores**, com validação, paginação, tratamento global de exceções e pesquisa dinâmica via Specifications.

---

## Sobre o Projeto

Este projeto foi criado com fins **educacionais e práticos**, acompanhando as aulas do curso **Spring Boot Expert: JPA, REST, JWT, OAuth2 com Docker e AWS**.  
O objetivo é entender, na prática, as **boas práticas de arquitetura e desenvolvimento de APIs RESTful** utilizando o ecossistema Spring.

A aplicação oferece endpoints completos para **autores e livros**, com:
- Criação, leitura, atualização e exclusão (CRUD);
- Pesquisa com múltiplos filtros;
- Paginação e ordenação automáticas;
- Validação e tratamento de erros padronizados;
- Conversão entre entidades e DTOs via **MapStruct**.

---

## Estrutura de Pastas
```
src/
├── main/
│ ├── java/io/github/eduardopec/libraryapi/
│ │ ├── controller/ # Endpoints REST
│ │ ├── dto/ # Data Transfer Objects
│ │ ├── mappers/ # MapStruct mappers
│ │ ├── service/ # Regras de negócio
│ │ ├── repository/ # Repositórios JPA
│ │ ├── model/ # Entidades JPA
│ │ └── validator/ # Validações customizadas
│ └── resources/
│ └── application.yml # Configurações da aplicação
└── test/
└── java/ # Testes unitários e de integração
```

---

## Tecnologias Utilizadas

| Camada | Tecnologia |
|:-------|:------------|
| **Linguagem** | Java 21 |
| **Framework** | Spring Boot 3.5.x |
| **Banco de Dados** | PostgreSQL |
| **ORM** | Hibernate / Spring Data JPA |
| **Validação** | Jakarta Validation |
| **Mapeamento DTO** | MapStruct |
| **Build Tool** | Maven |
| **Testes** | JUnit 5 |

---

## Como Executar o Projeto

### Pré-requisitos
- Java 21+
- Maven 3.9+
- PostgreSQL em execução (porta padrão `5432`)

### Passos para rodar

1. **Clonar o repositório**
   ```bash
   git clone https://github.com/seuusuario/library-api.git
   cd library-api
   ```
   
2. **Configurar Banco de Dados**
- Ajuste o arquivo src/main/resources/application.yml com suas credenciais:
```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/libraryapi
    username: postgres
    password: senha
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

3. Executar o projeto
```
mvn spring-boot:run
```

4. Acessar a aplicação
```
http://localhost:8080
```

## Endpoints Principais

A API possui endpoints RESTful para o gerenciamento de **Livros** e **Autores**, com suporte a operações CRUD completas, pesquisa dinâmica, paginação e ordenação automática.

---

### **Livros**

| Método | Endpoint | Descrição |
|:-------|:----------|:-----------|
| `POST` | `/livros` | Cadastrar um novo livro |
| `GET` | `/livros` | Listar e pesquisar livros por filtros (título, autor, gênero, ano, ISBN) |
| `GET` | `/livros/{id}` | Obter os detalhes de um livro específico |
| `PUT` | `/livros/{id}` | Atualizar as informações de um livro existente |
| `DELETE` | `/livros/{id}` | Remover um livro do sistema |

### **Autores**

Endpoints responsáveis por gerenciar os **autores** cadastrados no sistema.

---

| Método | Endpoint | Descrição |
|:-------|:----------|:-----------|
| `POST` | `/autores` | Cadastrar um novo autor |
| `GET` | `/autores` | Listar e pesquisar autores por nome (com paginação) |
| `GET` | `/autores/{id}` | Obter detalhes de um autor específico |
| `PUT` | `/autores/{id}` | Atualizar as informações de um autor existente |
| `DELETE` | `/autores/{id}` | Excluir um autor do sistema |

---
