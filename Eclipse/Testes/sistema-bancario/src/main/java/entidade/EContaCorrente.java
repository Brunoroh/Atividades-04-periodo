package entidade;

public class EContaCorrente {

	private Double saldoAtual;
	
	

	public EContaCorrente() {
		super();
	}

	public EContaCorrente(Double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public Double getSaldoAtual() {
		if(saldoAtual == null)
			saldoAtual = new Double(0);
		
		return saldoAtual;
	}

	public void setSaldoAtual(Double saldoAtual) {
		if(saldoAtual == null)
			throw new IllegalArgumentException("Não é possivel atribuir 'nulo' ao saldo! Tente Novamente!");
		this.saldoAtual += saldoAtual;
	}
	
}
