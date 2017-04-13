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

	public Cliente salvar(Cliente cliente) {
		
		if(cliente != null){
			
			if(cliente.getCodigo() == 0){
				dao.incluir(cliente);
			}else{
				dao.alterar(cliente);
			}
			
			return dao.consultarPorCpf(cliente.getCpf());
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
	
	
}
