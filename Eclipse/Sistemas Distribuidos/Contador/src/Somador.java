

import java.util.concurrent.ConcurrentLinkedDeque;

public class Somador extends Thread {
	private Soma soma;
	private ConcurrentLinkedDeque<Double> fila;
	
	public Somador(ConcurrentLinkedDeque<Double> fila, Soma soma) {
		this.fila = fila;
		this.soma = soma;
	}
	
	
	@Override
	public void run() {
		Double valor = (double)0;
		
		while(!soma.isFinishedRead() || (valor = fila.poll()) != null){
			if(fila.isEmpty()){
				continue;
			}
			synchronized(soma){
				this.soma.setValor(this.soma.getValor() + valor);
			}
		}
		
		System.out.println(this.getName()+" END");
	}

}
