package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConexiuneClient {
	private Socket socket;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	public Controller instanta;
	
	//aici se realizeaza conexiunea efectiva
	// trimite mesaj clientului daca s-au conectat sau nu
	
	public ConexiuneClient(Controller controller, Socket socket) {
		instanta=controller;
		this.socket=socket;
		setUpStreams();
	}
	private void setUpStreams() {
		try {
	//		System.out.println("Incepe stream-ul");
			outputStream= new ObjectOutputStream(socket.getOutputStream());
		//	System.out.println("Incepe stream-ul 222");
			outputStream.flush();
			inputStream=new ObjectInputStream(socket.getInputStream());
		//	System.out.println("Incepe stream dupa getInputStream");
			instanta.seteazaMesaj(inputStream,outputStream);
			outputStream.writeObject("Conexiune buna");
		}
		catch(IOException e) {
			e.printStackTrace();
			instanta.write("Conexiune nereusita");
		}
		
	}
	
	public ObjectOutputStream getOutputStream() {
		return outputStream;
	}
	public ObjectInputStream getInputStream() {
		return inputStream;
	}
	public void close() {
		try {
			inputStream.close();
			outputStream.close();
			socket.close();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
