<jsp:include page="/base.jsp"/>

<head>
	<title>Ricerca cliente</title>
</head>

<body>

	<div class="form">
		<h2 class="heading">Ricerca cliente</h2>
	
		<form method="get" action="searchClientResult.do">
			<label for="wordToSearch">Inserire nome o cognome</label>
			<input class="field" type="text" name="wordToSearch"> 
			<br>
			<input class="menu" id="btnconfirm" type="submit" value="Cerca">
		</form>
	</div>
			
 	<div class="btnback">
 		<a class="menu" id="btnback" href="index.jsp"><--- Torna al menù principale</a>
 	</div>
</body>