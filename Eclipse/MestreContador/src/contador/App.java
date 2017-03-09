package contador;

import java.io.IOException;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

	public App() throws IOException, InterruptedException{
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		BigInteger valorFinal= BigInteger.valueOf(100);
		ServerSocket ss = new ServerSocket(8080);
		Soma soma = new Soma();
		
		System.out.println("Aguardando conexoes");
		executor.execute(new Contador(ss,soma,new Transporte(1,50,null)));
		executor.execute(new Contador(ss,soma,new Transporte(51,100,null)));
		executor.execute(new Contador(ss,soma,new Transporte(101,200,null)));
		
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
		
		System.out.println("Resultado da soma : "+soma.getValor());
	}
	
	public static void main(String[] args) throws IOException, InterruptedException{
		new App();
	}
}
