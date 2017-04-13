<%-- 
    Document   : Cliente
    Created on : 27/03/2014, 09:30:23
    Author     : Elisabete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
    </head>
    <body>
        <form method="POST" action='ClienteBll' name="frmDadosCliente">
            <table>
                <tbody>
                    <tr>
                        <td>Codigo:</td>
                        <td> <input type="text" readonly="readonly" name="codigo" value="<c:out value="${cliente.codigo}" />" /> </td> 
                    </tr>
                    <tr>
                        <td>Nome:</td>
                        <td> <input type="text" name="nome" value="<c:out value="${cliente.nome}" />" /> </td> 
                    </tr>
                    <tr>
                        <td>CPF:</td>
                        <td> <input type="text" name="cpf" value="<c:out value="${cliente.cpf}" />" /> </td> 
                    </tr>
                    <tr>
                        <td>Telefone:</td>
                        <td> <input type="text" name="telefone" value="<c:out value="${cliente.telefone}" />" /> </td>  
                    </tr>
                    <tr>
                        <td>Endereço:</td>
                        <td> <input type="text" name="endereco" value="<c:out value="${cliente.endereco}" />" /> </td> 
                    </tr>
                </tbody>
            </table>
            <br>
            <input type="submit" value="Gravar" />
            <br>
            <br>
        </form>
        <form method="GET" action='ClienteBll' name="frmTabelaCliente">
            <table border=1>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Telefone</th>
                        <th>Endereço</th>
                        <th colspan=2>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${clientes}" var="cliente">
                        <tr>
                            <td><c:out value="${cliente.codigo}" /></td>
                            <td><c:out value="${cliente.nome}" /></td>
                            <td><c:out value="${cliente.cpf}" /></td>
                            <td><c:out value="${cliente.telefone}" /></td>
                            <td><c:out value="${cliente.endereco}" /></td>
                            <td><a href="ClienteBll?action=alterar&codigo=<c:out value="${cliente.codigo}"/>">Alterar</a></td>
                            <td><a href="ClienteBll?action=remover&codigo=<c:out value="${cliente.codigo}"/>">Remover</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>  
    </body>
</html>
