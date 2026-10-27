# Finance API - RESTful API de Gestão Financeira Pessoal

API RESTful completa para controle e gestão financeira pessoal, desenvolvida com Java 17, Spring Boot 3, Spring Security e PostgreSQL. O projeto conta com autenticação JWT stateless, tratamento global de exceções e documentação interativa via Swagger UI.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 17
- **Framework:** Spring Boot 3
- **Segurança:** Spring Security + JWT (JSON Web Tokens)
- **Banco de Dados:** PostgreSQL + Spring Data JPA / Hibernate
- **Documentação:** OpenAPI 3 / Swagger UI
- **Utilitários:** Lombok, Maven

---

## 🚀 Funcionalidades

- **Autenticação & Usuários:**
  - Cadastro de novos usuários com senha criptografada (`BCrypt`).
  - Login com geração de Token JWT de acesso (válido por 24 horas).
  - Filtro customizado de segurança (`SecurityFilter`).

- **Categorias & Transações:**
  - Cadastro e consulta de categorias (ex: Alimentação, Transporte).
  - Lançamento de receitas e despesas vinculadas a categorias.
  - Listagem de transações salvas na base PostgreSQL.

---

## 📌 Endpoints Principais

| Método | Endpoint | Descrição | Acesso |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/auth/register` | Cadastra um novo usuário | Público |
| `POST` | `/api/auth/login` | Realiza o login e retorna o Token JWT | Público |
| `POST` | `/api/categories` | Cria uma nova categoria | Autenticado |
| `GET` | `/api/categories` | Lista todas as categorias | Autenticado |
| `POST` | `/api/transactions` | Cadastra uma nova transação | Autenticado |
| `GET` | `/api/transactions` | Lista todas as transações | Autenticado |

---

## 📖 Documentação Swagger

Com a aplicação em execução localmente, acesse a interface do Swagger em:
`http://localhost:8080/swagger-ui/index.html`
