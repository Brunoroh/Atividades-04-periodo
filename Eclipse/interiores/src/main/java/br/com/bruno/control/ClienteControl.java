package br.com.bruno.control;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bruno.bll.ClienteBs;
import br.com.bruno.model.Cliente;

@WebServlet("/ClienteControl")
public class ClienteControl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String ERRO = "/erro.jsp";
	private static String CADASTRO = "/cadastroCliente.jsp";
	private static String LISTAR = "/listarCliente.jsp";
	ClienteBs bs;

	public ClienteControl() {
		this.bs = new ClienteBs();
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forward = "";
		String action = req.getParameter("action");
		
		try{
			if(action.equalsIgnoreCase("cadastrar")){
				forward = CADASTRO;
			}else if(action.equalsIgnoreCase("alterar")){
				forward = CADASTRO;
				int codigo = Integer.parseInt(req.getParameter("codigo"));
				req.setAttribute("cliente", bs.consultar(codigo));
			}else if(action.equalsIgnoreCase("listar")){
				forward = LISTAR;
				req.setAttribute("lista", bs.listar());
			}else if(action.equalsIgnoreCase("apagar")){
				forward = LISTAR;
				int codigo = Integer.parseInt(req.getParameter("codigo"));
				bs.remove(codigo);
				req.setAttribute("lista", bs.listar());
			}else{
				forward = ERRO;
			}
			
		}catch(Exception e){
			System.out.println("Erro : "+e.getMessage());
		}
		RequestDispatcher view = req.getRequestDispatcher(forward);
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		try{
			String codigo = req.getParameter("codigo");
			if(codigo.equals("")){
				codigo = "0";
			}
			cliente.setCodigo(Integer.parseInt(codigo));
			cliente.setNome(req.getParameter("nome"));
			cliente.setCpf(req.getParameter("cpf"));
			cliente.setRg(req.getParameter("rg"));
			DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
			String dateAsString = req.getParameter("dtNascimento");
			Date date = sourceFormat.parse(dateAsString);
			
			cliente.setDataNascimento(date);
			cliente.setEmail(req.getParameter("email"));
			cliente.setTelefone(req.getParameter("telefone"));
			cliente.setEndereco(req.getParameter("endereco"));
			
			bs.salvar(cliente);
			
			RequestDispatcher view = req.getRequestDispatcher(LISTAR);
			req.setAttribute("lista", bs.listar());
			view.forward(req, resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
