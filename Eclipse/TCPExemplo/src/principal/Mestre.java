package principal;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Mestre {

	public Mestre() throws IOException {
		ServerSocket ss = new ServerSocket(4567);
		Socket accept = ss.accept();
		
		System.out.println("Recebeu Escravo");
		
		BufferedOutputStream bos = new BufferedOutputStream(accept.getOutputStream());
		
		Scanner scanner = new Scanner(accept.getInputStream());
		
		bos.write("CONTA \n".getBytes());
		
		if(scanner.hasNext()){
			String string = scanner.next();
			System.out.println(string);
		}
	}
	
	public static void main(String[] args)throws IOException{
		new Mestre();
	}
}