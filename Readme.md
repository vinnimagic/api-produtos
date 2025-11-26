# 📦 API de Gestão de Produtos e Categorias

Este projeto é uma API RESTful desenvolvida com **Spring Boot** para o gerenciamento de produtos e suas categorias. 

O sistema foi construído seguindo as melhores práticas de mercado, incluindo arquitetura em camadas, tratamento de exceções, validações, documentação automática com Swagger e containerização com Docker.

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3** (Web, Data JPA, Validation)
- **Banco de Dados:**
  - **H2 Database:** Banco em memória para desenvolvimento rápido e testes.
  - **PostgreSQL:** Banco relacional robusto para produção (via Docker).
- **Docker & Docker Compose:** Para orquestração do banco de dados.
- **Swagger / OpenAPI:** Documentação e teste interativo da API.
- **Maven:** Gerenciamento de dependências.

---

## ✅ Funcionalidades (Requisitos Atendidos)

Este projeto atende aos seguintes critérios de avaliação:

- [x] **Arquitetura em Camadas:** Separação clara entre `Controller`, `Service` e `Repository`.
- [x] **API RESTful:** Implementação de verbos HTTP (GET, POST, PUT, DELETE).
- [x] **CRUD Completo:** Criação, leitura, atualização e remoção de Produtos.
- [x] **Relacionamentos JPA:** Produtos vinculados a Categorias (`@ManyToOne`).
- [x] **Filtros de Busca:** Rota específica para buscar produtos por nome.
- [x] **Validações:** Uso de Bean Validation (`@NotNull`, `@Size`, `@Positive`) impedindo dados inconsistentes.
- [x] **Tratamento de Erros:** `GlobalExceptionHandler` retornando JSONs amigáveis em caso de falha.
- [x] **Ambientes (Profiles):** Configuração segregada para Desenvolvimento (H2) e Produção (Postgres).
- [x] **Documentação:** Swagger UI integrado.

---

## 🛠️ Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:
- [Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Docker & Docker Compose](https://www.docker.com/products/docker-desktop/) (Opcional se rodar apenas em modo Dev)

---

## 🏃‍♂️ Como Rodar o Projeto

### 1. Clonar o repositório
```bash
git clone [https://github.com/vinnimagic/api-produtos.git](https://github.com/vinnimagic/api-produtos.git)
cd api-produtos
