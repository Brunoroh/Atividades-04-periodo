package contador;

import java.math.BigInteger;

public class Soma {
	private BigInteger valor = BigInteger.valueOf(0);
	private boolean finishedRead;

	
	public BigInteger getValor() {
		return valor;
	}
	public void setValor(BigInteger valor) {
		this.valor = valor;
	}
	public boolean isFinishedRead() {
		return finishedRead;
	}
	public void setFinishedRead(boolean finishedRead) {
		this.finishedRead = finishedRead;
	}
	
	
}
