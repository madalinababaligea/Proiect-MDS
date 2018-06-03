package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import interfata.PrimaPagina;
import retea.ConnectionController;

public class Controller {
	
	private PrimaPagina p1 = new PrimaPagina(this);
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private static Controller instance;
	
	public Controller() {
			ConnectionController.getInstance();
	}
	
	public int verificaUser(String username, String password) {
		return ConnectionController.getInstance().verifUser(username,password);
	
	}
	
	public boolean addClient(String nume, String prenume, String user, String password)
	{
		return ConnectionController.getInstance().addClient(nume,prenume,user,password);
	}
	
	public void addFeedBack(String mesaj)
	{
		ConnectionController.getInstance().addFeedBack(mesaj);
	}
	public boolean adaugaRezervare(String data, String zona, String nrpersoane)
	{
		return ConnectionController.getInstance().adaugaRezervare(data,zona,nrpersoane);
	}

	
}

