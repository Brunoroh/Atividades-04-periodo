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

import br.com.bruno.bll.PortfolioBs;
import br.com.bruno.model.Imagem;
import br.com.bruno.model.Portfolio;

@WebServlet("/PortfolioControl")
public class PortfolioControl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String ERRO = "/erro.jsp";
	private static String CADASTRO = "/cadastroPortfolio.jsp";
	private static String LISTAR = "/listarPortfolio.jsp"; 
	
	PortfolioBs bs;

	public PortfolioControl() {
		this.bs = new PortfolioBs();
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
				req.setAttribute("portfolio", bs.consultar(codigo));
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
		Portfolio portfolio = new Portfolio();
		Imagem imagem = new Imagem();
		try{
			String codigo = req.getParameter("codigo");
			if(codigo.equals("")){
				codigo = "0";
			}
			portfolio.setCodigo(Integer.parseInt(codigo));
			portfolio.setAmbiente(req.getParameter("ambiente"));
			portfolio.setCategoria(req.getParameter("categoria"));
			portfolio.setResponsavel(req.getParameter("responsavel"));
			imagem.setCaminho(req.getParameter("imagem"));
			imagem.setNome(req.getParameter("imagem"));
			portfolio.setImagem(imagem);
			Date dataCadastro = new Date();
			portfolio.setDataCadastro(dataCadastro);
			
			bs.salvar(portfolio);
			
			RequestDispatcher view = req.getRequestDispatcher(LISTAR);
			req.setAttribute("lista", bs.listar());
			view.forward(req, resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
}
