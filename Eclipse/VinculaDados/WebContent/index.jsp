
<%-- 
    Document   : index
    Created on : 26/03/2014, 23:16:16
    Author     : Elisabete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos</title>
        <script src="./js/carregarFrame.js"></script>
        <script src="node_modules/jquery/dist/jquery.js"></script>
    </head>
    <body>
        <button onclick="carregarCliente();">Cliente</button>
        <button onclick="carregarItem();">Item</button>
        <button onclick="carregarPedido();">Pedido</button>
        <button onclick="carregarPedidoItem();">PedidoItem</button>
        <button onclick="carregarRelatorio();">Relatorio Pedido Item</button>
        <br>
        <br>
        <iframe id="fraFormulario" width="1250" height="550"></iframe>
    </body>
</html>
