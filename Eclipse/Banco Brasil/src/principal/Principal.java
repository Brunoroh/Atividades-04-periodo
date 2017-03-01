package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Principal {

	public Principal(){
		try{
			System.out.println("Start!");
			Conta conta = new Conta((double)10);
			
			ExecutorService executor = Executors.newFixedThreadPool(2);
			
			
			executor.execute(new Terminal(conta,'d'));
			executor.execute(new Terminal(conta,'s'));
			
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("terminei...");
		System.exit(0);
	}
	
	public static void main(String args[]){
		new Principal();
	}
}
