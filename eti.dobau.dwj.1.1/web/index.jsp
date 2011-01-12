<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Lista de Comentários</h1>

<ul>
<c:forEach items="${comentarios}" var="comentario">
	<li>${comentario}</li>
</c:forEach>
</ul>

<form action="/dwj1/comentario" method="POST">
Comentário: <input type="text" name="comentario"/><br />
<input type="submit" value="Inserir Comentário">
</form>

</body>
</html>