package entidade;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.TestCase;

public class EContaCorrenteTest extends TestCase {

	EContaCorrente conta;
	Double saldo;
	
	@Before
	public void setUp(){
		conta = new EContaCorrente();
		saldo = (double)0;
	}
	
	
	@Test
	public void testCasoDeTeste01_CriarContaComSaldo_0(){
		Double resultadoEsperado = conta.getSaldoAtual();
		assertEquals(saldo,resultadoEsperado);
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testCasoDeTeste02_CriarContaComSaldoNulo(){
		conta.setSaldoAtual(null);
	}
	
	@Test
	public void testCasoDeTeste03_CriarContaComSaldo_10(){
		conta = new EContaCorrente(10.0);
		Double resultadoEsperado = conta.getSaldoAtual();
		assertEquals(10.0, resultadoEsperado);
	}
	
	@Test
	public void testCasoDeTeste04_CriarContaComSaldo_15(){
		conta = new EContaCorrente(15.0);
		Double resultadoEsperado = conta.getSaldoAtual();
		assertEquals(15.0, resultadoEsperado);
	}
	
	@Test
	public void testCasoDeTeste05_CriarContaComSaldo_10_EDepositar30(){
		conta = new EContaCorrente(10.0);
		conta.setSaldoAtual(30.0);
		Double resultadoEsperado = conta.getSaldoAtual();
		assertEquals(40.0, resultadoEsperado);
	}
	
	@Test
	public void testCasoDeTeste06_CriarContaComSaldo_0_EDepositar10(){
		conta = new EContaCorrente(0.0);
		conta.setSaldoAtual(10.0);
		Double resultadoEsperado = conta.getSaldoAtual();
		assertEquals(10.0, resultadoEsperado);
	}
	
}
