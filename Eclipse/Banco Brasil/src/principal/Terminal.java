package principal;

import java.util.Random;

public class Terminal extends Thread {
	
	Conta conta;
	char flag; // S = Saca , D = Deposita , E = Ambas operações
	Random random;
	
	public Terminal(Conta conta, char flag){
		this.conta = conta;
		this.flag = flag;
		random = new Random();
	}
	
	public Terminal(Conta conta){
		this.conta = conta;
	}

	@Override
	public void run() {
		if(flag == 'd'){
			while(true){
				
				double valor = random.nextInt(100);
				synchronized(conta){
					conta.deposito(valor);
					conta.notifyAll();
				}
			}
		}else{
			
			while(true){		
				double valor = random.nextInt(1000)*1.0;
				try{
					if(conta.saldoSuficiente(valor)){
						conta.saque(valor);
					}else{
						conta.wait();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				System.out.println("Saque de "+valor+" realizado com sucesso!");
				
			}
		}
	}

	
	
}
