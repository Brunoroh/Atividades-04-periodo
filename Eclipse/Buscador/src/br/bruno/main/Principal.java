package br.bruno.main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.bruno.controller.BuscarArquivos;
import br.com.fatesg.buscador.IBuscador;

public class Principal {

	public Principal() throws RemoteException{
		Registry reg = LocateRegistry.createRegistry(12345);
		Registry reg2 = LocateRegistry.getRegistry("192.168.107.210",
				12345);
		IBuscador barq = new BuscarArquivos();
		reg2.rebind("b1", barq);
	}
	
	public static void main(String[] args) throws RemoteException {
		System.out.println("init");
		new Principal();
		System.out.println("FIM");
	}
	
}
