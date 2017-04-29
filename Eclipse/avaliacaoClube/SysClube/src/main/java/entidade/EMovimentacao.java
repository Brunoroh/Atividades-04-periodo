package entidade;

import java.util.Date;

public class EMovimentacao {
	
	private int codigo; 
	private EAssociado associado;
	private Date horaEntrada;
	private Date horaSaida;
	
	public EMovimentacao() {
		this.codigo = 0;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(Date data) {
		this.horaEntrada = data;
	}
	public Date getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(Date data) {
		this.horaSaida = data;
	}
	public EAssociado getAssociado() {
		return associado;
	}
	public void setAssociado(EAssociado associado) {
		this.associado = associado;
	}
	
}
