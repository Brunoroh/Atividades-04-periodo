import java.util.Scanner;

public class Reposta1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//Declaração de variaveis
		int a;
		
		//Entrada de dados
		System.out.println("Digite um número");
		
		a = scanner.nextInt();
		
		if(a%2 == 0){
			System.out.println("O numero "+a+" é Par");
			if(a%9 == 0){
				System.out.println(" O numero "+a+" é divisivel por 9");
			}
		}else{
			System.out.println("O numero "+a+" é Impar");
			
		}
		
		System.out.println("FIM DO PROGRAMA");
	}
	
}
