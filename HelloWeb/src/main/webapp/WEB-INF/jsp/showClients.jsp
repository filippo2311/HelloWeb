<%@page import="java.util.Collection"%>
<%@page import="it.talentform.bank.model.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista clienti</title>
</head>
<body>
	<h1>Lista clienti</h1>
	<%
		Collection<Client> clients = (Collection<Client>) request.getAttribute("ALL_CLIENTS");
		if (clients.isEmpty()){
			out.println("<p>Non ci sono clienti registrati</p>");
		}
		for (Client c: clients){
			out.println(c.getFirstname()+"<br>");
		}
	%>
	<%-- 
		1. Riguardarsi con calma l'applicazione
		2. Questa pagina mostra solo i nomi dei clienti senza formatazione, modificarla in modo che mostri 
			invece una tabella stilizzata con CSS che mostri i dati dei clienti (tutti)
		3. Andarsi a studiare una presentazione PowerPoint chiamate "Servlet.ppv" e "JSP.ppv" su discord
	 --%>
</body>
</html>