<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="node_modules/bootstrap/dist/css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Cadastrar Novo Bruno Rodrigues</title>
<style type="text/css">
	
</style>
</head>
<body>
	<script>
		$(function() {
	        $('input[name=dataCadastro]').datepicker();
	    });
	</script>
	
	<div class="container">
		<form method="POST" action="BrunoRodriguesController" name="formAddBruno">
			<div class="form-group col-md-2 col-sm-12">
				<label for="codigo">Código </label>
				<input class="form-control" type="text"  readonly="readonly" name="codigo" 
					value="<c:out value="${brunoRodrigues.codigo}"/>"/><br/>
			</div>
			<div class="form-group col-md-10 col-sm-12">
				<label for="nome">Nome </label>
				<input class="form-control" type="text"  name="nome" 
						value="<c:out value="${brunoRodrigues.nome}"/>"/><br/>
			</div>
			<div class="form-group col-md-12 col-sm-12">
				<label for="dataCadastro">Data do Cadastro</label>
				<input class="form-control" type="text" x name="dataCadastro" 
						value="<fmt:formatDate pattern="MM/dd/yyy" value="${brunoRodrigues.dataCadastro}"/>"/><br/>
			<div>
			<input class="btn btn-success" type="submit" value="Cadastrar">
		</form>
	</div>
</body>
</html>