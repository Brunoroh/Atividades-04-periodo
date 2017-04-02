package br.com.bruno.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bruno.model.Portfolio;
import br.com.bruno.util.Conexao;

public class PortfolioDAO {

	Connection conexao;

	public PortfolioDAO() {
		conexao = new Conexao().getConnection();
	}
	
	public boolean incluir(Portfolio portfolio) throws SQLException{
		String sql = "INSERT INTO portfolio(categoria,ambiente,data_cadastro,"
				+ "responsavel,codigo_imagem) VALUES(?,?,?,?,?)";
	
		PreparedStatement prd = conexao.prepareStatement(sql);
		prd.setString(1, portfolio.getCategoria());
		prd.setString(2, portfolio.getAmbiente());
		prd.setDate(3, new java.sql.Date(portfolio.getDataCadastro().getTime()));
		prd.setString(4, portfolio.getResponsavel());
		prd.setInt(5, portfolio.getImagem().getCodigo());
		
		
		return prd.execute();
	}
	
	public boolean alterar(Portfolio portfolio) throws SQLException{
		String sql = "UPDATE portfolio SET categoria = ?,"
				+ "ambiente = ?, "
				+ "data_cadastro = ?, "
				+ "responsavel = ?, "
				+ "codigo_imagem = ? "
				+ "WHERE codigo = ?";
		
		PreparedStatement prd = conexao.prepareStatement(sql);
		prd.setString(1, portfolio.getCategoria());
		prd.setString(2, portfolio.getAmbiente());
		prd.setDate(3, new java.sql.Date(portfolio.getDataCadastro().getTime()));
		prd.setString(4, portfolio.getResponsavel());
		prd.setInt(5, portfolio.getImagem().getCodigo());
		prd.setInt(6, portfolio.getCodigo());
		
		return prd.execute();
	}
	
	public Portfolio consultar(int codigo) throws SQLException{
		String sql = "SELECT * portfolio WHERE codigo = ?";
		
		PreparedStatement prd = conexao.prepareStatement(sql);
		prd.setInt(1, codigo);
		
		ResultSet rs = prd.executeQuery();
		Portfolio portfolio = new Portfolio();
		if(rs.next()){
			portfolio.setCodigo(rs.getInt("codigo"));
			portfolio.setCategoria(rs.getString("categoria"));
			portfolio.setAmbiente(rs.getString("ambiente"));
			portfolio.setDataCadastro(rs.getDate("data_cadastro"));
			portfolio.setResponsavel(rs.getString("responsavel"));
			portfolio.setImagem(new ImagemDAO().consultar(rs.getInt("codigo_imagem")));
		}
		
		return portfolio;
	}
	
	public List<Portfolio> listarTodos() throws SQLException{
		String sql = "SELECT * FROM portfolio";
		
		PreparedStatement prd = conexao.prepareStatement(sql);
		ResultSet rs = prd.executeQuery();
		List<Portfolio> portfolios = new ArrayList<Portfolio>();
		while(rs.next()){
			Portfolio portfolio = new Portfolio();
			portfolio.setCodigo(rs.getInt("codigo"));
			portfolio.setCategoria(rs.getString("categoria"));
			portfolio.setAmbiente(rs.getString("ambiente"));
			portfolio.setDataCadastro(rs.getDate("data_cadastro"));
			portfolio.setResponsavel(rs.getString("responsavel"));
			portfolio.setImagem(new ImagemDAO().consultar(rs.getInt("codigo_imagem")));
			portfolios.add(portfolio);
		}
		
		return portfolios;
	}
	
}
