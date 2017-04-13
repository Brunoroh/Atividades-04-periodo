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
    <title>Portfolio - Design Interiores</title>
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
            <div class="box">
                <div class="col-lg-12 text-center">
                    <h2 class="brand-before">
                        <small>Cadastrar</small>
                    </h2>
                    <h1 class="brand-name">Portfolio</h1>
                    <hr class="tagline-divider">
                </div>
                <form action="PortfolioControl" method="POST">
                	<input type="text" class="hide" name="codigo" id="codigo" value="<c:out value="${portfolio.codigo}"/>">
	               	<div class="form-group col-lg-6">
	                    <label for="ambiente">Ambiente</label>
	                    <input class="form-control" type="text" name="ambiente" id="ambiente" placeholder="Ambiente Decorado" value="<c:out value="${portfolio.ambiente}"/>"/>
	                </div>
	                <div class="form-group col-lg-6">
	                    <label for="categoria">Categoria</label>
	                    <input class="form-control" type="text" name="categoria" id="categoria" placeholder="Categoria de Ambiente" value="<c:out value="${portfolio.categoria}"/>"/>
	                </div>
	                <div class="form-group col-lg-12">
	                    <label for="responsavel">Responsável</label>
	                    <input class="form-control" type="text" name="responsavel" id="responsavel" placeholder="Responsável Pelo Design" value="<c:out value="${portfolio.responsavel}"/>"/>
	                </div>
	                <div class="form-group col-lg-12 ">
	                    <label for="imagem">Endereco da Imagem</label>
	                    <input class="form-control" type="text" name="imagem" id="imagem" placeholder="Cole aqui a URL da imagem" value="<c:out value="${portfolio.imagem.caminho}"/>"/>
	                </div>
                    <input class="btn btn-success" type="submit" value="Salvar" style="margin-left: 15px;">
                </form>
            </div>
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
