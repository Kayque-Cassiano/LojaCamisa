<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/cabecalho2.css">
<link rel="stylesheet" href="css/formulario.css">
<title>Formulário</title>
</head>

<body>
	<header>
		<div class="center">
			<img src="images/husky.png" alt=""> <input type="search"
				placeholder="Pesquisar">
			<nav>
				<a href="homeFun">
					<button>Home</button>
				</a>
			</nav>
		</div>
	</header>

	<form method="POST"
		action="${funcionario.id != null ? 'atualizarFuncionario' : 'adicionarFuncionario'}?idFuncionario=${funcionario.id}">
		<h1>Cadastrar Funcionários</h1>

		<div class="flex">
			<div>
				<label for="nome">Nome:</label> <input value="${funcionario.nome}"
					type="text" name="nome" id="nome" placeholder="Digite seu nome">
			</div>
			<div>
				<label for="nome">Cargo:</label> <input value="${funcionario.cargo}"
					type="text" name="cargo" id="cargo" placeholder="Digite seu cargo">
			</div>
		</div>

		<div class="flex">
			<div>
				<label for="nome">Idade:</label> <input value="${funcionario.idade}"
					type="text" name="idade" id="idade" placeholder="Digite sua idade">
			</div>
			<div>
				<label for="nome">Telefone:</label> <input
					value="${funcionario.telefone}" type="text" name="telefone"
					id="telefone" placeholder="Digite seu telefone">
			</div>
		</div>

		<label for="nome">Email:</label> <input value="${funcionario.email}"
			type="email" name="email" id="email" placeholder="Digite seu email">


		<button type="submit">Enviar</button>

	</form>

	<footer>
		<span>Rua Direita, 955 - Vila Santo Antônio.</span> <span>SENAI
			Cotia - "Ricardo Lerner".</span> <span>Cotia, SP.</span>
	</footer>
</body>

</html>