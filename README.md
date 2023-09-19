# PlantiCenter

Este projeto é uma solução Java Spring Boot que consiste em configurar um projeto Spring Boot básico e implementar várias funcionalidades, incluindo criação de entidade, repositório JPA, CRUD, controlador REST, testes unitários, tratamento de exceções, documentação da API com Swagger, segurança e implementação de paginação.

## Configuração Básica do Spring Boot
Para configurar o projeto Spring Boot básico, utilizamos o Spring Initializr com as seguintes características:

Nome do projeto: "TesteSpringBoot"
Grupo: "com.example"
Embalagem: JAR
Linguagem: Java
Dependências: Web e DevTools

## Criando uma Entidade
Foi criada uma classe de entidade chamada "Product" com os seguintes campos:

id (int)
nome (String)
preço (double)
Repositório e CRUD
Foi criado um repositório JPA para a entidade "Product" e implementadas operações CRUD (Create, Read, Update, Delete) para gerenciar produtos no banco de dados.

## Controlador REST
Foi criado um controlador REST chamado "ProductController" com os seguintes endpoints:

/api/products - Retorna todos os produtos em formato JSON.
/api/products/{id} - Retorna um produto específico por ID em formato JSON.
/api/products (POST) - Cria um novo produto com base nos dados enviados em JSON.
/api/products/{id} (PUT) - Atualiza um produto existente com base no ID e nos dados enviados em JSON.
/api/products/{id} (DELETE) - Exclui um produto com base no ID.

## Teste Unitário
Foi escrito um teste unitário usando JUnit e Mockito para testar o método de busca de produtos pelo ID no controlador "ProductController".

## Tratamento de Exceções
Foi implementado um tratamento de exceções personalizado para lidar com exceções não controladas em todo o aplicativo Spring Boot. Foi criada uma classe global de manipulador de exceções chamada "CustomExceptionHandler".

## Documentação da API
A API foi documentada usando o Swagger. O Swagger foi configurado para gerar documentação da API e um UI para testar os endpoints.

## Segurança
Foi implementada autenticação básica para proteger os endpoints da API. Foram usados nome de usuário e senha hardcoded para fins de teste.

## Teste de Integração
Foi escrito um teste de integração para testar a criação de um novo produto fazendo uma solicitação POST para o endpoint /api/products.

## Paginação
Foi implementada a paginação para a listagem de produtos no endpoint /api/products. Permite que o cliente especifique o número da página e o tamanho da página como parâmetros de consulta.
