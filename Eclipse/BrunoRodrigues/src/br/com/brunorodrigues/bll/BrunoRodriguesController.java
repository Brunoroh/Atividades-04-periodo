package br.com.brunorodrigues.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brunorodrigues.dal.BrunoRodriguesDao;
import br.com.brunorodrigues.model.BrunoRodrigues;

@WebServlet("/BrunoRodriguesController")
public class BrunoRodriguesController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static String FORMULARIO = "/brunoRodrigues.jsp";
	private static String LISTAR = "/listar.jsp";
	private BrunoRodriguesDao dao;
	public BrunoRodriguesController(){
		dao = new BrunoRodriguesDao();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forward="";
		String action = req.getParameter("action");
		try {
			if(action.equalsIgnoreCase("listar")){
					forward = LISTAR;
					req.setAttribute("lista", dao.listarTodos());
			}else if(action.equals("alterar")){
				try{
					forward = FORMULARIO;
					int codigo = Integer.parseInt(req.getParameter("codigo"));
					req.setAttribute("brunoRodrigues", dao.consultar(codigo));
				}catch(Exception e){
					e.printStackTrace();
				}
			}else if(action.equals("apagar")){
				forward = LISTAR;
				int codigo = Integer.parseInt(req.getParameter("codigo"));
				dao.remover(codigo);
				req.setAttribute("lista", dao.listarTodos());
				
			}else{
				forward = FORMULARIO;
			}
			
			RequestDispatcher view = req.getRequestDispatcher(forward);
			view.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BrunoRodrigues bruno = new BrunoRodrigues();
		bruno.setNome(req.getParameter("nome"));
		try {
	        Date dataCadastro = new SimpleDateFormat("MM/dd/yyyy").parse(req.getParameter("dataCadastro"));
		    bruno.setDataCadastro(dataCadastro);
		    String codigo = req.getParameter("codigo");
			if("".equals(codigo) || codigo == null){
				dao.incluir(bruno);
			}else{
				bruno.setCodigo(Integer.parseInt(codigo));
				dao.alterar(bruno);
			}
			RequestDispatcher view = req.getRequestDispatcher(LISTAR);
			req.setAttribute("lista", dao.listarTodos());
			view.forward(req, resp);
		} catch (ParseException | SQLException e) {
		    e.printStackTrace();
		}
	}

}
