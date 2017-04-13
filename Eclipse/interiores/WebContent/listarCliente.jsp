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
    <title>Cliente - Design Interiores</title>
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
                        <small>Listagem</small>
                    </h2>
                    <h1 class="brand-name">Clientes</h1>
                    <hr class="tagline-divider">
                </div>
                <div class="container table-responsive">
					<table class="table table-striped col-md-12">
						<thead class="thead-inverse">
							<tr>
								<th>Código</th>
								<th>Nome</th>
								<th>CPF</th>
								<th>D. Nascimento</th>
								<th>Email</th>
								<th>Telefone</th>
								<th colspan="2" style="text-align: center;">Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lista}" var="cliente">
								<tr>
									<td><c:out value="${cliente.codigo}"/></td>
									<td><c:out value="${cliente.nome}"/></td>
									<td><c:out value="${cliente.cpf}"/></td>
									<td><fmt:formatDate value="${cliente.dataNascimento}" pattern="dd/MM/yyyy"/></td>
									<td><c:out value="${cliente.email}"/></td>
									<td><c:out value="${cliente.telefone}"/></td>
								 	<td><a class="btn btn-success" href="ClienteControl?action=alterar&codigo=<c:out value="${cliente.codigo}"/>">Alterar</a></td>
				                    <td><a class="btn btn-danger" href="ClienteControl?action=apagar&codigo=<c:out value="${cliente.codigo}"/>">Apagar</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<p><a class="btn btn-success" href="ClienteControl?action=cadastrar">Adicionar Novo Cliente</a></p>
				</div>
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
