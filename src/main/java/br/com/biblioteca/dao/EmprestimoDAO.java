package main.java.br.com.biblioteca.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import main.java.br.com.biblioteca.model.Emprestimo;

import java.util.List;

public class EmprestimoDAO {

    public void salvar(Emprestimo emprestimo) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(emprestimo);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Emprestimo atualizar(Emprestimo emprestimo) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Emprestimo atualizado = em.merge(emprestimo);
            em.getTransaction().commit();
            return atualizado;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void deletar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Emprestimo emprestimo = em.find(Emprestimo.class, id);
            if (emprestimo != null) {
                em.remove(emprestimo);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Emprestimo buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Emprestimo.class, id);
        } finally {
            em.close();
        }
    }

    public List<Emprestimo> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Emprestimo> query = em.createQuery(
                    "SELECT e FROM Emprestimo e JOIN FETCH e.aluno JOIN FETCH e.publicacao",
                    Emprestimo.class
            );
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Emprestimo> buscarPorNomeAluno(String nomeAluno) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Emprestimo> query = em.createQuery(
                    "SELECT e FROM Emprestimo e " +
                            "JOIN FETCH e.aluno a " +
                            "JOIN FETCH e.publicacao " +
                            "WHERE LOWER(a.nome) LIKE LOWER(:nome)",
                    Emprestimo.class
            );
            query.setParameter("nome", "%" + nomeAluno + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}

