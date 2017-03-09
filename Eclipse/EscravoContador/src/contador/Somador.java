package contador;


import java.math.BigInteger;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Somador extends Thread {
	private Soma soma;
	private ConcurrentLinkedDeque<BigInteger> fila;
	
	public Somador(ConcurrentLinkedDeque<BigInteger> fila, Soma soma) {
		this.fila = fila;
		this.soma = soma;
	}
	
	
	@Override
	public void run() {
		BigInteger valor = BigInteger.valueOf(0);
		while(!soma.isFinishedRead() || (valor = fila.poll()) != null){
			if(fila.isEmpty()){
				continue;
			}
			synchronized(soma){
				this.soma.setValor(this.soma.getValor().add(valor));
			}
		}
		
		System.out.println(this.getName()+" END");
	}

}
