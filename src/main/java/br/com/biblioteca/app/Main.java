package main.java.br.com.biblioteca.app;

import main.java.br.com.biblioteca.dao.EmprestimoDAO;
import main.java.br.com.biblioteca.dao.JPAUtil;
import main.java.br.com.biblioteca.model.Aluno;
import main.java.br.com.biblioteca.model.Emprestimo;
import main.java.br.com.biblioteca.model.Publicacao;

import jakarta.persistence.EntityManager;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        Aluno aluno1 = new Aluno(2024001, "Ana Silva");
        Aluno aluno2 = new Aluno(2024002, "Carlos Mendes");

        Publicacao pub1 = new Publicacao(101, "Clean Code", 2008, "Robert C. Martin", "Livro");
        Publicacao pub2 = new Publicacao(102, "Effective Java", 2018, "Joshua Bloch", "Livro");

        em.getTransaction().begin();
        em.persist(aluno1);
        em.persist(aluno2);
        em.persist(pub1);
        em.persist(pub2);
        em.getTransaction().commit();
        em.close();

        System.out.println("✔ Alunos e publicações inseridos.");

        EmprestimoDAO dao = new EmprestimoDAO();

        Emprestimo emp1 = new Emprestimo(new Date(), null, aluno1, pub1);
        Emprestimo emp2 = new Emprestimo(new Date(), new Date(), aluno1, pub2);
        Emprestimo emp3 = new Emprestimo(new Date(), null, aluno2, pub1);

        dao.salvar(emp1);
        dao.salvar(emp2);
        dao.salvar(emp3);

        System.out.println("✔ Empréstimos criados.");

        Emprestimo encontrado = dao.buscarPorId(emp1.getId());
        System.out.println("\n── Busca por ID (" + emp1.getId() + "):");
        System.out.println(encontrado);

        List<Emprestimo> todos = dao.listarTodos();
        System.out.println("\n── Lista de todos os empréstimos (" + todos.size() + " registros):");
        todos.forEach(System.out::println);

        List<Emprestimo> porAluno = dao.buscarPorNomeAluno("Ana");
        System.out.println("\n── Empréstimos da aluna 'Ana' (" + porAluno.size() + " registros):");
        porAluno.forEach(System.out::println);

        emp1.setDataDevolucao(new Date());
        dao.atualizar(emp1);
        System.out.println("\n✔ Empréstimo #" + emp1.getId() + " atualizado (devolução registrada).");

        dao.deletar(emp3.getId());
        System.out.println("✔ Empréstimo #" + emp3.getId() + " removido.");

        System.out.println("\n── Total final: " + dao.listarTodos().size() + " empréstimo(s).");

        JPAUtil.close();
    }
}

