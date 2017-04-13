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
	
	public boolean incluir(Portfolio portfolio){
		try{
			String sql = "INSERT INTO portfolio(categoria,ambiente,data_cadastro"
					+ ",responsavel,codigo_imagem) VALUES(?,?,?,?,?)";
		
			PreparedStatement prd = conexao.prepareStatement(sql);
			
			prd.setString(1, portfolio.getCategoria());
			prd.setString(2, portfolio.getAmbiente());
			prd.setDate(3, new java.sql.Date(portfolio.getDataCadastro().getTime()));
			prd.setString(4, portfolio.getResponsavel());
			prd.setInt(5, portfolio.getImagem().getCodigo());
			prd.execute();
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean alterar(Portfolio portfolio){
		try{
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
			prd.execute();
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public Portfolio consultar(int codigo){
		try{
			String sql = "SELECT * FROM portfolio WHERE codigo = ?";
			
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
		}catch(Exception e){
			e.printStackTrace();
			return new Portfolio();
		}
	}
	
	public List<Portfolio> listarTodos(){
		try{
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
		}catch(Exception e){
			e.printStackTrace();
			return new ArrayList<Portfolio>();
		}
	}

	public Portfolio consultarPorResponsavel(Portfolio portfolio) {
		try{
			String sql = "SELECT * FROM portfolio WHERE responsavel = ? and categoria = ?";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setString(1, portfolio.getResponsavel());
			prd.setString(2, portfolio.getCategoria());
			
			ResultSet rs = prd.executeQuery();
			Portfolio returnPortfolio = new Portfolio();
			if(rs.next()){
				returnPortfolio.setCodigo(rs.getInt("codigo"));
				returnPortfolio.setCategoria(rs.getString("categoria"));
				returnPortfolio.setAmbiente(rs.getString("ambiente"));
				returnPortfolio.setDataCadastro(rs.getDate("data_cadastro"));
				returnPortfolio.setResponsavel(rs.getString("responsavel"));
				returnPortfolio.setImagem(new ImagemDAO().consultar(rs.getInt("codigo_imagem")));
			}
			
			return returnPortfolio;
		}catch(Exception e){
			e.printStackTrace();
			return new Portfolio();
		}
	}

	public void remover(int codigo) {
		try{
			String sql = "DELETE FROM portfolio WHERE codigo = ?";
			
			PreparedStatement prd = conexao.prepareStatement(sql);
			prd.setInt(1, codigo);
			prd.execute();
			prd.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
