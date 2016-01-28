<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkTo[LivrosController].salva}" method="post">
		<h2>Formúlario de cadastro de livros</h2>
		<ul>
			<li>
				<label>Titulo:</label>
				<input type="text" name="livro.titulo" value="${livro.titulo}"/>
			</li>
			
			<li>
				<label>Descrição:</label>
				<input type="textarea" name="livro.descricao" value="${livro.descricao}"/>
			</li>
			<li>
				<label>ISBN:</label>
				<input type="text" name="livro.isbn" value="${livro.isbn}"/>
			</li>
			<li>
				<label>Preço:</label>
				<input type="text" name="livro.preco" value="${livro.preco}"/>
			</li>
			
			<li>
				<label>Data de Publicação:</label>
				<input type="text" name="livro.dataPublicacao" value="${livro.dataPublicacao}"/>
			</li>
		</ul>
		
		<input type="submit" value="Salvar"/>
	</form>
</body>
</html>