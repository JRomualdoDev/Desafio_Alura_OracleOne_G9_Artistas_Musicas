# Desafio Alura Oracle ONE G9 - ScreenSound

Este projeto é uma aplicação de console (CLI) desenvolvida como parte do Desafio Alura para o programa Oracle Next Education (ONE) G9. A aplicação, chamada **ScreenSound**, permite aos usuários gerenciar um banco de dados de artistas e suas músicas, além de integrar-se com a API da OpenAI para buscar informações e biografias sobre os artistas cadastrados.

## ✒️ Sobre o Projeto

O objetivo principal é construir um sistema em Java utilizando o framework Spring para gerenciar artistas e suas respectivas músicas. A aplicação funciona através de um menu interativo no console, permitindo ao usuário realizar operações de CRUD (Create, Read, Update, Delete) para as entidades e consumir uma API externa para enriquecer os dados.

## ✨ Funcionalidades Principais

- **Cadastrar Artistas**: Permite registrar novos artistas, classificando-os por tipo (Solo, Dupla, Banda).
- **Cadastrar Músicas**: Associa novas músicas a um artista já existente.
- **Listar Músicas por Artista**: Exibe todas as músicas de um determinado artista.
- **Listar Todos os Artistas**: Mostra todos os artistas cadastrados no banco de dados.
- **Pesquisar Dados do Artista**: Utiliza a API da OpenAI (via Spring AI) para buscar informações adicionais sobre um artista, como uma breve biografia.

##  diagrama de Arquitetura

O diagrama abaixo ilustra a arquitetura da aplicação, mostrando o fluxo de interação desde o usuário até o banco de dados e a API externa.

```mermaid
graph TD
    A[👤 Usuário] --> B{💻 Menu Principal (CLI)};
    
    B --> C[1. Cadastrar Artistas];
    B --> D[2. Cadastrar Músicas];
    B --> E[3. Listar Músicas];
    B --> F[4. Pesquisar sobre Artista];
    B --> G[5. Listar Artistas];

    subgraph "Camada de Serviço"
        C & G--> H(🎤 ArtistaService);
        D & E--> I(🎶 MusicaService);
        F --> M(🧠 ConsultaChatGPT);
    end

    subgraph "Camada de Acesso a Dados"
        H --> J(🔧 ArtistaRepository);
        I --> K(🔧 MusicaRepository);
    end

    subgraph "Banco de Dados"
        J & K --> L[((🗃️ MySQL DB))];
    end
    
    subgraph "API Externa"
        M --> N[🤖 OpenAI API];
    end

```

## 🛠️ Tecnologias Utilizadas

- **Java 17**: Versão da linguagem Java utilizada no projeto.
- **Spring Boot 3**: Framework principal para a construção da aplicação.
- **Spring Data JPA**: Para persistência de dados e comunicação com o banco de dados.
- **Spring AI**: Para integração simplificada com a API da OpenAI.
- **MySQL**: Banco de dados relacional para armazenar os dados.
- **Docker & Docker Compose**: Para provisionar e gerenciar o ambiente do banco de dados de forma conteinerizada.
- **Maven**: Gerenciador de dependências e build do projeto.

## 🚀 Como Executar o Projeto

Siga os passos abaixo para configurar e executar o projeto em seu ambiente local.

### Pré-requisitos

- **Java 17** ou superior instalado.
- **Docker** e **Docker Compose** instalados.
- Uma **chave de API da OpenAI**. Você pode obter uma no [site da OpenAI](https://platform.openai.com/account/api-keys).

### 1. Clone o Repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

### 2. Configure a Aplicação

Renomeie o arquivo `application_example.properties` para `application.properties` dentro do diretório `src/main/resources/`.

```bash
rename src/main/resources/application_example.properties src/main/resources/application.properties
```

Abra o arquivo `application.properties` e preencha as seguintes informações:

```properties
# Nome da aplicação
spring.application.name=ScreenSound

# Configurações do Banco de Dados (de acordo com o docker-compose.yml)
spring.datasource.url=jdbc:mysql://localhost:3307/screenSound
spring.datasource.username=spring
spring.datasource.password=spring
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuração do Hibernate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update

# Chave da API da OpenAI
spring.ai.openai.api-key=SUA_CHAVE_DE_API_AQUI
```

### 3. Inicie o Banco de Dados

Use o Docker Compose para iniciar o contêiner do MySQL em segundo plano. O comando `docker-compose up -d`.

```bash
docker-compose up -d
```
Este comando irá criar e iniciar um container MySQL na porta 3307, conforme configurado no `docker-compose.yml`.

### 4. Execute a Aplicação

Utilize o Maven Wrapper para compilar e executar a aplicação Spring Boot.

```bash
./mvnw spring-boot:run
```

Após a inicialização, o menu interativo aparecerá no seu terminal.

## 📖 Principais Aprendizados

- **Mapeamento de Entidades com JPA**: Implementação de relacionamentos entre entidades, como o `OneToMany` entre `Artista` e `Música`.
- **Estrutura de um Projeto Spring**: Organização do código em camadas (Model, Repository, Service) para uma arquitetura limpa e de fácil manutenção.
- **Criação de uma Aplicação de Console**: Desenvolvimento de uma interface de usuário interativa no terminal.
- **Consumo de APIs Externas**: Integração com a API da OpenAI utilizando o `Spring AI`, simplificando a comunicação e o tratamento de respostas.
- **Gerenciamento de Ambiente com Docker**: Utilização do Docker para criar um ambiente de banco de dados consistente e isolado, facilitando a configuração e a execução do projeto em diferentes máquinas.
- **Persistência de Dados**: Uso prático do Spring Data JPA para abstrair as operações de banco de dados, focando na lógica de negócio.

## ✍️ Autor

Desenvolvido por **José Romualdo** como parte do programa Alura + Oracle ONE.