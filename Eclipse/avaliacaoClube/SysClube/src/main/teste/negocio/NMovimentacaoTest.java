package negocio;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import entidade.EAssociado;
import entidade.EMovimentacao;
import junit.framework.TestCase;
import persistencia.PMovimentacao;

public class NMovimentacaoTest extends TestCase {
	
	@Mock
	PMovimentacao dao;
	
	EAssociado associado;
	NMovimentacao negocio;
	EMovimentacao entidade;
	EMovimentacao retorno;
	
	@Before
	public void setUp(){
		dao = Mockito.mock(PMovimentacao.class);
		entidade = new EMovimentacao();
		retorno = new EMovimentacao();
		negocio = new NMovimentacao(dao);
		associado = new EAssociado();
		
		associado.setCodigo(1);
		associado.setNome("Bruno");
		associado.setUsuario("bruno.rodrigues");
		associado.setSenha("12345678");
		
		entidade.setCodigo(1);
		entidade.setAssociado(associado);
		entidade.setHoraEntrada(new Date());
		entidade.setHoraSaida(new Date());
		
		retorno.setCodigo(1);
		retorno.setAssociado(associado);
		retorno.setHoraEntrada(new Date());
		retorno.setHoraSaida(new Date());
	}
	
	@Test
	public void testRegistrarNovaMovimentacao(){
		entidade.setCodigo(0);
		
		Mockito.when(dao.incluir(entidade)).thenReturn(true);
		boolean objetoTestado = negocio.registrarMovimentacao(entidade);
		assertTrue(objetoTestado);
	}
	
	@Test
	public void testRegistrarNovaMovimentacaoNula(){
		entidade = null;
		
		boolean objetoTestado = negocio.registrarMovimentacao(entidade);
		assertFalse(objetoTestado);
	}
	
	@Test
	public void testRegistrarMovimentacaoExistente(){
		
		Mockito.when(dao.alterar(entidade)).thenReturn(true);
		boolean objetoTestado = negocio.registrarMovimentacao(entidade);
		assertTrue(objetoTestado);
	}
	
	@Test
	public void testRegistrarMovimentacaoNull(){
		entidade = null;
		
		Mockito.when(dao.alterar(entidade)).thenReturn(false);
		boolean objetoTestado = negocio.registrarMovimentacao(entidade);
		assertFalse(objetoTestado);
	}
}
