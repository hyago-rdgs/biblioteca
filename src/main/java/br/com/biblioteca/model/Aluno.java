package main.java.br.com.biblioteca.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matricula_aluno", nullable = false, unique = true)
    private int matriculaAluno;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Aluno() {}

    public Aluno(int matriculaAluno, String nome) {
        this.matriculaAluno = matriculaAluno;
        this.nome = nome;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getMatriculaAluno() { return matriculaAluno; }
    public void setMatriculaAluno(int matriculaAluno) { this.matriculaAluno = matriculaAluno; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Emprestimo> getEmprestimos() { return emprestimos; }
    public void setEmprestimos(List<Emprestimo> emprestimos) { this.emprestimos = emprestimos; }

    @Override
    public String toString() {
        return "Aluno{id=" + id + ", matricula=" + matriculaAluno + ", nome='" + nome + "'}";
    }
}
