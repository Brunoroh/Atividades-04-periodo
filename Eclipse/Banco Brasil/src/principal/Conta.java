package principal;

public class Conta {
	
	private Double saldo;

	public Conta(Double saldo){
		this.saldo = saldo;
	}
	
	public void deposito(Double valor){
		this.saldo += valor;
	}
	
	public Double saque(Double valor){
		this.saldo -= valor;
		return saldo;
	}
	
	public boolean saldoSuficiente(Double valor){
		if(saldo > valor)
			return true;
		else
			return false;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
	
	
}
