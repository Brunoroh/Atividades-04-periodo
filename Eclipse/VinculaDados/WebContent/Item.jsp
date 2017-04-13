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
        <title>Item</title>
    </head>
    <body>
        <form method="POST" action='ItemBll' name="frmDadosItem">
            <table>
                <tbody>
                    <tr>
                        <td>Codigo:</td>
                        <td> <input type="text" readonly="readonly" name="codigo" value="<c:out value="${item.codigo}" />" /> </td> 
                    </tr>
                    <tr>
                        <td>Descrição:</td>
                        <td> <input type="text" name="descricao" value="<c:out value="${item.descricao}" />" /> </td> 
                    </tr>
                </tbody>
            </table>
            <br>
            <input type="submit" value="Gravar" />
            <br>
            <br>
        </form>
        <form method="GET" action='ItemBll' name="frmTabelaItem">
            <table border=1>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Descrição</th>
                        <th colspan=2>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${itens}" var="item">
                        <tr>
                            <td><c:out value="${item.codigo}" /></td>
                            <td><c:out value="${item.descricao}" /></td>
                            <td><a href="ItemBll?action=alterar&codigo=<c:out value="${item.codigo}"/>">Alterar</a></td>
                            <td><a href="ItemBll?action=remover&codigo=<c:out value="${item.codigo}"/>">Remover</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>  
    </body>
</html>