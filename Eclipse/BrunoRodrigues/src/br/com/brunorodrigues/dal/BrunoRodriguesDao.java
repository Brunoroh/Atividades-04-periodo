package br.com.brunorodrigues.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.brunorodrigues.model.BrunoRodrigues;
import br.com.brunorodrigues.util.Conexao;

public class BrunoRodriguesDao {

	private Connection conexao;
	
	
	
	public BrunoRodriguesDao() {
		this.conexao = Conexao.getConnection();
	}

	public void incluir(BrunoRodrigues brunoRodrigues) throws SQLException{
		
		String sql = "INSERT INTO bruno_rodrigues(nome,data_cadastro) VALUES(?,?)";
		
		PreparedStatement prd = conexao.prepareStatement(sql);
		prd.setString(1, brunoRodrigues.getNome());
		prd.setDate(2, new java.sql.Date(brunoRodrigues.getDataCadastro().getTime()));
		
		prd.execute();
		prd.close();
		
	}
	
	public void alterar(BrunoRodrigues brunoRodrigues) throws SQLException{
		String sql = "UPDATE bruno_rodrigues set nome = ? , data_cadastro = ? where codigo = ?";
		
		PreparedStatement prd = conexao.prepareStatement(sql);
		prd.setString(1, brunoRodrigues.getNome());
		prd.setDate(2, new java.sql.Date(brunoRodrigues.getDataCadastro().getTime()));
		prd.setInt(3, brunoRodrigues.getCodigo());
		
		prd.execute();
		prd.close();
	}
	
	public BrunoRodrigues consultar(int codigo) throws SQLException{
		String sql = "SELECT * FROM bruno_rodrigues where codigo = ?";
		
		PreparedStatement prd = conexao.prepareStatement(sql);
		prd.setInt(1, codigo);
		ResultSet rs = prd.executeQuery();
		BrunoRodrigues brunoRodrigues = new BrunoRodrigues();
		if(rs.next()){
			brunoRodrigues.setCodigo(rs.getInt("codigo"));
			brunoRodrigues.setNome(rs.getString("nome"));
			brunoRodrigues.setDataCadastro(rs.getDate("data_cadastro"));
		}
		
		return brunoRodrigues;
	}
	
	public List<BrunoRodrigues> listarTodos() throws SQLException{
		String sql = "SELECT * from bruno_rodrigues";
		
		PreparedStatement prd = conexao.prepareStatement(sql);
		ResultSet rs = prd.executeQuery();
		List<BrunoRodrigues> lista = new ArrayList<>();
		while(rs.next()){
			BrunoRodrigues brunoRodrigues = new BrunoRodrigues();
			brunoRodrigues.setCodigo(rs.getInt("codigo"));
			brunoRodrigues.setNome(rs.getString("nome"));
			brunoRodrigues.setDataCadastro(rs.getDate("data_cadastro"));
			lista.add(brunoRodrigues);
		}
		
		return lista;
	}

	public void remover(int codigo) throws SQLException {
		String sql = "DELETE FROM bruno_rodrigues WHERE codigo = ?";
		
		PreparedStatement prd = conexao.prepareStatement(sql);
		prd.setInt(1, codigo);
		prd.execute();
		prd.close();
		
		
	}
}
