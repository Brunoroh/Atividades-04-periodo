package br.com.bruno.bll;

import java.util.List;

import br.com.bruno.dal.PortfolioDAO;
import br.com.bruno.model.Imagem;
import br.com.bruno.model.Portfolio;

public class PortfolioBs {

	PortfolioDAO dao;

	public PortfolioBs(PortfolioDAO dao) {
		this.dao = dao;
	}

	public PortfolioBs() {
		dao = new PortfolioDAO();
	}

	public Portfolio salvar(Portfolio portfolio) {
		ImagemBs imgBs = new ImagemBs();
		Imagem imagem = imgBs.salvar(portfolio.getImagem());
		portfolio.setImagem(imagem);
		if(portfolio.getCodigo() == 0){
			dao.incluir(portfolio);
		}else{
			dao.alterar(portfolio);
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
	
	
}
