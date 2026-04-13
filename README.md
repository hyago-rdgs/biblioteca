# Sistema de Biblioteca

Sistema acadêmico de gerenciamento de empréstimos de publicações, desenvolvido com Jakarta EE, JPA/Hibernate e banco H2.

---

## Tecnologias

| Tecnologia | Versão      |
|---|-------------|
| Java | 25          |
| Jakarta Persistence API | 3.1.0       |
| Hibernate ORM | 6.4.4.Final |
| H2 Database (in-memory) | 2.2.224     |
| Maven | 3.x         |

---

## Estrutura do Projeto

```
biblioteca/
├── .gitignore
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/br/com/biblioteca/
        │   ├── model/
        │   │   ├── Aluno.java
        │   │   ├── Publicacao.java
        │   │   └── Emprestimo.java
        │   ├── dao/
        │   │   ├── JPAUtil.java
        │   │   └── EmprestimoDAO.java
        │   └── app/
        │       └── Main.java
        └── resources/
            ├── META-INF/
            │   └── persistence.xml
            └── script.sql
```

---

## Modelo de Dados

```
Aluno (1) ──────── (N) Emprestimo (N) ──────── (1) Publicacao
```

- Um **Aluno** pode ter vários **Empréstimos**
- Uma **Publicação** pode estar em vários **Empréstimos**
- Cada **Empréstimo** pertence a exatamente um Aluno e uma Publicação

---

## Como Executar

### Pré-requisitos

- Java 25+
- Maven 3.6+

### Compilar e executar

```bash
cd biblioteca
mvn clean compile
mvn exec:java -Dexec.mainClass="br.com.biblioteca.app.Main"
mvn clean package
java -jar target/biblioteca-1.0.0.jar
```

> O banco H2 é criado **em memória** automaticamente ao iniciar. As tabelas são geradas pelo Hibernate (`hbm2ddl.auto=create-drop`).

---

## Operações implementadas no EmprestimoDAO

| Método | Descrição |
|---|---|
| `salvar(Emprestimo)` | Persiste novo empréstimo |
| `atualizar(Emprestimo)` | Atualiza empréstimo existente |
| `deletar(Long id)` | Remove empréstimo por ID |
| `buscarPorId(Long id)` | Busca empréstimo por ID |
| `listarTodos()` | Retorna todos os empréstimos |
| `buscarPorNomeAluno(String)` | JPQL com LIKE case-insensitive |

---

## Autores

Desenvolvido como projeto acadêmico para a disciplina de **Programação Orientada a Objetos / Banco de Dados**.

