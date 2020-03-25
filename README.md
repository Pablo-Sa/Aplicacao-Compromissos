# API-WS-BACK-END
Implementado Spring Data, Spring Security, Mockito, JUnit, AssertJ, JWTToken, Swagger, Tratamento de Exceções, Paginação e etc.

## Front-End
Lembrando que está API faz mensão ao Projeto AngularJS que possuo também em meus repositórios, tal é o Back-End da aplicação.

## Executando e testando o projeto

### Pré-requisitos
* PostgresSQL (O banco que foi testado).
* Java 8
* Sistema Operacional Windows Pois este tutorial não irá abordar instalação em outros SO.

#### 1 - Instalar o PostgresSQL:

A página oficial contém [links para download](https://www.postgresql.org/download/) do SGBD para diversas plataformas.


1.1 Instalar o PostgreSQL:

1.2 É bastante simples, basta dar um duplo clique no executável que foi baixado no passo a cima e seguir os passos do instalador.

#### 2 - Configurar as propriedades da aplicação 

Caminho até o arquivo de propriedades da aplicação:
`src/main/resources/application.properties`

O usuário e a senha cadastrados durante a instalação do BD deveram ser informados neste arquivo.  

Por exemplo, a string de conexão com o banco `postgres` rodando local na porta `8080`
seria `jdbc:postgresql://localhost:5432/agenda`. Para configurar usuário `postgres` e senha `postgres` uma configuração

spring.datasource.username=postgres
spring.datasource.password=postgres

#### 3 - Buildar e executar a aplicação

Dentro do diretório root da aplicação executar os passos abaixo.

3.1 Para rodar os testes:

##Obs para rodar os testes lembre-se que o maven precisa estar instalado. 

`$ mvn test #Para rodar os testes`

3.2 Para buildar a aplicação:
`$ mvn clean install #buildando o pacote da aplicação`

3.3 Para executar a aplicação:

O Maven através do `spring-boot-maven-plugin` gera o jar executável.
Então basta entrar no diretório `target/` e executar:

`$ java -jar "apirest-0.0.1-SNAPSHOT"`

OBS: Lembrando que deve informar todo o Diretório, então supondo que a pasta esteja em C:\
Logo o Comando Será : 
`$ java -jar "C:\pastadoprojeto\target\apirest-0.0.1-SNAPSHOT"`

A partir deste ponto se tudo ocorrer corretamente a aplicação estará rodando 

É possível utilizar o client do swagger através da url [http://localhost:8080/swagger-ui.html]

## Principais tecnologias e frameworks utilizados

- Java 8
- Spring Boot 
- JUnit 5
- Mockito
- Hibernate
- Swagger
- Lombook
