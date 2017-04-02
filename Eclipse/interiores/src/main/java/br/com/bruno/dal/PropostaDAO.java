package br.com.bruno.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bruno.model.Imagem;
import br.com.bruno.model.Proposta;
import br.com.bruno.util.Conexao;

public class PropostaDAO {

	Connection conexao;

	public PropostaDAO() {
		conexao = new Conexao().getConnection();
	}
	
	public boolean incluir(Proposta proposta) throws SQLException{
		String sql = "INSERT INTO proposta(nome,telefone,email"
				+ "descricao,codigo_imagem) VALUES(?,?,?,?,?)";
	
		PreparedStatement prd = conexao.prepareStatement(sql);
		prd.setString(1, proposta.getNome());
		prd.setString(2, proposta.getTelefone());
		prd.setString(3, proposta.getEmail());
		prd.setString(4, proposta.getDescricao());
		prd.setInt(5, proposta.getImagem().getCodigo());
		
		return prd.execute();
	}
	
	public boolean alterar(Proposta proposta) throws SQLException{
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
		
		return prd.execute();
	}
	
	public Proposta consultar(int codigo) throws SQLException{
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
	}
	
	public List<Proposta> listarTodos() throws SQLException{
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
	}
	
}
