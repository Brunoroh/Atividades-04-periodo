package br.com.bruno.bll;

import static org.assertj.core.api.Assertions.assertThat;

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
	public void testSalvar() throws Exception{
		Mockito.when(dao.consultarPorResponsavelEDescricao(proposta)).thenReturn(proposta);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		
		Proposta propostaTestada = bs.salvar(proposta);
		assertEquals(proposta, propostaTestada);	
	}
	
	@Test
	public void testSalvarNull() throws Exception{
		proposta = null;
		Mockito.when(dao.consultarPorResponsavelEDescricao(null)).thenReturn(null);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		
		Proposta propostaTestada = bs.salvar(proposta);
		assertEquals(proposta, propostaTestada);	
	}
	
	@Test
	public void testSalvarNomeNull(){
		try{
			proposta.setNome(null);
			Mockito.when(dao.consultarPorResponsavelEDescricao(null)).thenReturn(null);
			Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
			
			Proposta propostaTestada = bs.salvar(proposta);
		}catch(Exception e){
			assertThat(e).hasMessage("O Nome está vazio");
		}
	}
	
	@Test
	public void testSalvarTelefoneNull() throws Exception{
		proposta.setTelefone(null);
		Mockito.when(dao.consultarPorResponsavelEDescricao(Mockito.any())).thenReturn(proposta);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		
		Proposta propostaTestada = bs.salvar(proposta);
		assertEquals(proposta, propostaTestada);	
	}
	
	@Test
	public void testSalvarEmailNull() throws Exception{
		proposta.setEmail(null);
		Mockito.when(dao.consultarPorResponsavelEDescricao(Mockito.any())).thenReturn(proposta);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		
		Proposta propostaTestada = bs.salvar(proposta);
		assertEquals(proposta, propostaTestada);	
	}
	
	@Test
	public void testSalvarDescricaoNull(){
		try{
			proposta.setDescricao(null);
			Mockito.when(dao.consultarPorResponsavelEDescricao(null)).thenReturn(proposta);
			Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
			
			Proposta propostaTestada = bs.salvar(proposta);
		}catch(Exception e){
			assertThat(e).hasMessage("A Descrição está vazia");
		}
	}
	
	@Test
	public void testSalvarImagemNull() throws Exception{
		proposta.setImagem(null);
		Mockito.when(dao.consultarPorResponsavelEDescricao(Mockito.any())).thenReturn(proposta);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		Mockito.when(imgBs.salvar(imagem)).thenReturn(null);
		Proposta propostaTestada = bs.salvar(proposta);
		assertEquals(proposta, propostaTestada);	
	}
	
	@Test
	public void testAlterar() throws Exception{
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
