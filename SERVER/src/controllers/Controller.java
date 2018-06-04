package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import clase.Client;
import clase.Feedback;
import clase.Sesiune;
import clase.Zone;

public class Controller {
	private ControllerBD controllerBD;
	private ConexiuneClient conexiune;
	private boolean clientDeconectat;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	//private Sesiune ses;
	
	public Controller(Socket socket) {
		controllerBD=new ControllerBD();
		conexiune=new ConexiuneClient(this,socket);
	}
	
	public void seteazaMesaj(ObjectInputStream in, ObjectOutputStream out) {
		input=in;
		output=out;
	}
	public boolean clientDeconectat() {
		return clientDeconectat;
	}
	
	public String read() {
		try {
			return (String)input.readObject();
		}
		catch(IOException e)   {
			e.printStackTrace();
			clientDeconectat=true;
			return "Citire esuata";
		}
		catch(ClassNotFoundException e)   {
			e.printStackTrace();
			clientDeconectat=true;
			return "Citire esuata";
		}	
	}
	//aici sunt functiile care comunica cu FirClient si ControllerBD
	//adica functiile de aici sunt apelate in fir client si ele apeleaza functii din controller bd
	
	
	public void write(Object obj) {
		try {
			  output.writeObject(obj);
			  System.out.println("Mesaj trimis cu succes");
		}
		catch(IOException e)   {
			e.printStackTrace();
			clientDeconectat=true;
			System.out.println("Mesaj esuat");
		}
		
	}
	

	
	public void verifUser(String user, String parola, Sesiune ses) {
			
			try {
				String msj=controllerBD.verificaUser(user,parola,ses);
				output.writeObject(msj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public void addClient(Client c) {
		try {
			boolean add=controllerBD.addClient(c); //add e true sau false, daca e false, clientul nu poate fi adaugat si se afiseaza o fereastra de dialog
			output.writeObject(add);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void editeazaClient(Client c, Sesiune ses) {
		//boolean add=
		controllerBD.editeazaClient(c,ses); //add e true sau false, daca e false, clientul nu poate fi adaugat si se afiseaza o fereastra de dialog
		//output.writeObject(add);
	}
	
	public boolean locuriLibere(String data) {
		try {
			int locuri=controllerBD.locuriLibere(data);
			boolean mesaj=false;
			if(locuri<0){
				output.writeObject(mesaj);
				return false;
				}
			mesaj=true;
			output.writeObject(mesaj);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void adaugaRezervare(String data, String zonaAleasa,String nrPers,Sesiune ses)
	{
		try{
			boolean ok=controllerBD.adaugaRezervare(data,zonaAleasa,nrPers,ses);
			output.writeObject(ok);// true daca s-a facut rezervarea false altfel
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void adaugaFeedback(String feedback, Sesiune ses) {
		controllerBD.adaugaFeedback(feedback,ses);
	}
	public void veziFeedback() {
		try {
			ArrayList<Feedback> fdb=controllerBD.veziFeedback();
			for(Feedback i:fdb)
			{
				System.out.println("1 "+i.getFeedback()+" "+i.getIdClient());
				output.writeObject(i.getFeedback());
				output.writeObject(i.getIdClient());
			}
			String terminator=new String("%");
			output.writeObject(terminator);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void veziRaport(String data) {
		try {
			Zone z=controllerBD.veziRaport(data);
			output.writeObject(z.getZonaA());
			output.writeObject(z.getZonaB());
			output.writeObject(z.getZonaC());
			//String terminator=new String("%");
			//output.writeObject(terminator);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void trimiteDate() {
		try {
			Client c=controllerBD.trimiteDate();
			String nume=c.getNume();
			String prenume=c.getPrenume();
			String username=c.getUsername();
			String password=c.getPassword();
			output.writeObject(nume);
			output.writeObject(prenume);
			output.writeObject(username);
			output.writeObject(password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() {
		controllerBD.close();
		conexiune.close();
	}




	

}
