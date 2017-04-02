<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="node_modules/bootstrap/dist/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projeto Servlet</title>
</head>
<body>
    <form method="POST" action="ServletController">
        <div class="container">

            <div class="row">
                <div class="form-group col-md-12">
                    <label for="dado">Dado :</label>
                    <input type="text" name="dado" id="dado" class="form-control" placeholder="Insira aqui o seu dado" 
                        value="<% out.print(request.getAttribute("novodado"));%>">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="dado2">Dado :</label>
                    <input type="text" name="dado2" id="dado2" class="form-control" placeholder="Insira aqui o seu dado" 
                        value="${novodado}">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="dado2">Dado :</label>
                    <span><c:out value="${novodado}"></span>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <input type="submit" value="Enviar" class="btn btn-primary">
                </div>
            </div>
        
        </div>
    </form>
</body>
</html>