<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1" %>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/cabecalho.css">
    <link rel="stylesheet" href="css/home.css">
    <title>Home - Pizza</title>
</head>
<body>
    <header>
        <img src="images/husky.png" alt="">
        <input type="search" placeholder="Pesquisar">
        <button>
            <a href="form">Formulário</a>
        </button>
        <button>
            <a href="homeFun">Funcionários</a>
        </button>
    </header>

    <section class="content-one">
        <div class="container-content">
          <div class="content-item">
            <img alt="Pizza" src="images/camisa.png" />
          </div>
          <div class="content-item">
            <h2>Prepsre-se para o desafio</h2>
            <p>Na nossa loja de roupas esportivas, você encontra estilo, conforto e performance!</p>
          </div>
        </div>
      </section>
    <!-- card -->
    <!-- for -->

    <section class="content-camisa">
        <div class="titulo-camisa">
            <h1>Camisas</h1>
        </div>

        <div class="itens-camisa">
        <!-- For { -->
        <!--{pizzas} => ArrayList<Pizza> pizzas -->
        	<c:forEach items="${camisas}" var="camisa">
        		<a href="pizza?idCamisa=${camisa.id}">
                <div class="card-camisa">
                    <img src="images/camisa.png" alt="Camisa do Real Madrid">
                    <h2>${camisa.nome}</h2>
                    <p>${camisa.descricao}</p>
                    <p>${camisa.tamanho}</p>
                    <h1>R$ ${camisa.preco}</h1>
                </div>
            </a>
        	</c:forEach>
            
        </div>
    </section>

    <footer>
        <p>Developed by Kayque</p>
    </footer>
</body>
</html>