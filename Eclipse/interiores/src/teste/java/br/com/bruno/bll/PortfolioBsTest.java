package br.com.bruno.bll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.*;
import br.com.bruno.dal.PortfolioDAO;
import br.com.bruno.model.Imagem;
import br.com.bruno.model.Portfolio;
import junit.framework.TestCase;

public class PortfolioBsTest extends TestCase {
	
	@Mock
	PortfolioDAO dao;
	@Mock
	ImagemBs imgBs;
	
	PortfolioBs bs;
	
	Portfolio portfolio;
	
	@Before
	public void setUp(){
		dao = Mockito.mock(PortfolioDAO.class);
		imgBs = Mockito.mock(ImagemBs.class);
		bs = new PortfolioBs(dao,imgBs);
		portfolio = new Portfolio();
		
		portfolio.setCodigo(1);
		portfolio.setCategoria("categoria");
		portfolio.setAmbiente("ambiente");
		portfolio.setDataCadastro(new Date());
		portfolio.setImagem(new Imagem());
		portfolio.setResponsavel("Responsavel");
	}
	
	@Test
	public void	testSalvar() throws Exception{
		Mockito.when(dao.consultarPorResponsavel(portfolio)).thenReturn(portfolio);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		
		Portfolio portfolioTestado = bs.salvar(portfolio);
		assertEquals(portfolio, portfolioTestado);	
	}
	
	@Test
	public void	testSalvarPortfolioNull(){
		try{
			portfolio = null;
			Mockito.when(dao.consultarPorResponsavel(portfolio)).thenReturn(portfolio);
			Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
			
			Portfolio portfolioTestado = bs.salvar(portfolio);
			fail("Não foi disparada a Exceção");
		}catch(Exception e){
			assertThat(e).hasMessage("Objeto portfolio esta null");
		}
	}
	
	@Test
	public void	testSalvarComCategoriaNull(){
		try{
			portfolio.setCategoria(null);
			Mockito.when(dao.consultarPorResponsavel(portfolio)).thenReturn(portfolio);
			Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
			
			Portfolio portfolioTestado = bs.salvar(portfolio);
			fail("Não foi disparada a Exceção");
		}catch(Exception e){
			assertThat(e).hasMessage("A categoria está vazia");
		}
	}
	
	@Test
	public void	testSalvarImagemNull() throws Exception{
			portfolio.setImagem(null);
			Mockito.when(dao.consultarPorResponsavel(portfolio)).thenReturn(portfolio);
			Mockito.when(imgBs.salvar(Mockito.any())).thenReturn(null);
			Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
			
			Portfolio portfolioTestado = bs.salvar(portfolio);
	}
	
	@Test
	public void	testSalvarAmbienteNull() throws Exception{
			portfolio.setAmbiente(null);
			Mockito.when(dao.consultarPorResponsavel(portfolio)).thenReturn(portfolio);
			Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
			
			Portfolio portfolioTestado = bs.salvar(portfolio);
	}
	
	@Test
	public void	testSalvarDataNull() throws Exception{
			portfolio.setDataCadastro(null);
			Mockito.when(dao.consultarPorResponsavel(portfolio)).thenReturn(portfolio);
			Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
			
			Portfolio portfolioTestado = bs.salvar(portfolio);
	}
	
	@Test
	public void	testSalvarResponsavelNull() throws Exception{
			portfolio.setResponsavel(null);
			Mockito.when(dao.consultarPorResponsavel(portfolio)).thenReturn(portfolio);
			Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
			
			Portfolio portfolioTestado = bs.salvar(portfolio);
	}
	
	@Test
	public void testAlterar() throws Exception{
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
