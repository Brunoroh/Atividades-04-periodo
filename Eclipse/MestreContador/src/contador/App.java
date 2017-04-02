package contador;

import java.io.IOException;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import contador.SistemasDistribuidos.Transporte;
import contador.SistemasDistribuidos.Transporte.Builder;

public class App {

	public App() throws IOException, InterruptedException{
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		BigInteger valorFinal= BigInteger.valueOf(100);
		ServerSocket ss = new ServerSocket(8080);
		Soma soma = new Soma();
		
		Transporte transporte1 = Transporte.newBuilder()
				.setNumeroInicial(0)
				.setNumeroFinal(50)
				.build();
		
		Transporte transporte2 = Transporte.newBuilder()
				.setNumeroInicial(51)
				.setNumeroFinal(100)
				.build();
		
		Transporte transporte3 = Transporte.newBuilder()
				.setNumeroInicial(101)
				.setNumeroFinal(200)
				.build();
		
		System.out.println("Aguardando conexoes");
		executor.execute(new Contador(ss,soma,transporte1));
		executor.execute(new Contador(ss,soma,transporte2));
		executor.execute(new Contador(ss,soma,transporte3));
		
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
		
		System.out.println("Resultado da soma : "+soma.getValor());
	}
	
	public static void main(String[] args) throws IOException, InterruptedException{
		new App();
	}
}
