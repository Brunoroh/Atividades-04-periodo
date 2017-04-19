/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.bll;

import br.com.senai.dal.ClienteDal;
import br.com.senai.dal.ItemDal;
import br.com.senai.dal.PedidoDal;
import br.com.senai.dal.PedidoItemDal;
import br.com.senai.model.Cliente;
import br.com.senai.model.Item;
import br.com.senai.model.Pedido;
import br.com.senai.model.PedidoItem;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elisabete
 */

@WebServlet("/PedidoItemBll")
public class PedidoItemBll extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String FORMULARIO = "./PedidoItem.jsp";
    private final String RELATORIO = "./relatorio.jsp";
    private PedidoItemDal pedidoItemDAO;
    private ClienteDal clienteDAO;
    private PedidoDal pedidoDAO;
    private ItemDal itemDAO;

    public PedidoItemBll() {
        super();
        pedidoItemDAO = new PedidoItemDal();
        pedidoDAO = new PedidoDal();
        clienteDAO = new ClienteDal();
        itemDAO = new ItemDal();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String numero = request.getParameter("codpedido");
        String pagina = "";
        if (action.equalsIgnoreCase("remover")){
            int nrpedido = Integer.parseInt(numero);
            int coditem = Integer.parseInt(request.getParameter("coditem"));
            pedidoItemDAO.Remover(nrpedido, coditem);
            Pedido p = pedidoDAO.ConsultarPorCodigo(nrpedido);
            PedidoItem pi = new PedidoItem();
            pi.setPedido(p);
            request.setAttribute("pi", pi);
            pagina = FORMULARIO;
        }else if(action.equalsIgnoreCase("alterar")){
        	int nrpedido = Integer.parseInt(numero);
            int coditem = Integer.parseInt(request.getParameter("coditem"));
            request.setAttribute("pi", pedidoItemDAO.ConsultarPorCodigo(nrpedido, coditem));
            pagina = FORMULARIO;
        }else if(action.equalsIgnoreCase("relatorio")){
        	
        	request.setAttribute("pis", pedidoItemDAO.ConsultarTodos());
        	pagina = RELATORIO;
        }
        if(!(numero == null || numero.isEmpty())){
            request.setAttribute("pis", pedidoItemDAO.ConsultarTodosPorPedido(Integer.parseInt(numero)));
        }
        RequestDispatcher view = request.getRequestDispatcher(pagina);
        request.setAttribute("pis", pedidoItemDAO.ConsultarTodos());
        request.setAttribute("clientes", clienteDAO.ConsultarTodos());
        request.setAttribute("itens", itemDAO.ConsultarTodos());
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object attribute = request.getAttribute("objeto");
        if(request.getParameter("botao").equalsIgnoreCase("Novo")){
            request.setAttribute("pis", pedidoItemDAO.ConsultarTodos());
            RequestDispatcher view = request.getRequestDispatcher(FORMULARIO);
            request.setAttribute("clientes", clienteDAO.ConsultarTodos());
            request.setAttribute("itens", itemDAO.ConsultarTodos());
            view.forward(request, response);
        }
        if(request.getParameter("botao").equalsIgnoreCase("Salvar")){
            Pedido pedido = new Pedido();

            try {
                Date data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data"));
                pedido.setData(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            pedido.getCliente().setCodigo(Integer.parseInt(request.getParameter("codcliente")));

            String numero = request.getParameter("numero");

            if(numero == null || numero.isEmpty()){
                pedido = pedidoDAO.Inserir(pedido);
            }else{
                pedido = pedidoDAO.ConsultarPorCodigo(Integer.parseInt(numero));
            }

            PedidoItem pi = new PedidoItem();
            pi.setPedido(pedido);
            pi.setItem(new Item());

            pi.getPedido().setNumero(pedido.getNumero());
            pi.getItem().setCodigo(Integer.parseInt(request.getParameter("coditem")));
            pi.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
            pi.setValorunitario(Double.parseDouble(request.getParameter("valor")));
            
            pedidoItemDAO.Remover(pi.getPedido().getNumero(), pi.getItem().getCodigo());
            pedidoItemDAO.Inserir(pi);

            pi.setQuantidade(0);
            pi.setValorunitario(0);
            
            RequestDispatcher view = request.getRequestDispatcher(FORMULARIO);
            request.setAttribute("pi", null); 
            request.setAttribute("pis", pedidoItemDAO.ConsultarTodos());
            request.setAttribute("clientes", clienteDAO.ConsultarTodos());
            request.setAttribute("itens", itemDAO.ConsultarTodos());
            view.forward(request, response);
        }
        if(request.getParameter("botao").equalsIgnoreCase("Pesquisar")){
            String numero = request.getParameter("numero");

            if(!(numero == null || numero.isEmpty()))
            {
                RequestDispatcher view = request.getRequestDispatcher(FORMULARIO);
                request.setAttribute("pis", pedidoItemDAO.ConsultarTodosPorPedido(Integer.parseInt(numero)));
                request.setAttribute("clientes", clienteDAO.ConsultarTodos());
                request.setAttribute("itens", itemDAO.ConsultarTodos());
                view.forward(request, response);
            }
        }
        if(request.getParameter("botao").equalsIgnoreCase("Alterar")){
        	int nrPedido = Integer.parseInt(request.getParameter("nrpedido"));
        	int codItem = Integer.parseInt(request.getParameter("coditem"));
        	
        	if(nrPedido != 0 && codItem != 0){
        		pedidoItemDAO.ConsultarPorCodigo(nrPedido, codItem);
        	}
        	
        	Pedido pedido = new Pedido();

            try {
                Date data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data"));
                pedido.setData(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            pedido.getCliente().setCodigo(Integer.parseInt(request.getParameter("codcliente")));

            String numero = request.getParameter("numero");

            if(numero == null || numero.isEmpty()){
                pedido = pedidoDAO.Inserir(pedido);
            }else{
                pedido = pedidoDAO.ConsultarPorCodigo(Integer.parseInt(numero));
            }

            PedidoItem pi = new PedidoItem();
            pi.setPedido(pedido);
            pi.setItem(new Item());

            pi.getPedido().setNumero(pedido.getNumero());
            pi.getItem().setCodigo(Integer.parseInt(request.getParameter("coditem")));
            pi.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
            pi.setValorunitario(Double.parseDouble(request.getParameter("valor")));
            
            pedidoItemDAO.Alterar(pi);
            
            RequestDispatcher view = request.getRequestDispatcher(FORMULARIO);
            request.setAttribute("pi", pi); 
            request.setAttribute("pis", pedidoItemDAO.ConsultarTodos());
            request.setAttribute("clientes", clienteDAO.ConsultarTodos());
            request.setAttribute("itens", itemDAO.ConsultarTodos());
            view.forward(request, response);
        }
    }
}
