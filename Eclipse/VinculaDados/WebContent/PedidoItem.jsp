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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido com Item</title>
        <script src="node_modules/jquery/dist/jquery.js"></script>
        <script src="js/validate.js"></script>      
    </head>
    <body>
        <form id="formulario" method="POST" action='PedidoItemBll' name="frmDadosPI">
            <table>
                <tbody>
                    <tr>
                        <input type="hidden" name="objeto" value="<%= request.getAttribute("pi") %>">
                        <td>Numero:</td>
                        <td> <input type="text" id="numero" name="numero" value="<c:out value="${pi.pedido.numero}" />" /> </td> 
                        <td>Data:</td>
                        <td> <input type="text" name="data" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${pi.pedido.data}" />" /> </td> 
                    </tr>
                    <tr>
                        <td>Cliente:</td>
                        <td colspan="2"> 
                            <select id="codcliente" name ="codcliente" >
                                <c:forEach items="${clientes}" var="cliente">
                                    <option value="<c:out value="${cliente.codigo}"/>" 
                                            ${cliente.codigo ==  pi.pedido.cliente.codigo ? 'selected' : ''}>
                                                   <c:out value="${cliente.nome}"/>
                                    </option >
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Item:</td>
                        <td colspan = "2"> 
                            <select id="coditem" name ="coditem" >
                                <c:forEach items="${itens}" var="item">
                                    <option value="<c:out value="${item.codigo}"/>" 
                                            ${item.codigo ==  pi.item.codigo ? 'selected' : ''}>
                                                   <c:out value="${item.descricao}"/>
                                    </option >
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Quantidade:</td>
                        <td> <input type="text" name="quantidade" onkeypress="return event.charCode >= 48 && event.charCode <= 57" value="<c:out value="${pi.quantidade}" />" /> </td> 
                        <td>Valor Unitário:</td>
                        <td> <input type="text" onkeypress="return event.charCode >= 48 && event.charCode <= 57" name="valor" value="<c:out value="${pi.valorunitario}" />" /> </td> 
                    </tr>
                </tbody>
            </table>
            <br>
            <input type="submit" value="Novo" name="botao" />
            <input type="submit" value="Salvar" id="salvar" name="botao" />
            <input type="submit" value="Pesquisar" name="botao" />
            <br>
            <br>
        </form>
        <form method="GET" action='PedidoItemBll' name="frmTabelaPI">
            <table border=1>
                <thead>
                    <tr>
                        <th>Nr. Pedido</th>
                        <th>Código Item</th>
                        <th>Descrição do Item</th>
                        <th>Quantidade</th>
                        <th>Valor Unitário</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pis}" var="pi">
                        <tr>
                            <td><c:out value="${pi.pedido.numero}" /></td>
                            <td><c:out value="${pi.item.codigo}" /></td>
                            <td><c:out value="${pi.item.descricao}" /> </td>
                            <td><c:out value="${pi.quantidade}" /> </td>
                            <td><c:out value="${pi.valorunitario}" /></td>
                            <td><a href="PedidoItemBll?action=remover&codpedido=<c:out value="${pi.pedido.numero}"/>&coditem=<c:out value="${pi.item.codigo}"/>">Remover</a></td>
                            <td><a href="PedidoItemBll?action=alterar&codpedido=<c:out value="${pi.pedido.numero}"/>&coditem=<c:out value="${pi.item.codigo}"/>">Alterar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </body>
</html>
