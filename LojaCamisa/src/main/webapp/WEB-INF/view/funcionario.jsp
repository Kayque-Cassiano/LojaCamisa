<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/funcionario.css">
    <link rel="stylesheet" href="css/cabecalho2.css">
    <title>Funcionários</title>
</head>
<body>
    <header>
        <div class="center">
            <img src="images/husky.png" alt="">
            <input type="search" placeholder="Pesquisar">
            <nav>
                <a href="homeFun">
                    <button>
                        Home
                    </button>
                </a>
            </nav>
        </div>
    </header>

    <main>
        <div class="content">
            <img src="images/account_circle_80dp_E8EAED_FILL0_wght400_GRAD0_opsz48.svg" alt="">
            <div class="text">
                <p>Nome: ${funcionario.nome}</p>
                <p>Cargo: ${funcionario.cargo}</p>
                <p>Telefone: ${funcionario.telefone}</p>
                <p>Idade: ${funcionario.idade}</p>
                <p>Email: ${funcionario.email}</p>
            </div>
        </div>
        <div class="button">
            <a href="formulario?idFuncionario=${funcionario.id}">
                <button style="background-color: green;" type="button">Editar</button>
            </a>
            <a href="deletarFuncionario?idFuncionario=${funcionario.id}">
                <button style="background-color: red;" type="button">Deletar</button>
            </a>
        </div>
    </main>

    <footer>
        <span>Rua Direita, 955 - Vila Santo Antônio.</span>
        <span>SENAI Cotia - "Ricardo Lerner".</span>
        <span>Cotia, SP.</span>
    </footer>
</body>
</html>