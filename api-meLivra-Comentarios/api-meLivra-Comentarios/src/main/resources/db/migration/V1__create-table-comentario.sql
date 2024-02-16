CREATE TABLE comentarios(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    nomeUser text not null ,
    instituto text not null ,
    nomeProfessor text not null ,
    descricao text not null
);