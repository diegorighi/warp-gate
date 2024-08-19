# Warp Gate API

## Descrição

O **Warp Gate API** é um projeto desenvolvido com Spring Boot que tem como objetivo fornecer informações dos clientes para os dispositivos (clients) que consomem a API. A aplicação é projetada para ser escalável, segura e fácil de integrar com diversos tipos de dispositivos que necessitam de informações centralizadas sobre os clientes.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Liquibase** (para migração de banco de dados)
- **PostgreSQL** (banco de dados relacional)
- **Maven** (para gerenciamento de dependências)
- **Hibernate** (para ORM)

## Requisitos

- **Java 17** ou superior
- **Maven 3.8** ou superior
- **PostgreSQL** (ou outro banco de dados relacional compatível)
- **Git** (para controle de versão)

## Configuração

### Passo 1: Clonar o repositório

```bash
git clone git@github.com:diegorighi/warp-gate.git
cd warp-gate
```

### Passo 2: Configurar o Banco de Dados

Certifique-se de que o PostgreSQL esteja instalado e rodando. Crie um banco de dados para o projeto:

```sql
CREATE DATABASE warp_gate;
```

### Passo 3: Configurar as Propriedades da Aplicação

Configure as credenciais do banco de dados no arquivo `application-dev.properties` localizado em `src/main/resources`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/warp_gate
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.liquibase.change-log=classpath:db/changelog/db.changelog-master.xml
```

### Passo 4: Rodar a Aplicação com Perfil de Desenvolvimento

Para rodar a aplicação utilizando o perfil de desenvolvimento (`application-dev.properties`):

#### Usando Maven
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

#### Usando o JAR gerado
```bash
mvn clean install
java -jar -Dspring.profiles.active=dev target/warp-gate-0.0.1-SNAPSHOT.jar
```

### Passo 5: Testar a API

Após iniciar a aplicação, você pode testar os endpoints da API utilizando ferramentas como **Postman** ou **cURL**. A API estará disponível em:

```
http://localhost:8080/api/v1/clientes
```

## Endpoints Principais

- **`GET /api/v1/clientes`**: Retorna uma lista de todos os clientes.
- **`GET /api/v1/clientes/{id}`**: Retorna as informações de um cliente específico.
- **`POST /api/v1/clientes`**: Adiciona um novo cliente.
- **`PUT /api/v1/clientes/{id}`**: Atualiza as informações de um cliente existente.
- **`DELETE /api/v1/clientes/{id}`**: Remove um cliente do sistema.

## Estrutura do Projeto

- **`src/main/java`**: Contém o código fonte da aplicação.
- **`src/main/resources`**: Contém os arquivos de configuração, como `application.properties` e `Liquibase changelogs`.
- **`src/test`**: Contém os testes unitários e de integração.

## Contribuindo

Se você deseja contribuir para o desenvolvimento do **Warp Gate API**, sinta-se à vontade para fazer um fork do repositório, criar uma nova branch, e abrir um Pull Request.

1. Faça um fork do projeto
2. Crie uma nova branch (`git checkout -b feature/nova-funcionalidade`)
3. Faça suas alterações e commit (`git commit -am 'Adiciona nova funcionalidade'`)
4. Envie para o repositório remoto (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

## Contato

Se tiver alguma dúvida ou sugestão, sinta-se à vontade para entrar em contato:

- **Autor**: Diego Righi
- **E-mail**: [dev.drighi@icloud.com](mailto:dev.drighi@icloud.com)

