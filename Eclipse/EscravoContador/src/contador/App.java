package contador;


import java.io.IOException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentLinkedDeque;

public class App {

	public App() throws UnknownHostException, ClassNotFoundException, IOException {
		
		Soma soma = new Soma();
		Transporte transporte;
		ConcurrentLinkedDeque<BigInteger> fila = new ConcurrentLinkedDeque<BigInteger>();
		Conexao conexao = new Conexao("localhost",8080);
		transporte = conexao.getTransporte();
		System.out.println(transporte.getValorInicial()+" à "+transporte.getValorFinal());
		Somador somador = new Somador(fila, soma);
		Somador somador2 = new Somador(fila, soma);
		Somador somador3 = new Somador(fila, soma);
		
		try{
			long to = System.currentTimeMillis();
			
			somador.start();
			somador2.start();
			somador3.start();
			int i = transporte.getValorInicial();
			int y = transporte.getValorFinal();
			for(;i< y ; i++) {
				fila.add(BigInteger.valueOf((long)i));
			}
			
			soma.setFinishedRead(true);
			
			somador.join();
			somador2.join();
			somador3.join();
			
			to = System.currentTimeMillis()-to;
			System.out.println("Valor da soma: "+ soma.getValor());
			System.out.println("Tempo gasto :"+to+"ms");
			conexao.enviarResultado(soma.getValor());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException {
		new App();
	}
}
