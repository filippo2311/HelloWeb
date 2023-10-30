<%@page import="java.util.Collection"%>
<%@page import="it.talentform.bank.model.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Lista clienti</title>

<style><%@include file="/WEB-INF/css/style.css"%></style>

</head>

<body>

	<%
		Collection<Client> clients = (Collection<Client>) request.getAttribute("ALL_CLIENTS");
		if (clients.isEmpty()){
			out.println("<h1>Non ci sono clienti registrati</h1>");
		}
		else { 
	%>
			<h1 class=btn>LISTA CLIENTI</h1>
			
			<table align="center">
				<tr>
					<th> ID </th>
					<th> NOME </th>
					<th> COGNOME </th>
					<th> SESSO </th>
					<th> DATA DI NASCITA </th>
					<th> SCOPERTO<br>COMPLESSIVO </th>
					<th> SCOPERTO<br>UNITARIO </th>
				</tr>
		
			<% for (Client c: clients){ %>
			
				<tr>
					<td><%= c.getId() %></td>
					<td><%= c.getFirstname() %></td>
					<td><%= c.getLastname() %></td>
					<td><%= c.getSex() %></td>
					<td><%= c.getDateOfBirth() %></td>
					<td><%= String.format("%,.2f", c.getDeficit()) %></td>
					<td><%= String.format("%,.2f", c.getMaxTotalDeficit()) %></td>
				</tr>				
			<%}%>
		</table>
		<%}%>
		
	<%-- 
		1. Riguardarsi con calma l'applicazione
		2. Questa pagina mostra solo i nomi dei clienti senza formatazione, modificarla in modo che mostri 
			invece una tabella stilizzata con CSS che mostri i dati dei clienti (tutti)
		3. Andarsi a studiare una presentazione PowerPoint chiamate "Servlet.ppv" e "JSP.ppv" su discord
	 --%>
	 
	 <br><br><br><a class=btn href="index.jsp"><--- Torna al menù principale</a>
</body>
</html>