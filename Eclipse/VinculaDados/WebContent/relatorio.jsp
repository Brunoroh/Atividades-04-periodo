<%-- 
    Document   : Pedido
    Created on : 27/03/2014, 09:35:06
    Author     : Elisabete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
    	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" ref="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio de Pedidos</title>      
    </head>
    <body>
            <table class="table table-stripped">
                <thead>
                    <tr>
                        <th>Nr. Pedido</th>
                        <th>Data do Pedido</th>
                        <th>Nome do Cliente</th>
                        <th>CPF do Cliente</th>
                        <th>Telefone do Cliente</th>
                        <th>Endereco do Cliente</th>
                        <th>Codigo do Item</th>
                        <th>Descrição do Item</th>
                        <th>Quantidade</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pis}" var="pi">
                        <tr>
                            <td><c:out value="${pi.pedido.numero}" /></td>
                            <td><fmt:formatDate value="${pi.pedido.data}" pattern="dd/MM/yyyy"/></td>
                            <td><c:out value="${pi.pedido.cliente.nome}" /></td>
                            <td><c:out value="${pi.pedido.cliente.cpf}" /></td>
                            <td><c:out value="${pi.pedido.cliente.telefone}" /></td>
                            <td><c:out value="${pi.pedido.cliente.endereco}" /></td>
                            <td><c:out value="${pi.item.codigo}" /></td>
                            <td><c:out value="${pi.item.descricao}" /> </td>
                            <td><c:out value="${pi.quantidade}" /> </td>
                            <td><c:out value="${pi.valorunitario}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
    </body>
</html>
