package br.com.bruno.bll;

import java.util.List;

import br.com.bruno.dal.PortfolioDAO;
import br.com.bruno.model.Imagem;
import br.com.bruno.model.Portfolio;

public class PortfolioBs {

	PortfolioDAO dao;

	ImagemBs imgBs = new ImagemBs();
	
	public PortfolioBs(PortfolioDAO dao,ImagemBs imgBs) {
		this.dao = dao;
		this.imgBs = imgBs;
	}

	public PortfolioBs() {
		dao = new PortfolioDAO();
	}

	public Portfolio salvar(Portfolio portfolio) throws Exception {
		if(portfolio != null){
			if(validarPortfolio(portfolio)){
				Imagem imagem = imgBs.salvar(portfolio.getImagem());
				portfolio.setImagem(imagem);
				if(portfolio.getCodigo() == 0){
					dao.incluir(portfolio);
				}else{
					dao.alterar(portfolio);
				}
			}
		}else{
			throw new Exception("Objeto portfolio esta null");
		}
		
		return dao.consultarPorResponsavel(portfolio);
		
	}

	public Portfolio consultar(int codigo) {
		return dao.consultar(codigo);
	}

	public List<Portfolio> listar() {
		return dao.listarTodos();
	}

	public void remover(int codigo) {
		dao.remover(codigo);
	}
	
	private boolean validarPortfolio(Portfolio portfolio) throws Exception{
		
		validarCategoria(portfolio.getCategoria());
		
		return true;
	}

	private boolean validarCategoria(String categoria) throws Exception {

		if("".equals(categoria) || categoria == null){
			throw new Exception("A categoria está vazia");
		}
		
		return true;
	}
	
	
}
