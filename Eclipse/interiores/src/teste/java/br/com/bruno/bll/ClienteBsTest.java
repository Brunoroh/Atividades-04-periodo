package br.com.bruno.bll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.*;
import br.com.bruno.dal.ClienteDAO;
import br.com.bruno.model.Cliente;
import junit.framework.TestCase;

public class ClienteBsTest extends TestCase {

	@Mock
	ClienteDAO dao;
	
	Cliente cliente;
	ClienteBs bs;
	
	@Before
	public void setUp(){
		dao = Mockito.mock(ClienteDAO.class);
		cliente = new Cliente();
		bs = new ClienteBs(dao);
		
		cliente.setNome("Bruno Carlos Pinheiro Rodrigues");
		cliente.setCpf("700.198.111-14");
		cliente.setDataNascimento(new Date());
		cliente.setEmail("bruno@teste.com.br");
		cliente.setEndereco("Rua 01");
		cliente.setRg("58545046");
		cliente.setTelefone("3200-0000");
	}
	
	@Test
	public void	testSalvar() throws Exception{
		Mockito.when(dao.consultarPorCpf(cliente.getCpf())).thenReturn(cliente);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		
		Cliente usuarioTestado = bs.salvar(cliente);
		assertEquals(cliente, usuarioTestado);	
	}
	
	@Test
	public void	testSalvarComClienteNull() throws Exception{
		Mockito.when(dao.consultarPorCpf(cliente.getCpf())).thenReturn(cliente);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		cliente = null;
		
		Cliente usuarioTestado = bs.salvar(null);
		assertEquals(new Cliente(), usuarioTestado);	
	}
	
	@Test
	public void testAlterar() throws Exception{
		cliente.setCodigo(1);
		Mockito.when(dao.consultarPorCpf(cliente.getCpf())).thenReturn(cliente);
		Mockito.when(dao.alterar(Mockito.any())).thenReturn(true);
		
		Cliente clienteTestado = bs.salvar(cliente);
		assertEquals(cliente, clienteTestado);	
	}
	
	@Test
	public void testConsultar(){
		cliente.setCodigo(1);
		
		Mockito.when(dao.consultar(1)).thenReturn(cliente);
		
		Cliente clienteTestado = bs.consultar(cliente.getCodigo());
		assertEquals(cliente, clienteTestado);
	}
	
	@Test
	public void testListar(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(cliente);
		clientes.add(cliente);
		
		Mockito.when(dao.listarTodos()).thenReturn(clientes);
		List<Cliente> clientesTestados = bs.listar();
		assertEquals(clientes, clientesTestados);
	}
	
	@Test
	public void	testSalvarComNomeNull() throws Exception{
		cliente.setNome(null);
		Mockito.when(dao.consultarPorCpf(cliente.getCpf())).thenReturn(cliente);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		
		Cliente usuarioTestado = bs.salvar(cliente);
		assertEquals(cliente, usuarioTestado);	
	}
	
	@Test
	public void	testSalvarComCpfNull(){
			try{
				cliente.setCpf(null);
				Mockito.when(dao.consultarPorCpf(cliente.getCpf())).thenReturn(cliente);
				bs.salvar(cliente);
				fail("Não disparou a exceção");
			}catch(Exception e){
				assertThat(e).hasMessage("O CPF está vazio");
			}
	}
	
	
	@Test
	public void	testSalvarComCpfInvalido() throws Exception{
		try{
			cliente.setCpf("700.198.111-5");
			Mockito.when(dao.consultarPorCpf(cliente.getCpf())).thenReturn(cliente);
			Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
			
			Cliente usuarioTestado = bs.salvar(cliente);
			fail("Não disparou a exceção");
		}catch(Exception e){
			assertThat(e).hasMessage("CPF é inválido");
		}
	}
	
	@Test
	public void	testSalvarComDtNascimentoNull() throws Exception{
		cliente.setDataNascimento(null);
		Mockito.when(dao.consultarPorCpf(cliente.getCpf())).thenReturn(cliente);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		
		Cliente usuarioTestado = bs.salvar(cliente);
		assertEquals(cliente, usuarioTestado);	
	}
	
	@Test
	public void	testSalvarComEmailNull() throws Exception{
		try{
			cliente.setEmail(null);
			Mockito.when(dao.consultarPorCpf(cliente.getCpf())).thenReturn(cliente);
			Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
			
			Cliente usuarioTestado = bs.salvar(cliente);
			fail("Não disparou a exceção");
		}catch(Exception e){
			assertThat(e).hasMessage("O email está vazio");
		}
	}
	
	@Test
	public void	testSalvarComEnderecoNull() throws Exception{
		cliente.setEndereco(null);
		Mockito.when(dao.consultarPorCpf(cliente.getCpf())).thenReturn(cliente);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		
		Cliente usuarioTestado = bs.salvar(cliente);
		assertEquals(cliente, usuarioTestado);	
	}
	
	@Test
	public void	testSalvarComRgNull() throws Exception{
		cliente.setRg(null);
		Mockito.when(dao.consultarPorCpf(cliente.getCpf())).thenReturn(cliente);
		Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
		
		Cliente usuarioTestado = bs.salvar(cliente);
		assertEquals(cliente, usuarioTestado);	
	}
	
	@Test
	public void	testSalvarComTelefoneNull(){
		try{
			cliente.setTelefone(null);
			Mockito.when(dao.consultarPorCpf(cliente.getCpf())).thenReturn(cliente);
			Mockito.when(dao.incluir(Mockito.any())).thenReturn(true);
			
			Cliente usuarioTestado = bs.salvar(cliente);
			fail("Não disparou a exceção");
		}catch(Exception e){
			assertThat(e).hasMessage("O telefone está vazio");
		}
	}
}
