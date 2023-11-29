<%@ page language="java" contentType="text/html; 
charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/css/style.css"%></style>
	<title>Benvenuti nella gestione della nostra banca</title>
</head>

<body>

	<header>
		<h1>Banca Cayman <img id="logo" src="static/logo.png"></h1>
	</header>
	
	<div class="nav">
		<a href="showClients.do" class="menu">Vai alla lista utenti</a>
		<a href="addClient.do" class="menu">Crea un nuovo cliente</a>
		<a href="searchClient.do" class="menu">Ricerca un cliente</a>
		<a href="modifyClient" class="menu">Modifica un cliente</a>
		<a href="" class="menu">Elimina un cliente</a>		
	</div>

	<div class="bg">
		<img src="static/palme.png" id="palme">
		<img src="static/banca.png" id="banca">
		<img src="static/soldi.png" id="soldi">
		<img src="static/manette.png" id="manette">
	</div>

</body>
</html>