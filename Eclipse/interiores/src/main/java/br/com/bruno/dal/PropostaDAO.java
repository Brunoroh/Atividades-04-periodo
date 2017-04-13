package br.com.bruno.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bruno.model.Proposta;
import br.com.bruno.util.Conexao;

public class PropostaDAO {

	Connection conexao;

	public PropostaDAO() {
		conexao = new Conexao().getConnection();
	}
	
	public boolean incluir(Proposta proposta){
		try{
			String sql = "INSERT INTO proposta(nome,telefone,email"
					+ ",descricao,codigo_imagem) VALUES(?,?,?,?,?)";
		
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setString(1, proposta.getNome());
			prd.setString(2, proposta.getTelefone());
			prd.setString(3, proposta.getEmail());
			prd.setString(4, proposta.getDescricao());
			prd.setInt(5, proposta.getImagem().getCodigo());
			prd.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean alterar(Proposta proposta){
		try{
			String sql = "UPDATE proposta SET nome = ?, "
					+ "telefone = ?, "
					+ "email = ?, "
					+ "descricao = ?, "
					+ "codigo_imagem = ? "
					+ "WHERE codigo = ?";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setString(1, proposta.getNome());
			prd.setString(2, proposta.getTelefone());
			prd.setString(3, proposta.getEmail());
			prd.setString(4, proposta.getDescricao());
			prd.setInt(5, proposta.getImagem().getCodigo());
			prd.setInt(6, proposta.getCodigo());
			prd.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public Proposta consultar(int codigo){
		try{
			String sql = "SELECT * FROM proposta WHERE codigo = ?";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setInt(1, codigo);
			
			ResultSet rs = prd.executeQuery();
			Proposta proposta = new Proposta();
			if(rs.next()){
				proposta.setCodigo(rs.getInt("codigo"));
				proposta.setNome(rs.getString("nome"));
				proposta.setTelefone(rs.getString("telefone"));
				proposta.setEmail(rs.getString("email"));
				proposta.setDescricao(rs.getString("descricao"));
				proposta.setImagem(new ImagemDAO().consultar(rs.getInt("codigo_imagem")));
			}
			
			return proposta;
		}catch(Exception e){
			e.printStackTrace();
			return new Proposta();
		}
	}
	
	public Proposta consultarPorResponsavelEDescricao(Proposta proposta){
		try{
			String sql = "SELECT * FROM proposta WHERE nome = ? and descricao = ?";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setString(1, proposta.getNome());
			prd.setString(2, proposta.getDescricao());
			
			ResultSet rs = prd.executeQuery();
			Proposta returnProposta = new Proposta();
			if(rs.next()){
				returnProposta.setCodigo(rs.getInt("codigo"));
				returnProposta.setNome(rs.getString("nome"));
				returnProposta.setTelefone(rs.getString("telefone"));
				returnProposta.setEmail(rs.getString("email"));
				returnProposta.setDescricao(rs.getString("descricao"));
				returnProposta.setImagem(new ImagemDAO().consultar(rs.getInt("codigo_imagem")));
			}
			
			return returnProposta;
		}catch(Exception e){
			e.printStackTrace();
			return new Proposta();
		}
	}
	
	public List<Proposta> listarTodos(){
		try{
			String sql = "SELECT * FROM proposta";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			ResultSet rs = prd.executeQuery();
			List<Proposta> propostas = new ArrayList<Proposta>();
			while(rs.next()){
				Proposta proposta = new Proposta();
				proposta.setCodigo(rs.getInt("codigo"));
				proposta.setNome(rs.getString("nome"));
				proposta.setTelefone(rs.getString("telefone"));
				proposta.setEmail(rs.getString("email"));
				proposta.setDescricao(rs.getString("descricao"));
				proposta.setImagem(new ImagemDAO().consultar(rs.getInt("codigo_imagem")));
				propostas.add(proposta);
			}
			
			return propostas;
		}catch(Exception e){
			e.printStackTrace();
			return new ArrayList<Proposta>();
		}
	}

	public void remover(int codigo) {
		try{
			String sql = "DELETE FROM proposta WHERE codigo = ?";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setInt(1, codigo);
			prd.execute();
			prd.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
