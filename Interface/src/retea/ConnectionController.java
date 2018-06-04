package retea;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import clase.Feed;
import clase.Utilizator;
import clase.Zona;

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
			socket = new Socket("192.168.1.28", 81);
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
	public Utilizator TrimiteDate()
	{
		try {
			output.writeObject("Editeaza");
			String nume= (String)input.readObject();
			String prenume= (String)input.readObject();
			String username= (String)input.readObject();
			String parola= (String)input.readObject();
			
			Utilizator x= new Utilizator(nume,prenume,username,parola);
			
			return x;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void EditeazaClient(String name, String pren, String user, String pass)
	{
		try {
			output.writeObject("Editeaza client");
			output.writeObject(name);
			output.writeObject(pren);
			output.writeObject(user);
			output.writeObject(pass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	public ArrayList<Feed> veziFeedback()
	{
		ArrayList<Feed> feedback= new ArrayList<Feed>();
		try {
			output.writeObject("Vezi feedback");
			String feedb=(String) input.readObject();
			while (!feedb.equals("%"))
			{
				int id=(int) input.readObject();
				Feed obj= new Feed(feedb,id);
				feedback.add(obj);
				feedb=(String) input.readObject();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return feedback;
		
	}
		public Zona VeziRaport(String data)
		{
			try {
				output.writeObject("Vezi raport");
				output.writeObject(data);
				int ZonaA= (int) input.readObject();
				int ZonaB= (int) input.readObject();
				int ZonaC= (int) input.readObject();
				Zona obj=new Zona(ZonaA,ZonaB,ZonaC);
				
				return obj;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
}