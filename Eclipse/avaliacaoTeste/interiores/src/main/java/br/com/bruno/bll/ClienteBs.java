package br.com.bruno.bll;

import java.util.List;

import br.com.bruno.dal.ClienteDAO;
import br.com.bruno.model.Cliente;

public class ClienteBs {

	ClienteDAO dao;

	public ClienteBs(ClienteDAO dao) {
		this.dao = dao;
	}

	public ClienteBs(){
		dao = new ClienteDAO();
	}

	public Cliente salvar(Cliente cliente) throws Exception {
		
			if(cliente != null){
				if(validarCliente(cliente)){
					if(cliente.getCodigo() == 0){
						dao.incluir(cliente);
					}else{
						dao.alterar(cliente);
					}
					
					return dao.consultarPorCpf(cliente.getCpf());
				}
				
			}
			
			return new Cliente();
	}

	public Cliente consultar(int codigo) {
		return dao.consultar(codigo);
	}

	public List<Cliente> listar() {
		return dao.listarTodos();
	}
	
	public void remove(int codigo){
		dao.remover(codigo);
	}
	
	private boolean validarCliente(Cliente cliente) throws Exception{
		
		validarCpf(cliente.getCpf());
		validarEmail(cliente.getEmail());
		validarTelefone(cliente.getTelefone());
		return true;
		
	}
	
	private boolean validarCpf(String cpf) throws Exception{
		if("".equals(cpf) || cpf == null){
			throw new Exception("O CPF está vazio");
		}
		
		if(cpf.length() != 14){
			throw new Exception("CPF é inválido");
		}
		return true;
	}
	
	private boolean validarEmail(String email)throws Exception{
		if("".equals(email) || email == null){
			throw new Exception("O email está vazio");
		}
		
		return true;
	}
	
	
	private boolean validarTelefone(String telefone) throws Exception{
		if("".equals(telefone) || telefone == null){
			throw new Exception("O telefone está vazio");
		}
		
		return true;
	}
	
	
}
