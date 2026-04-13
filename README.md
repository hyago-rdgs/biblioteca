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

## Autor

Hyago Fernando Ferreira Rodrigues

