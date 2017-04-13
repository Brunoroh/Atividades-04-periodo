package br.com.bruno.bll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.bruno.dal.PortfolioDAO;
import br.com.bruno.model.Cliente;
import br.com.bruno.model.Imagem;
import br.com.bruno.model.Portfolio;
import junit.framework.TestCase;

public class PortfolioBsTest extends TestCase {
	
	@Mock
	PortfolioDAO dao;
	
	PortfolioBs bs;
	
	Portfolio portfolio;
	
	@Before
	public void setUp(){
		dao = Mockito.mock(PortfolioDAO.class);
		bs = new PortfolioBs(dao);
		portfolio = new Portfolio();
		
		portfolio.setCodigo(1);
		portfolio.setCategoria("categoria");
		portfolio.setAmbiente("ambiente");
		portfolio.setDataCadastro(new Date());
		portfolio.setImagem(new Imagem());
		portfolio.setResponsavel("Responsavel");
	}
	
	@Test
	public void	testSalvar(){
		Mockito.when(dao.consultarPorResponsavel(portfolio)).thenReturn(portfolio);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		
		Portfolio portfolioTestado = bs.salvar(portfolio);
		assertEquals(portfolio, portfolioTestado);	
	}
	
	@Test
	public void testAlterar(){
		portfolio.setCodigo(1);
		Mockito.when(dao.consultarPorResponsavel(portfolio)).thenReturn(portfolio);
		Mockito.when(dao.alterar(Mockito.any())).thenReturn(true);
		
		Portfolio portfolioTestado = bs.salvar(portfolio);
		assertEquals(portfolio, portfolioTestado);	
	}
	
	@Test
	public void testConsultar(){
		portfolio.setCodigo(1);
		
		Mockito.when(dao.consultar(1)).thenReturn(portfolio);
		
		Portfolio portfolioTestado = bs.consultar(portfolio.getCodigo());
		assertEquals(portfolio, portfolioTestado);
	}
	
	@Test
	public void testListar(){
		List<Portfolio> portfolios = new ArrayList<Portfolio>();
		portfolios.add(portfolio);
		portfolios.add(portfolio);
		
		Mockito.when(dao.listarTodos()).thenReturn(portfolios);
		List<Portfolio> portfolioTestado = bs.listar();
		assertEquals(portfolios, portfolioTestado);
	}
	
}
