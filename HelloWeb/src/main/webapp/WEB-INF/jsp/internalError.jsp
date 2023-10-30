<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Errore di sistema</title>
</head>
<body>
	<%
		Object obj = request.getAttribute("EXCEPTION");
		Exception e = (Exception) obj;
		String message = e.getMessage();
	%>
	<p>Ci scusiamo ma c'è stato un errore nel sistema </p>
	<p>Segnalare all'amministratore l'errore: <%= message %></p>
</body>
</html>