CREATE DATABASE lojaCamisa;
-- private Long id;
-- private String nome;
-- private double preco;
-- private String descricao;
USE lojaCamisa;
CREATE TABLE camisas (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
	tamanho VARCHAR(2),
    descricao VARCHAR(100),
    preco DECIMAL (10, 2)
);

CREATE TABLE funcionarios(
	id INT PRIMARY KEY AUTO_INCREMENT, -- Chave primária para o banco de dados.
	nome VARCHAR (100), -- Nome completo do funcionário.
	cargo VARCHAR (100), -- Função ou cargo do funcionário dentro da empresa (ex.: Gerente, Vendedor, Estoquista).
	idade INT, -- Idade do funcionário.
    telefone VARCHAR(11),
    email VARCHAR(100)
);


SELECT * FROM funcionarios;