<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/cabecalho.css">
<link rel="stylesheet" href="css/pizza.css">
<title>Visualizar Camisa</title>
</head>
<body>
	<header>
		<img src="images/husky.png" alt=""> <input type="search" placeholder="Pesquisar">
		<button>
			<a href="home">Home</a>
		</button>
	</header>

	<div class="produto">
		<img src="images/camisa.png" alt="">
		<div class="texto-produto">
			<h1>${camisas.nome}</h1>
			<p>${camisas.descricao}</p>
			<h1>R$ ${camisas.preco}</h1>
			<a href="form?idCamisa=${camisas.id}">
				<button type="button">Editar</button>
			</a>
			
			<a href="deletarCamisa?idCamisa=${camisas.id}">
			<button type="button">Deletar</button>
			</a>
		</div>
	</div>

	<footer>
		<p>Developed by Kayque</p>
	</footer>
</body>
</html>