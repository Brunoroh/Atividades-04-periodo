<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Proposta - Design Interiores</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/business-casual.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
</head>
<body>

    <div class="brand">Design Interiores</div>
    <div class="address-bar">Projeto da N1 | Desenvolvimento de Sistemas Web com Banco de Dados </div>

    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Design Interiores</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="index.jsp">Home</a>
                    </li>
                    <li>
                        <a href="PortfolioControl?action=cadastrar">Portfolio</a>
                    </li>
                    <li>
                        <a href="PropostaControl?action=cadastrar">Proposta</a>
                    </li>
                    <li>
                        <a href="ClienteControl?action=cadastrar">Clientes</a>
                    </li>
                    <li>
                        <a href="definirPersona.jsp">Decoração Ideal</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">

        <div class="row">
            <c:forEach items="${lista}" var="proposta">
		        <div class="row">
		            <div class="box">
		                <div class="col-lg-12 text-center">
		                    <h2 class="brand-before">
		                        <small>Proposta de</small>
		                    </h2>
		                    <h1 class="brand-name"><c:out value="${proposta.nome}"/></h1>
		                    <hr class="tagline-divider">
		                 	<div class="col-lg-12">
			                	<img src="<c:out value="${proposta.imagem.caminho}"/>">
			                </div>
			                <ul type="none">
			                 	<li><strong>Email     : </strong><c:out value="${proposta.email}"/></li>
			                 	<li><strong>Telefone   : </strong><c:out value="${proposta.telefone}"/></li>
			                 	<li><strong>Descrição : </strong><c:out value="${proposta.descricao}"/></li>
			                </ul>
		                </div>
		                <br/>
		                <div style="text-align: center;">
			                <a style="margin-top: 10px;" class="btn btn-success" href="PropostaControl?action=alterar&codigo=<c:out value="${proposta.codigo}"/>">Alterar</a>
			                <a style="margin-top: 10px;" class="btn btn-danger" href="PropostaControl?action=apagar&codigo=<c:out value="${proposta.codigo}"/>">Apagar</a>
		            	</div>
		            </div>
		        </div>
			</c:forEach>
        </div>

    </div>

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Bruno Rodrigues</p>
                </div>
            </div>
        </div>
    </footer>

    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
