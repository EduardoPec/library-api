# 📚 Library API  
API REST desenvolvida com **Spring Boot 3**, **JPA/Hibernate**, **PostgreSQL**, **JWT** e **OAuth2 Authorization Server**

> Projeto criado com fins educacionais e práticos, como parte do curso **Spring Boot Expert: JPA, REST, JWT, OAuth2 com Docker e AWS**, focado em arquitetura limpa, boas práticas e segurança moderna com autenticação e autorização.

---

## 📝 Descrição do Projeto

A aplicação implementa o gerenciamento completo de **Livros e Autores**, incluindo:

- CRUD completo para Livros e Autores.
- Pesquisa avançada com **Specifications (Livros)** e **Query By Example (Autores)**.
- Paginação, ordenação e validação com Jakarta Validation.
- Tratamento global de erros com respostas padronizadas.
- Segurança robusta com **OAuth2 + JWT**.
- Conversão entre DTOs e Entidades com **MapStruct**.

---

## 🔑 Segurança e Perfis de Acesso

A autenticação é feita através de um **Authorization Server personalizado**, emitindo tokens **JWT**.

| Perfil | Acesso | Descrição |
|-------|--------|-----------|
| **GERENTE** | total | CRUD completo em Autores, Livros e Clientes |
| **OPERADOR** | restrito | Pode cadastrar e pesquisar livros; visualizar autores. É o perfil padrão do login social |

### Mecanismos de autenticação implementados

- **OAuth 2.0 Authorization Server Customizado**
- **JWT como token de acesso**
- **Login Social com cadastro automático**
- `@PreAuthorize` controlando permissões por Role
- Mapeamento de usuários sempre disponível no SecurityContext com **CustomAuthentication**

---

## 📌 Endpoints Principais

### Livros `/livros`

| Método | Endpoint | Acesso | Descrição |
|---|---|---|---|
| `POST` | `/livros` | OPERADOR, GERENTE | Cadastrar livro (valida ISBN e preço ≥ 2020) |
| `GET` | `/livros` | OPERADOR, GERENTE | Lista com filtros dinâmicos via Specifications |
| `GET` | `/livros/{id}` | OPERADOR, GERENTE | Detalhes de um livro |
| `PUT` | `/livros/{id}` | OPERADOR, GERENTE | Atualizar livro |
| `DELETE` | `/livros/{id}` | GERENTE | Excluir livro |

### Autores `/autores`

| Método | Endpoint | Acesso | Descrição |
|---|---|---|---|
| `POST` | `/autores` | GERENTE | Cadastrar autor (impede duplicidade) |
| `GET` | `/autores` | OPERADOR, GERENTE | Listar autores com Query By Example |
| `GET` | `/autores/{id}` | OPERADOR, GERENTE | Buscar autor |
| `PUT` | `/autores/{id}` | GERENTE | Atualizar autor |
| `DELETE` | `/autores/{id}` | GERENTE | Impede exclusão se houver livros associados |

### Usuários

| Método | Endpoint | Acesso |
|---|---|---|
| `POST` | `/usuarios` | 🔓 Público (permitAll) |

---

## 🛠️ Tecnologias Usadas

| Camada | Tecnologias |
|---|---|
| Linguagem | Java 21 |
| Framework | Spring Boot 3.5.x |
| Banco de dados | PostgreSQL |
| ORM | Spring Data JPA / Hibernate |
| Segurança | Spring Security + OAuth2 + JWT |
| DTO Mapping | MapStruct |
| Build | Maven |
| Validação | Jakarta Validation |

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos
- Java **21+**
- Maven **3.9+**
- PostgreSQL (porta default configurada: **5433**)

### Passo a passo

```bash
git clone https://github.com/seuusuario/library-api.git
```
cd library-api

---

## ⚙️ Configuração do Banco de Dados

Edite o arquivo **`src/main/resources/application.yml`** com as credenciais do PostgreSQL:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5433/library
    username: SEU_USUARIO
    password: SUA_SENHA
```

---

### 🔐 Login Social (Google)

Caso deseje habilitar autenticação via **Google**, configure as variáveis de ambiente:

```bash
export GOOGLE_CLIENT_ID="..."
export GOOGLE_CLIENT_SECRET="..."
```

---

## ▶️ Rodando o Projeto

```bash
mvn clean install
```
```
mvn spring-boot:run
```

Acesse no navegador: [http://localhost:8080](http://localhost:8080)

---

## 🛑 Tratamento Global de Erros

A API conta com um `GlobalExceptionHandler` que mapeia e padroniza respostas de erro, garantindo mensagens claras ao consumidor da API.

| Status HTTP | Situação Tratada |
|------------|------------------|
| **422 - Unprocessable Entity** | Erros de validação (`@Valid`, regras de campo) |
| **409 - Conflict** | Duplicidade (ex: ISBN já existente) |
| **400 - Bad Request** | Violação de regra de negócio |
| **403 - Forbidden** | Falta de permissão (`@PreAuthorize`) |
| **500 - Internal Server Error** | Erro inesperado |

---

##  Objetivo

Este projeto foi desenvolvido com foco no aprendizado prático e na implementação de boas práticas, permitindo evoluir tecnicamente em:

- Estudo de boas práticas em APIs REST com **Spring Boot**
- Implementação de autenticação moderna com **OAuth2 e JWT**
- Utilização avançada de **JPA com Specifications & Query By Example**
- Evolução para **deploy com Docker e AWS**
