package contador;

import java.io.Serializable;
import java.math.BigInteger;

public class Transporte implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int valorInicial;
	private int valorFinal;
	private BigInteger resultado;
	
	public Transporte(){};
	
	public Transporte(int valorInicial, int valorFinal, BigInteger resultado) {
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		this.resultado = resultado;
	}
	public int getValorInicial() {
		return valorInicial;
	}
	public void setValorInicial(int valorInicial) {
		this.valorInicial = valorInicial;
	}
	public int getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(int valorFinal) {
		this.valorFinal = valorFinal;
	}
	public BigInteger getResultado() {
		return resultado;
	}
	public void setResultado(BigInteger resultado) {
		this.resultado = resultado;
	}
	
	
	
	
	
	
	
	
	
}
