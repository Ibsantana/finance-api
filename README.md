# 💰 Finance API - Sistema de Gestão Financeira

Uma API RESTful robusta desenvolvida em **Java** com **Spring Boot** para gerenciamento de finanças pessoais, acompanhada de um dashboard web interativo para testes e consumo dos endpoints em tempo real.

O projeto conta com autenticação via **JWT (JSON Web Token)**, persistência em banco de dados **PostgreSQL**, documentação interativa via **Swagger UI** e controle de permissões e CORS via **Spring Security**.

---

## 🚀 Funcionalidades

- **🔐 Autenticação e Segurança:**
  - Login e autenticação de usuários via JWT.
  - Controle de rotas protegidas por token de autorização (`Bearer Token`).
  - Configuração customizada de CORS para integração com o frontend.

- **🏷️ Gestão de Categorias:**
  - Cadastro e listagem de categorias para classificação de transações (ex: Alimentação, Moradia, Salário).

- **💵 Gestão de Transações:**
  - Registro de transações financeiras (Receitas e Despesas) associadas a categorias.
  - Listagem dinâmica com suporte à paginação (`Spring Data Pageable`).
  - Exclusão de transações (`DELETE /api/transactions/{id}`) em tempo real.

- **💻 Interface Web (Frontend):**
  - Dashboard intuitivo e responsivo desenvolvido em HTML, CSS e JavaScript puro.
  - Persistência da sessão do usuário via `localStorage`.
  - Formulário para lançamento de despesas/receitas e tabela de histórico com atualização dinâmica.

---

## 🛠️ Tecnologias Utilizadas

### **Backend**
- **Java 17**
- **Spring Boot 3**
- **Spring Security & JWT**
- **Spring Data JPA & Hibernate**
- **PostgreSQL**
- **Lombok**
- **Springdoc OpenAPI (Swagger UI)**
- **Maven**

### **Frontend**
- **HTML5 & CSS3**
- **JavaScript (ES6+)** (Fetch API & LocalStorage)

---

## 📁 Estrutura do Projeto

```text
finance-api/
├── src/
│   ├── main/
│   │   ├── java/com/financeiro/financeapi/
│   │   │   ├── config/          # Configurações de Segurança e CORS
│   │   │   ├── controller/      # Endpoints REST (Auth, Categories, Transactions)
│   │   │   ├── dto/             # Data Transfer Objects (Requests e Responses)
│   │   │   ├── exception/       # Tratamento global de exceções
│   │   │   ├── model/           # Entidades JPA (User, Category, Transaction)
│   │   │   ├── repository/     # Interfaces de acesso ao banco de dados
│   │   │   ├── security/       # Filtros JWT e provedores de autenticação
│   │   │   └── service/        # Regras de negócio da aplicação
│   │   └── resources/
│   │       └── application.properties # Configurações da aplicação e banco
├── index.html                   # Dashboard web do frontend
├── pom.xml                      # Dependências do Maven
└── README.md

```

---

## 🛠️ Como Executar o Projeto

### **Pré-requisitos**

* **Java 17+** instalado.
* **PostgreSQL** em execução.
* **Maven** configurado (ou via wrapper do projeto `./mvnw`).

### **1. Configurar o Banco de Dados**

Crie um banco de dados no PostgreSQL chamado `finance_db` (ou o nome configurado no seu arquivo `application.properties`):

```sql
CREATE DATABASE finance_db;

```

Ajuste as credenciais no arquivo `src/main/resources/application.properties` se necessário:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/finance_db
spring.datasource.username=postgres
spring.datasource.password=suasenha
spring.jpa.hibernate.ddl-auto=update

```

### **2. Executar a Aplicação**

No terminal da raiz do projeto (ou via IntelliJ IDEA), execute:

```bash
./mvnw spring-boot:run

```

O servidor iniciará por padrão em `http://localhost:8080`.

---

## 📑 Documentação da API (Swagger UI)

Com a aplicação rodando, acesse a documentação interativa dos endpoints pelo navegador:

👉 **`http://localhost:8080/swagger-ui/index.html`**

---

## 🔗 Endpoints da API

| Método | Endpoint | Descrição | Autenticação |
| --- | --- | --- | --- |
| `POST` | `/api/auth/login` | Realiza autenticação do usuário e retorna o Token JWT | Não |
| `POST` | `/api/categories` | Cadastra uma nova categoria | **Sim** |
| `GET` | `/api/categories` | Lista todas as categorias cadastradas | **Sim** |
| `POST` | `/api/transactions` | Registra uma nova transação (Receita/Despesa) | **Sim** |
| `GET` | `/api/transactions` | Lista as transações com suporte à paginação | **Sim** |
| `DELETE` | `/api/transactions/{id}` | Remove uma transação pelo ID | **Sim** |

*Nota: Para requisições autenticadas, envie o cabeçalho `Authorization: Bearer <seu_token_jwt>`.*

---

## 🖥️ Acessando a Interface Web (Dashboard)

1. Abra o arquivo `index.html` diretamente no navegador ou através da execução no IntelliJ.
2. Faça login com o e-mail e senha cadastrados.
3. Cadastre categorias e transações para visualizar as atualizações em tempo real integradas ao PostgreSQL.

---

## 👩‍💻 Autora

Desenvolvido por **Isabella Santana**.

## 👩‍💻 Autora

Desenvolvido por **Isabella Santana**.

- GitHub: [@Ibsantana](https://github.com/Ibsantana)
- Repositório: [finance-api](https://github.com/Ibsantana/finance-api)
