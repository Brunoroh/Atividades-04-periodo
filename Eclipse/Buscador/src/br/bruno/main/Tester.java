package br.bruno.main;

import java.io.File;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.com.fatesg.buscador.IBuscador;

public class Tester {
	
	public Tester() throws RemoteException, NotBoundException{
		Registry reg = LocateRegistry.getRegistry("127.0.0.1",
				12345);
		IBuscador buscador = (IBuscador) reg.lookup("b1");
		File file = buscador.buscar("nada");
		System.out.println(file.getName());
	}
	
	public static void main(String[] args) throws RemoteException, NotBoundException {
		new Tester();
	}
}
