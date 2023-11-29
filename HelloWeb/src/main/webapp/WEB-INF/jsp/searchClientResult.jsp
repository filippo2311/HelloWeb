<jsp:include page="/base.jsp"/>
<%@page import="java.util.Collection"%>
<%@page import="it.talentform.bank.model.Client"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>


<head>
	<title>Risultato ricerca</title>
</head>

<body>
	<h2 class="heading">Risultati ricerca</h2>
	
	<c:choose>
		<c:when test="${empty RESULT_LIST}">
			<h2>Non ci sono clienti registrati</h2>
		</c:when>
		
		<c:otherwise>
			<table>
				<c:forEach items="${RESULT_LIST}" var="client">
				<tr>
					<td>${client.id} </td>
					<td>${client.firstname}</td>
					<td>${client.lastname}</td>
					<td>${client.sex.label}</td>
					<td>
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
			</table>
		</c:otherwise>
	</c:choose>
	
 	<div class="btnback">
 		<a class="menu" id="btnback" href="index.jsp"><--- Torna al menù principale</a>
 	</div>
	
</body>