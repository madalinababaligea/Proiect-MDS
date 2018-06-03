package retea;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ConnectionController {
	Socket socket;
	ObjectInputStream input;
	ObjectOutputStream output;
	private static ConnectionController instance;
	
	public static ConnectionController getInstance() {
		if(instance==null)
			instance = new ConnectionController();
		return instance;
	}
	
	public ConnectionController() {
		try {
			socket = new Socket("192.168.43.104", 81);
			output=new ObjectOutputStream(socket.getOutputStream());
			output.flush();
			output.writeObject("hello Vale");
			input=new ObjectInputStream(socket.getInputStream());
			output.writeObject("bunaa");
			System.out.print(input.readObject());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int verifUser(String user,String parola) {
		try {
			output.writeObject("Verifica user");
			output.writeObject(user);
			output.writeObject(parola); 
			String mesaj=(String) input.readObject();
			if(mesaj!=null && mesaj.equals("Client"))return 1;
			else if(mesaj!=null && mesaj.equals("Manager")) return 2;
			else return 0;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean addClient(String nume, String prenume, String user, String password)
	{
		try {
			output.writeObject("Creaza cont");
			output.writeObject(nume);
			output.writeObject(prenume); 
			output.writeObject(user);
			output.writeObject(password); 
			boolean mesaj=(boolean) input.readObject();
			if(mesaj==true)return true;
			else return false;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void addFeedBack(String mesaj)
	{
		try
		{
			output.writeObject("Adauga feedback");
			output.writeObject(mesaj);
			
		}
			catch(IOException e) {
				e.printStackTrace();
			}
		
	}
	
	public boolean adaugaRezervare(String data, String zona, String nrpersoane)
	{
		try {
			output.writeObject("Adauga rezervare");
			output.writeObject(data);
			output.writeObject(zona);
			output.writeObject(nrpersoane);
			boolean mesaj=(boolean)input.readObject();
			return mesaj;
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

}