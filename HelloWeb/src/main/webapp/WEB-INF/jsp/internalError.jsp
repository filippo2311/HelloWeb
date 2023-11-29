<jsp:include page="/base.jsp"/>

<head>
	<title>Errore di sistema</title>
</head>

<body>
	<p class="heading">
		<%
			Object obj = request.getAttribute("EXCEPTION");
			Exception e = (Exception) obj;
			String message = e.getMessage();
		%>
		<br><br>
		Ci scusiamo ma c'è stato un errore nel sistema.
		<br><br>
		Segnalare all'amministratore l'errore: <%= message %>.
	</p>
	
	
	 <a class="menu" id="btnback" href="index.jsp"><--- Torna al menù principale</a>
</body>