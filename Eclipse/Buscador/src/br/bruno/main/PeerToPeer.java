package br.bruno.main;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.bruno.controller.BuscarArquivos;

public class PeerToPeer {

	public PeerToPeer() throws RemoteException, AlreadyBoundException{
		Registry reg = LocateRegistry.getRegistry("127.0.0.1",
				12345);
		BuscarArquivos barq = new BuscarArquivos();
		reg.bind("b1", barq);
	}
	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		new PeerToPeer();
	}
}