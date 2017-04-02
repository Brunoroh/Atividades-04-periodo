package entidade;

import java.util.Date;

public class EMensalidade {
	
	private int codigo;
	private EAssociado associado;
	private Date dataVencimento;
	private Date dataPagamento;
	private String status;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public EAssociado getAssociado() {
		return associado;
	}
	public void setAssociado(EAssociado associado) {
		this.associado = associado;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
