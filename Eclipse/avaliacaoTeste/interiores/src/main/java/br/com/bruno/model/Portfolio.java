package br.com.bruno.model;

import java.util.Date;

public class Portfolio {

	private int codigo;
	private String categoria;
	private Imagem imagem;
	private String ambiente;
	private Date dataCadastro;
	private String responsavel;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Imagem getImagem() {
		return imagem;
	}
	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	
	
}
