package br.com.bruno.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bruno.bll.PropostaBs;
import br.com.bruno.model.Imagem;
import br.com.bruno.model.Proposta;

@WebServlet("/PropostaControl")
public class PropostaControl extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String ERRO = "/erro.jsp";
	private static String PROPOSTA = "/cadastroProposta.jsp";
	private static String LISTAR = "/listarProposta.jsp";
	
	PropostaBs bs;

	public PropostaControl() {
		this.bs = new PropostaBs();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forward = "";
		String action = req.getParameter("action");

		try{
			if(action.equalsIgnoreCase("cadastrar")){
				forward = PROPOSTA;
			}else if(action.equalsIgnoreCase("alterar")){
				forward = PROPOSTA;
				int codigo = Integer.parseInt(req.getParameter("codigo"));
				req.setAttribute("proposta", bs.consultar(codigo));
			}else if(action.equalsIgnoreCase("listar")){
				forward = LISTAR;
				req.setAttribute("lista", bs.listar());
			}else if(action.equalsIgnoreCase("apagar")){
				forward = LISTAR;
				int codigo = Integer.parseInt(req.getParameter("codigo"));
				bs.remover(codigo);
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
		Proposta proposta = new Proposta();
		Imagem imagem = new Imagem();
		try{
			String codigo = req.getParameter("codigo");
			if(codigo.equals("")){
				codigo = "0";
			}
			proposta.setCodigo(Integer.parseInt(codigo));
			proposta.setDescricao(req.getParameter("descricao"));
			proposta.setEmail(req.getParameter("email"));
			imagem.setCaminho(req.getParameter("imagem"));
			imagem.setNome(req.getParameter("imagem"));
			proposta.setImagem(imagem);
			proposta.setNome(req.getParameter("nome"));
			proposta.setTelefone(req.getParameter("telefone"));
			
			bs.salvar(proposta);
			
			RequestDispatcher view = req.getRequestDispatcher(LISTAR);
			req.setAttribute("lista", bs.listar());
			view.forward(req, resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
