package br.com.bruno.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bruno.model.Imagem;
import br.com.bruno.util.Conexao;

public class ImagemDAO {

	Connection conexao;

	public ImagemDAO() {
		conexao = new Conexao().getConnection();
	}
	
	public boolean incluir(Imagem imagem) throws SQLException{
		String sql = "INSERT INTO imagem(nome,local) VALUES(?,?)";
	
		PreparedStatement prd = conexao.prepareStatement(sql);
		prd.setString(1, imagem.getNome());
		prd.setString(2, imagem.getCaminho());
		
		return prd.execute();
	}
	
	public boolean alterar(Imagem imagem) throws SQLException{
		String sql = "UPDATE imagem SET nome = ?, "
				+ "local = ? "
				+ "WHERE codigo = ?";
		
		PreparedStatement prd = conexao.prepareStatement(sql);
		prd.setString(1, imagem.getNome());
		prd.setString(2, imagem.getCaminho());
		prd.setInt(3, imagem.getCodigo());
		
		return prd.execute();
	}
	
	public Imagem consultar(int codigo) throws SQLException{
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
	}
	
	public List<Imagem> listarTodos() throws SQLException{
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
	}
	
	
	
	
}
