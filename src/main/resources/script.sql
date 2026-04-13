CREATE TABLE Aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    matriculaAluno INT,
    nome VARCHAR(100)
);

CREATE TABLE Publicacao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigoPub INT,
    titulo VARCHAR(150),
    ano INT,
    autor VARCHAR(100),
    tipo VARCHAR(50)
);

CREATE TABLE Emprestimo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    dataEmprestimo DATE,
    dataDevolucao DATE,
    aluno_id BIGINT,
    publicacao_id BIGINT,
    FOREIGN KEY (aluno_id) REFERENCES Aluno(id),
    FOREIGN KEY (publicacao_id) REFERENCES Publicacao(id)
);