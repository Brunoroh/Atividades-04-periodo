package br.bruno.controller;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.com.fatesg.buscador.IBuscador;

public class BuscarArquivos extends UnicastRemoteObject implements IBuscador {

	public BuscarArquivos() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public File buscar(String parametroDeBusca) throws RemoteException {
		File file = new File("/Buscador/arq/exemplo.txt");
		System.out.println("OK");
		return file;
	}

}
