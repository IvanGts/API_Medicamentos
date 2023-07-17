# API de Medicamentos 

Este projeto é uma API de medicamentos desenvolvida em Java utilizando Spring Boot, JPA e MySQL. A API permite cadastrar, buscar, atualizar e deletar medicamentos, além de filtrar medicamentos por marca, fabricante e preço. Também está sendo desenvolvido um conjunto de endpoints relacionados ao carrinho de compras, incluindo adicionar ao carrinho, remover do carrinho e finalizar compra.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter os seguintes requisitos instalados:

- Java Development Kit (JDK) versão 8 ou superior
- MySQL Server
- Maven
- Git

## Configuração do Banco de Dados

Antes de executar a API, é necessário configurar o banco de dados MySQL. Crie um banco de dados chamado "medicamentos_db" ou altere o nome no arquivo `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/medicamentos_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

## Executando a API

1. Clone o repositório para o seu ambiente local:

```
git clone https://github.com/IvanGts/API_Medicamentos.git
```

2. Navegue para o diretório do projeto:

```
cd API_Medicamentos
```

3. Compile o projeto usando o Maven:

```
mvn clean package
```

4. Execute o JAR gerado:

```
java -jar target/API_Medicamentos-1.0.0.jar
```

A API será executada e estará disponível na porta 8081.

## Documentação da API (Swagger)

A documentação da API pode ser acessada através do Swagger em: `http://localhost:8081/swagger-ui.html`

## Endpoints disponíveis

- Cadastro do medicamento (POST): `http://localhost:8081/medicamento/cadastro`
- Busca por ID (GET): `http://localhost:8081/medicamento/{id}`
- Deletar por ID (DELETE): `http://localhost:8081/medicamento/{id}`
- Atualizar o preço (PUT): `http://localhost:8081/medicamento/atualizar-preco/{id}`
- Listar todos os medicamentos (GET): `http://localhost:8081/medicamento/listarMedicamentos`
- Filtrar medicamentos (GET): `http://localhost:8081/medicamento/filtrar`

## Desenvolvimento dos Endpoints do Carrinho de Compras

Atualmente, está sendo desenvolvido o conjunto de endpoints relacionados ao carrinho de compras. Em breve, estes endpoints estarão disponíveis para uso.

## Contribuindo

Se você quiser contribuir para este projeto, fique à vontade para abrir pull requests e propor melhorias. Sua ajuda é sempre bem-vinda!

## Licença

Este projeto é licenciado sob a licença MIT. Consulte o arquivo LICENSE para obter mais detalhes.

---

Espero que este README seja útil para o seu projeto! Se tiver alguma dúvida ou precisar de mais ajuda, fique à vontade para entrar em contato. Bom desenvolvimento!
