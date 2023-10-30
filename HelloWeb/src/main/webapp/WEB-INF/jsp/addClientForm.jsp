<%@page import="it.talentform.bank.model.Sex"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserimento nuovo cliente</title>
</head>
<body>
	<h2>Inserisci nuovo cliente</h2>
	<form method="get" action="saveclient.do">
		<input type="text" name="firstname" placeholder="Nome"> 
		<input type="text" name="lastname" placeholder="Cognome"> 
		<label for="gender">Genere</label>
		<select id="gender" name="gender">
			<% 
				for (Sex s : Sex.values()){
			%>	
		
			<option value="<%=s.initial%>"><%=s.label%></option>
		
			<%}%>
		</select>
		<label for="birthdate">Data di nascita</label>
		<input type="date" id="birthdate" name="birthdate" placeholder="Data di nascita"> 
		<input type="number" step="0.01" name="deficit" placeholder="Deficit"> 
		<input type="number" step="0.01" name="maxDeficit" placeholder="Max deficit"> 
		<input type="submit" value="Crea cliente">
	</form>
</body>
</html>