package br.com.bruno.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bruno.model.Cliente;
import br.com.bruno.util.Conexao;

public class ClienteDAO {

	Connection conexao;

	public ClienteDAO() {
		conexao = new Conexao().getConnection();
	}
	
	public boolean incluir(Cliente cliente){
		try{
			String sql = "INSERT INTO cliente(nome,email,telefone,"
					+ "endereco,rg,cpf,data_nascimento) VALUES(?,?,?,?,?,?,?)";
		
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setString(1, cliente.getNome());
			prd.setString(2, cliente.getEmail());
			prd.setString(3, cliente.getTelefone());
			prd.setString(4, cliente.getEndereco());
			prd.setString(5, cliente.getRg());
			prd.setString(6, cliente.getCpf());
			prd.setDate(7, new java.sql.Date(cliente.getDataNascimento().getTime()));
			
			prd.execute();
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean alterar(Cliente cliente){
		try{
			String sql = "UPDATE cliente SET nome = ?,"
					+ "email = ?, "
					+ "telefone = ?, "
					+ "endereco = ?, "
					+ "rg = ?, "
					+ "cpf = ?, "
					+ "data_nascimento = ? "
					+ "WHERE codigo = ?";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setString(1, cliente.getNome());
			prd.setString(2, cliente.getEmail());
			prd.setString(3, cliente.getTelefone());
			prd.setString(4, cliente.getEndereco());
			prd.setString(5, cliente.getRg());
			prd.setString(6, cliente.getCpf());
			prd.setDate(7, new java.sql.Date(cliente.getDataNascimento().getTime()));
			prd.setInt(8, cliente.getCodigo());
			prd.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void remover(int codigo){
		try{
			String sql = "DELETE FROM cliente WHERE codigo = ?";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setInt(1, codigo);
			prd.execute();
			prd.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Cliente consultar(int codigo){
		try{
			String sql = "SELECT * FROM cliente WHERE codigo = ?";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setInt(1, codigo);
			
			ResultSet rs = prd.executeQuery();
			Cliente cliente = new Cliente();
			if(rs.next()){
				cliente.setCodigo(rs.getInt("codigo"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setRg(rs.getString("rg"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setDataNascimento(rs.getDate("data_nascimento"));
			}
			
			return cliente;
		}catch(Exception e){
			e.printStackTrace();
			return new Cliente();
		}
	}
	
	public Cliente consultarPorCpf(String cpf){
		try{
			String sql = "SELECT * FROM cliente WHERE cpf = ?";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setString(1, cpf);
			
			ResultSet rs = prd.executeQuery();
			Cliente cliente = new Cliente();
			if(rs.next()){
				cliente.setCodigo(rs.getInt("codigo"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setRg(rs.getString("rg"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setDataNascimento(rs.getDate("data_nascimento"));
			}
			
			return cliente;
		}catch(Exception e){
			e.printStackTrace();
			return new Cliente();
		}
	}
	
	public List<Cliente> listarTodos(){
		try{
			String sql = "SELECT * FROM cliente";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			ResultSet rs = prd.executeQuery();
			List<Cliente> clientes = new ArrayList<Cliente>();
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getInt("codigo"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setRg(rs.getString("rg"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setDataNascimento(rs.getDate("data_nascimento"));
				clientes.add(cliente);
			}
			
			return clientes;
		}catch(Exception e){
			e.printStackTrace();
			return new ArrayList<Cliente>();
		}
	}
	
}
