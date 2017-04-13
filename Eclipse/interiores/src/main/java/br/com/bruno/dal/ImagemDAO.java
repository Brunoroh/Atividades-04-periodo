package br.com.bruno.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.mockito.stubbing.OngoingStubbing;

import br.com.bruno.model.Imagem;
import br.com.bruno.util.Conexao;

public class ImagemDAO {

	Connection conexao;

	public ImagemDAO() {
		conexao = new Conexao().getConnection();
	}
	
	public boolean incluir(Imagem imagem){
		try{
			String sql = "INSERT INTO imagem(nome,local) VALUES(?,?)";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setString(1, imagem.getNome());
			prd.setString(2, imagem.getCaminho());
			prd.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean alterar(Imagem imagem){
		try{
			String sql = "UPDATE imagem SET nome = ?, "
					+ "local = ? "
					+ "WHERE codigo = ?";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setString(1, imagem.getNome());
			prd.setString(2, imagem.getCaminho());
			prd.setInt(3, imagem.getCodigo());
			prd.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public Imagem consultar(int codigo){
		try{
			String sql = "SELECT * FROM imagem WHERE codigo = ?";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setInt(1, codigo);
			ResultSet rs = prd.executeQuery();
			Imagem imagem = new Imagem();
			if(rs.next()){
				imagem.setCodigo(rs.getInt("codigo"));
				imagem.setNome(rs.getString("nome"));
				imagem.setCaminho(rs.getString("local"));
			}
			
			return imagem;
		}catch(Exception e){
			e.printStackTrace();
			return new Imagem();
		}
	}
	
	public Imagem consultarPorNome(String nome) {
		try{
			String sql = "SELECT * FROM imagem WHERE nome = ?";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setString(1, nome);
			ResultSet rs = prd.executeQuery();
			Imagem imagem = new Imagem();
			if(rs.next()){
				imagem.setCodigo(rs.getInt("codigo"));
				imagem.setNome(rs.getString("nome"));
				imagem.setCaminho(rs.getString("local"));
			}
			
			return imagem;
		}catch(Exception e){
			e.printStackTrace();
			return new Imagem();
		}
	}
	
	public List<Imagem> listarTodos(){
		try{
			String sql = "SELECT * FROM imagem";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			ResultSet rs = prd.executeQuery();
			List<Imagem> imagens = new ArrayList<Imagem>();
			while(rs.next()){
				Imagem imagem = new Imagem();
				imagem.setCodigo(rs.getInt("codigo"));
				imagem.setNome(rs.getString("nome"));
				imagem.setCaminho(rs.getString("local"));
				imagens.add(imagem);
			}
			
			return imagens;
		}catch(Exception e){
			e.printStackTrace();
			return new ArrayList<Imagem>();
		}
		
	}

	
	
	
	
	
}
