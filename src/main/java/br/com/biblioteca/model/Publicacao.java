package main.java.br.com.biblioteca.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publicacao")
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_pub", nullable = false, unique = true)
    private int codigoPub;

    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "ano", nullable = false)
    private int ano;

    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    @OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Publicacao() {}

    public Publicacao(int codigoPub, String titulo, int ano, String autor, String tipo) {
        this.codigoPub = codigoPub;
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.tipo = tipo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getCodigoPub() { return codigoPub; }
    public void setCodigoPub(int codigoPub) { this.codigoPub = codigoPub; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public List<Emprestimo> getEmprestimos() { return emprestimos; }
    public void setEmprestimos(List<Emprestimo> emprestimos) { this.emprestimos = emprestimos; }

    @Override
    public String toString() {
        return "Publicacao{id=" + id + ", codigo=" + codigoPub + ", titulo='" + titulo + "', autor='" + autor + "', ano=" + ano + ", tipo='" + tipo + "'}";
    }
}
