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
    <link rel="stylesheet" href="css/form.css">
    <title>Form - Pizza</title>
</head>
<body>
    <!-- Form -->
    <header>
        <img src="images/husky.png" alt="">
        <input type="search" placeholder="Pesquisar">
        <button>
            <a href="home">Home</a>
        </button>
    </header>

    <form method="POST" action="${camisa.id != null ? 'atualizarCamisa' : 'adicionarCamisa'}?idCamisa=${camisa.id}">
        <div>
            <label for="image">Foto da Camisa</label>
            <input type="file" id="image" name="image">
        </div>

        <div>
            <label for="name">Nome</label>
            <input value="${camisa.nome }" type="text" id="name" name="nome">
        </div>

        <div class="flex">
            <div>
                <Label for="tamanho">Tamanho</Label>
                <input value="${camisa.tamanho}" type="text" id="tamanho" placeholder="M, G, P..." name="tamanho">
            </div>
            <div>
                <label for="number">Preço</label>
                <input value="${camisa.preco}" type="text" name="preco" id="number">
            </div>
        </div>

        <div>
            <p>Descrição</p>
            <textarea value="${camisa.descricao}" name="descricao" placeholder="Fale brevemente..."></textarea>
        </div>

        <div class="botao">
            <button type="submit">Enviar</button>
        </div>
    </form>

    <footer>
        <p>Developed by Kayque</p>
    </footer>
</body>
</html>