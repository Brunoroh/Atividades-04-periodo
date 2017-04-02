package contador;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;

import contador.SistemasDistribuidos.Transporte;

public class Contador extends Thread {

	ServerSocket serverSocket;
	Transporte transporte;
	Soma soma;
	BigInteger soma2;
	
	
	public Contador (ServerSocket socket, Soma soma,Transporte transporte){
		this.serverSocket = socket;
		this.transporte = transporte;
		this.soma = soma;
	}
	
	@Override
	public void run() {
		try {
			Socket socket = serverSocket.accept();
			System.out.println("Socket Conectado");
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(transporte);
			
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Object obj = ois.readObject();
			
			if(obj instanceof Transporte){
				transporte = (Transporte)obj;
			}
			synchronized(soma){
				soma.setValor(soma.getValor()+transporte.getResutlado());
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
