package principal;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Escravo {

	public Escravo() throws IOException {
		Socket socket = new Socket("127.0.0.1",4567);
		System.out.println("Pronto para trabalhar");


		BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
		
		Scanner scanner = new Scanner(socket.getInputStream());
	
		String cmd = "";
		
		if(cmd.equals("CONTA")){
			int c = 0;
			for(int i = 0; i<100; i++){
				c += 1 ;
			}
			bos.write((""+c+"\n").getBytes());
		}else{
			bos.write(("Pronto \n").getBytes());
		}
	}
	
	public static void main(String[] args) throws IOException{
		new Escravo();
	}

	
	
}
