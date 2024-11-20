<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1" %>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/cabecalho2.css">
    <title>Home</title>
</head>

<body>
    <header>
        <div class="center">
            <img src="images/husky.png" alt="">
            <input type="search" placeholder="Pesquisar">
            <nav>
                <a href="home.html">
                    <button>
                        Home
                    </button>
                </a>
            </nav>
        </div>
    </header>

    <div class="nav">
        <a href="formulario.html">
            <button type="button">Formulário</button>
        </a>
    </div>

    <section class="content">
        <div class="titulo">
            <h1>Funcionários</h1>
        </div>

        <div class="funcionario">
        <c:forEach items="${funcionarios}" var="funcionario">
            <a href="funcionario?idFuncionario=${funcionario.id}">
                <div class="card-funcionario">
                    <img src="images/account_circle_80dp_E8EAED_FILL0_wght400_GRAD0_opsz48.svg" alt="">
                    <p>${funcionario.nome}</p>
                </div>
            </a>
         </c:forEach>
        </div>
    </Section>        
    <footer>
        <span>Rua Direita, 955 - Vila Santo Antônio.</span>
        <span>SENAI Cotia - "Ricardo Lerner".</span>
        <span>Cotia, SP.</span>
    </footer>
</body>

</html>