package negocio;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import entidade.EAssociado;
import junit.framework.TestCase;
import persistencia.PAssociado;

public class NAssociadoTest extends TestCase {
	
	@Mock
	PAssociado dao;
	@Mock
	NMensalidade nMensalidade;
	NAssociado negocio;
	EAssociado entidade;
	EAssociado retorno;
	
	@Before
	public void setUp(){
		dao = Mockito.mock(PAssociado.class);
		entidade = new EAssociado();
		retorno = new EAssociado();
		negocio = new NAssociado(dao,nMensalidade);
		
		entidade.setCodigo(1);
		entidade.setNome("Bruno");
		entidade.setUsuario("bruno.rodrigues");
		entidade.setSenha("12345678");
		
		retorno.setCodigo(1);
		retorno.setNome("Bruno");
		retorno.setUsuario("bruno.rodrigues");
		retorno.setSenha("12345678");
	}
	
	@Test
	public void testAutenticarUsuarioESenhaValidos(){

		Mockito.when(dao.consultarPorUsuario(entidade.getUsuario())).thenReturn(retorno);
		boolean objetoTestado = negocio.autenticar(entidade);
		assertTrue(objetoTestado);
	}
	
	@Test
	public void testAutenticarSenhaIncorreta(){
		entidade.setSenha("87654321");
		Mockito.when(dao.consultarPorUsuario(entidade.getUsuario())).thenReturn(retorno);
		boolean objetoTestado = negocio.autenticar(entidade);
		assertFalse(objetoTestado);
	}
	
	@Test
	public void testAutenticarUsuarioInvalido(){
		Mockito.when(dao.consultarPorUsuario(entidade.getUsuario())).thenReturn(null);
		boolean objetoTestado = negocio.autenticar(entidade);
		assertFalse(objetoTestado);
	}
	
	@Test
	public void testAutenticarUsuarioNull(){
		entidade.setUsuario(null);
		Mockito.when(dao.consultarPorUsuario(entidade.getUsuario())).thenReturn(null);
		boolean objetoTestado = negocio.autenticar(entidade);
		assertFalse(objetoTestado);
	}
	
	@Test
	public void testAutenticarSenhaNull(){
		entidade.setSenha(null);
		Mockito.when(dao.consultarPorUsuario(entidade.getUsuario())).thenReturn(null);
		boolean objetoTestado = negocio.autenticar(entidade);
		assertFalse(objetoTestado);
	}
	
	@Test
	public void testAutenticarUsuarioESenhaNull(){
		entidade.setSenha(null);
		entidade.setUsuario(null);
		Mockito.when(dao.consultarPorUsuario(entidade.getUsuario())).thenReturn(null);
		boolean objetoTestado = negocio.autenticar(entidade);
		assertFalse(objetoTestado);
	}
}
