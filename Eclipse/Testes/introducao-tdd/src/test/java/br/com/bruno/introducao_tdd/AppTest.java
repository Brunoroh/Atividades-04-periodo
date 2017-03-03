package br.com.bruno.introducao_tdd;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.bruno.dao.ContaCorrentDao;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{
	
	@Mock
	private ContaCorrentDao dao;
	
	@Before
	public void setUp(){
		
		dao = Mockito.mock(ContaCorrentDao.class);
		
	}
	
	@Test
	public void testeCadastrar(){
		
	}
}
