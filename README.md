# MSAuthJWT - Microserviço de Autenticação e Autorização

## 📋 Descrição
MSAuthJWT é um microserviço de autenticação e autorização desenvolvido em Java utilizando Spring Boot. O projeto implementa um sistema seguro de autenticação baseado em JWT (JSON Web Tokens) para gerenciar o acesso a recursos protegidos.

## 🚀 Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3.4.4**
- **Spring Security**
- **Spring Data JPA**
- **JWT (JSON Web Tokens)**
- **H2 Database**
- **Lombok**
- **SpringDoc OpenAPI**
- **Maven**

## 🛠️ Dependências Principais
- `spring-boot-starter-web`: Framework web Spring Boot
- `spring-boot-starter-security`: Segurança e autenticação
- `spring-boot-starter-data-jpa`: Persistência de dados
- `jjwt-api`: Geração e validação de tokens JWT
- `h2database`: Banco de dados em memória
- `springdoc-openapi`: Documentação da API
- `lombok`: Redução de código boilerplate

## 📦 Estrutura do Projeto
```
MSAuthJWT/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
├── pom.xml
├── mvnw
└── mvnw.cmd
```

## 🔧 Configuração
1. Clone o repositório
2. Certifique-se de ter o Java 21 instalado
3. Execute o projeto usando Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

## 🔐 Funcionalidades
- Autenticação de usuários
- Geração de tokens JWT
- Validação de tokens
- Autorização baseada em roles
- Documentação automática da API com Swagger/OpenAPI

## 📚 Documentação da API
A documentação da API está disponível através do Swagger UI após iniciar a aplicação:
```
http://localhost:8080/swagger-ui.html
```

## 🧪 Testes
O projeto inclui testes automatizados que podem ser executados com:
```bash
./mvnw test
```

## 🔄 Desenvolvimento
- Utilize o Spring Boot DevTools para desenvolvimento
- O H2 Database é configurado para desenvolvimento local
- Lombok está configurado para processamento de anotações

## 📝 Licença
Este projeto está sob licença [insira a licença aqui].

## 👥 Contribuição
Contribuições são bem-vindas! Por favor, siga as diretrizes de contribuição do projeto.

## 📞 Suporte
Para suporte, entre em contato através de [insira informações de contato]. 