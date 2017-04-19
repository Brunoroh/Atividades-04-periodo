package br.com.bruno.bll;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.bruno.dal.PropostaDAO;
import br.com.bruno.model.Imagem;
import br.com.bruno.model.Proposta;
import junit.framework.TestCase;

public class PropostaBsTest extends TestCase{

	@Mock
	PropostaDAO dao;
	@Mock
	ImagemBs imgBs;
	
	PropostaBs bs;
	Imagem imagem;
	Proposta proposta;
	
	@Before
	public void setUp(){
		dao = Mockito.mock(PropostaDAO.class);
		imgBs = Mockito.mock(ImagemBs.class);
		bs = new PropostaBs(dao,imgBs);
		proposta = new Proposta();
		imagem = new Imagem();
		
		proposta.setImagem(imagem);
		proposta.setDescricao("Descricao");
		proposta.setEmail("bruno@teste.com.br");
		proposta.setNome("nome");
		proposta.setTelefone("6298122-0000");
		
	}
	
	@Test
	public void testSalvar(){
		Mockito.when(dao.consultarPorResponsavelEDescricao(proposta)).thenReturn(proposta);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		
		Proposta propostaTestada = bs.salvar(proposta);
		assertEquals(proposta, propostaTestada);	
	}
	
	@Test
	public void testSalvarNull(){
		proposta = null;
		Mockito.when(dao.consultarPorResponsavelEDescricao(null)).thenReturn(null);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		
		Proposta propostaTestada = bs.salvar(proposta);
		assertEquals(proposta, propostaTestada);	
	}
	
	@Test
	public void testSalvarNomeNull(){
		proposta.setNome(null);
		Mockito.when(dao.consultarPorResponsavelEDescricao(null)).thenReturn(null);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		
		Proposta propostaTestada = bs.salvar(proposta);
		assertEquals(proposta, propostaTestada);	
	}
	
	@Test
	public void testSalvarNomeNull(){
		proposta.setNome(null);
		Mockito.when(dao.consultarPorResponsavelEDescricao(null)).thenReturn(null);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		
		Proposta propostaTestada = bs.salvar(proposta);
		assertEquals(proposta, propostaTestada);	
	}
	
	@Test
	public void testAlterar(){
		proposta.setCodigo(1);
		Mockito.when(dao.consultarPorResponsavelEDescricao(proposta)).thenReturn(proposta);
		Mockito.when(dao.alterar(Mockito.any())).thenReturn(true);
		Mockito.when(imgBs.salvar(Mockito.any())).thenReturn(null);
		Proposta propostaTestada = bs.salvar(proposta);
		assertEquals(proposta, propostaTestada);	
	}
	
	@Test
	public void testConsultar(){
		proposta.setCodigo(1);
		
		Mockito.when(dao.consultar(1)).thenReturn(proposta);
		
		Proposta propostaTestada = bs.consultar(proposta.getCodigo());
		assertEquals(proposta, propostaTestada);
	}
	
	@Test
	public void testListar(){
		List<Proposta> propostas = new ArrayList<Proposta>();
		propostas.add(proposta);
		propostas.add(proposta);
		
		Mockito.when(dao.listarTodos()).thenReturn(propostas);
		List<Proposta> propostaTestada = bs.listar();
		assertEquals(propostas, propostaTestada);
	}
	
}
