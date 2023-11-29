<jsp:include page="/base.jsp"/>
<%@page import="it.talentform.bank.model.Sex"%>

<head>
	<title>Modifica cliente</title>
</head>

<body>
	<h2 class="heading">Modifica cliente</h2>
	
	<div class="form">
		<form method="get" action="saveclient.do">
			<input class="field" type="text" name="id"> 
			<input class="menu" id="btnconfirm" type="submit" value="Crea cliente">
		</form>
	</div>
	<div class="form">
		<form method="get" action="saveclient.do">
			<label class="field" for="firstname">Nome</label>
			<input class="field" type="text" name="firstname"> 
			<label class="field" for="lastname">Cognome</label>
			<input class="field" type="text" name="lastname"> 
			<br>
			<label class="field" for="gender">Genere</label>
			<select class="field" id="gender" name="gender">
				<option class="field" value="Seleziona"></option>
				<%for (Sex s : Sex.values()){%>	
				<option class="field" value="<%=s.initial%>"><%=s.label%></option>
				<%}%>
			</select>
			<label class="field" for="birthdate">Data di nascita</label>
			<input class="field" type="date" id="birthdate" name="birthdate" placeholder="Data di nascita"> 
			<br>
			<label class="field" for="deficit">Deficit unitario</label>
			<input class="field" type="number" step="0.01" name="deficit"> 
			<label class="field" for="maxDeficit">Deficit complessivo</label>
			<input class="field" type="number" step="0.01" name="maxDeficit"> 
			<br>
			<input class="menu" id="btnconfirm" type="submit" value="Crea cliente">
		</form>
	</div>
	
 	<div class="btnback">
 		<a class="menu" id="btnback" href="index.jsp"><--- Torna al menù principale</a>
 	</div>
	 
</body>