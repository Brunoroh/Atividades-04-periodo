package br.com.bruno.bll;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.bruno.dal.ImagemDAO;
import br.com.bruno.model.Imagem;
import junit.framework.TestCase;

public class ImagemBsTest extends TestCase {

	@Mock
	ImagemDAO dao;
	
	ImagemBs bs;
	Imagem imagem;
	
	@Before
	public void setUp(){
		dao = Mockito.mock(ImagemDAO.class);
		bs = new ImagemBs();
		
		imagem = new Imagem();
		
		imagem.setCaminho("/home/brunoroh/Documents/Workspace/Faculdade/Eclipse/interiores/src/main/java/br/com/bruno/images");
		imagem.setNome("imagem");
	}
	
	@Test
	public void testSalvar(){
		Mockito.when(dao.consultarPorNome(imagem.getNome())).thenReturn(imagem);
		Mockito.when(dao.incluir(imagem)).thenReturn(true);
		
		Imagem imagemTestada = bs.salvar(imagem);
		assertEquals(imagem,imagemTestada);
	}
	
	@Test
	public void testAlterar(){
		imagem.setCodigo(1);
		Mockito.when(dao.consultarPorNome(imagem.getNome())).thenReturn(imagem);
		Mockito.when(dao.alterar(imagem)).thenReturn(true);
		
		Imagem imagemTestada = bs.salvar(imagem);
		assertEquals(imagem,imagemTestada);
	}
	
	@Test
	public void testConsultar(){
		imagem.setCodigo(1);
		Mockito.when(dao.consultar(1)).thenReturn(imagem);
		
		Imagem imagemTestada = bs.consultar(1);
		assertEquals(imagem,imagemTestada);
	}
	
	@Test
	public void testListar(){
		List<Imagem> lista = new ArrayList<Imagem>();
		lista.add(imagem);
		lista.add(imagem);
		
		Mockito.when(dao.listarTodos()).thenReturn(lista);

		List<Imagem> listaTestada = bs.listar();
		assertEquals(lista,listaTestada);
	}
	
	
}
