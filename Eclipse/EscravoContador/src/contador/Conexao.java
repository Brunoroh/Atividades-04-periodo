package contador;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.net.UnknownHostException;

public class Conexao {

	Socket socket;
	Transporte transporte;
	ObjectInputStream ois; 
	ObjectOutputStream oos;
	
	public Conexao(String host,int porta) throws UnknownHostException, IOException, ClassNotFoundException{
		this.socket = new Socket(host,porta);
		transporte = new Transporte();
		ois = new ObjectInputStream(socket.getInputStream());
		Object obj = ois.readObject();
		if(obj instanceof Transporte){
			transporte = (Transporte) obj;	
		}
		
		oos = new ObjectOutputStream(socket.getOutputStream());
		
	}
	
	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	public void enviarResultado(BigInteger numero) throws IOException{
		transporte.setResultado(numero);
		oos.writeObject(transporte);
	}
}
