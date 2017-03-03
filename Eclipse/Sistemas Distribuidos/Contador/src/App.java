

import java.util.concurrent.ConcurrentLinkedDeque;

public class App {

	public App() {
		
		Soma soma = new Soma();
		ConcurrentLinkedDeque<Double> fila = new ConcurrentLinkedDeque<Double>();
		
		Somador somador = new Somador(fila, soma);
		Somador somador2 = new Somador(fila, soma);
		Somador somador3 = new Somador(fila, soma);
		
		try{
			long to = System.currentTimeMillis();
			
			somador.start();
			somador2.start();
			somador3.start();
			
			for(int i=0 ; i< 50000000 ; i++) {
				fila.add(i*0.01);
			}
			
			soma.setFinishedRead(true);
			
			somador.join();
			somador2.join();
			somador3.join();
			
			to = System.currentTimeMillis()-to;
			System.out.println("Valor da soma: "+ soma.getValor());
			System.out.println("Tempo gasto :"+to+"ms");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new App();
	}
}
