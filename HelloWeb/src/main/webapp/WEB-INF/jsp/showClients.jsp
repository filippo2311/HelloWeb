<jsp:include page="/base.jsp"/>
<%@page import="java.util.Collection"%>
<%@page import="it.talentform.bank.model.Client"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>

<head>
	<title>Lista clienti</title>
</head>

<body>
	<div>
	<c:choose>
		<c:when test="${empty ALL_CLIENTS}">
			<h2>Nessuna occorrenza trovata.</h2>
		</c:when>
		<c:otherwise>
			<table>
			<caption class="heading">Lista clienti</caption>
				
				<thead>
				<tr>
					<th> ID </th>
					<th> NOME </th>
					<th> COGNOME </th>
					<th> SESSO </th>
					<th> DATA DI NASCITA </th>
					<th> SCOPERTO<br>COMPLESSIVO </th>
					<th> SCOPERTO<br>UNITARIO </th>
				</tr>
				</thead>
				
				<tbody>
				<%--
					Per capire questo codice è necessario innanzitutto capire cosa
					sia un bean.
					E' definita bean una classe che ha getter e setter per tutte le
					proprietà ed un costruttore senza parametri.
					
					Molti framework usano questa definizione per ottenere i nomi delle
					variabili ed usarlipre leggere/assegnare valori.
					
					In pratica, quello che questi framework fanno è prendere il nome
					della proprietà, rendere maiuscola la prima lettera ed aggiungerci
					un get davanti.
					
					In pratica, quando leggete ${client.id}, quello che fa JSP è
					cercare la funzine client.getId() e chiamarla.
					 
				--%>
				
					<c:forEach items="${ALL_CLIENTS}" var="client">
						<tr>
							<td>${client.id} </td>
							<td>${client.firstname}</td>
							<td>${client.lastname}</td>
							<td>${client.sex.label}</td>
							<td>
								<%-- 
									fmt:formatDate richiede un parametro Date, non un LocalDate; per questo 
									motivo, in accordo con la documentazione, ho prima creato una variabile
									parsedDate di tipo Date con fmt:parseDate e quindi la ho formattata.
								--%>
								<fmt:parseDate value="${client.dateOfBirth}" pattern="yyyy-MM-dd" var="parsedDate" type="date"/>
								<fmt:formatDate pattern="dd/MM/yyyy" value="${parsedDate}"></fmt:formatDate>
							</td>
							<td>
							<fmt:formatNumber type="currency" value="${client.deficit}"></fmt:formatNumber>
							</td>
							<td>
							<fmt:formatNumber type="currency" value="${client.maxTotalDeficit}"></fmt:formatNumber>
							</td>
						</tr>				
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
 	</div>
 	
 	<div class="btnback">
 		<a class="menu" id="btnback" href="index.jsp"><--- Torna al menù principale</a>
 	</div>
		
	<%-- 
		1. Riguardarsi con calma l'applicazione
		2. Questa pagina mostra solo i nomi dei clienti senza formatazione, modificarla in modo che mostri 
			invece una tabella stilizzata con CSS che mostri i dati dei clienti (tutti)
		3. Andarsi a studiare una presentazione PowerPoint chiamate "Servlet.ppv" e "JSP.ppv" su discord
	 --%>
	 
	 <%-- 
	 	Modificare questa pagina in modo che crei la tabella non usando lo scriplet ma la tag JSTL c:forEach
		Documentazione: https://jakarta.ee/specifications/tags/3.0/tagdocs/c/tld-summary.html
	 --%>
	 
</body>