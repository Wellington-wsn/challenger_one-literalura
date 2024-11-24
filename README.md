# challenger_one-literalura
Desafio ONE-Alura de um catálogo de livros que ofereça interação textual (via console) com os usuários, proporcionando no mínimo 5 opções de interação.
Este sistema permite a busca, armazenamento e gerenciamento de livros, utilizando interação textual via console e integração com uma API pública de livros.

---

## 🚀 Funcionalidades

1. **Busca de Livros pelo Título**  
   Permite ao usuário pesquisar por livros no repositório. Caso o título não seja encontrado, o sistema oferece a opção de consultar uma API pública.  
   ![Busca de Livros](src/img/Captura%20de%20tela%20de%202024-11-23%2011-49-21.png)

2. **Consulta na API**  
   Caso um livro não esteja no repositório local, o sistema realiza a busca na API e armazena os resultados no banco de dados.  
   ![Busca na API](src/img/Captura%20de%20tela%20de%202024-11-23%2011-51-12.png)

3. **Listagem de Livros Registrados**  
   Mostra todos os livros disponíveis no repositório local, organizados com informações do título e autor.  
   ![Lista de Livros](src/img/Captura%20de%20tela%20de%202024-11-23%2011-52-09.png)

4. **Listagem de Autores**  
   Apresenta uma lista de todos os autores registrados no repositório.  
   ![Lista de Autores](src/img/Captura%20de%20tela%20de%202024-11-23%2011-52-47.png)

5. **Consulta de Autores Vivos por Ano**  
   Permite verificar quais autores estavam vivos em um determinado ano informado pelo usuário.  
   ![Autores Vivos](src/img/Captura%20de%20tela%20de%202024-11-23%2022-24-15.png)

---

## 🛠️ Tecnologias Utilizadas

- **Java** (versão mínima 11)
- **Jakarta Persistence API (JPA)** para gerenciamento de entidades
- **Spring Framework** para injeção de dependências e manipulação de repositórios
- **API pública Gutendex** para busca de livros online
- **Banco de dados relacional (H2 ou outro configurado)**

---

## 📂 Estrutura do Projeto

```
src/
├── com.alura.literalura
│   ├── model/         # Classes modelo como Autor e Livro
│   ├── repository/    # Interfaces de repositórios (AutorRepository, LivrosRepository)
│   ├── service/       # Serviços para consumo de API e JSON
│   ├── principal/     # Classe principal Aplicacao
└── resources/
```

---

## 🎯 Como Executar
1. Configure o banco de dados no arquivo `application.properties`.
2. Interaja com o sistema via terminal.
