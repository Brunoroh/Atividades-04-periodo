<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mostrar Todos os Bruno Rodrigues</title>
<link rel="stylesheet" type="text/css" href="node_modules/bootstrap/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<table border="1" class="table table-striped col-md-12">
		<thead>
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Data de Cadastro</th>
				<th colspan="2">Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lista}" var="brunoRodrigues">
				<tr>
					<td><c:out value="${brunoRodrigues.codigo}"/></td>
					<td><c:out value="${brunoRodrigues.nome}"/></td>
					<td><c:out value="${brunoRodrigues.dataCadastro}"/></td>
				 	<td><a class="btn btn-primary" href="BrunoRodriguesController?action=alterar&codigo=<c:out value="${brunoRodrigues.codigo}"/>">Alterar</a></td>
                    <td><a class="btn btn-danger" href="BrunoRodriguesController?action=apagar&codigo=<c:out value="${brunoRodrigues.codigo}"/>">Apagar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a class="btn btn-success" href="BrunoRodriguesController?action=cadastrar">Adicionar novo Bruno Rodrigues</a></p>
	</div>
</body>
</html>