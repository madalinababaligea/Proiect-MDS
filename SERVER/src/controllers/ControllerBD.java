package controllers;

import java.util.ArrayList;

import clase.Client;
import clase.Feedback;
import clase.Sesiune;
import clase.Zone;
import conexiuneBD.ConexiuneBD;


public class ControllerBD {
	ConexiuneBD conexiuneBD;
	
	
	public ControllerBD() {
		conexiuneBD=new ConexiuneBD();
	}
	
	//functiile de aici comunica cu ConexiuneBD unde se face conexiunea efectiva la baza de date 
	//si sunt prelucrate date
	
	public String verificaUser(String username, String parola,Sesiune ses) {
		return conexiuneBD.selectUser(username, parola,ses);
	}
	
	public boolean addClient(Client c) {
		return conexiuneBD.addClient(c);
	}
	public boolean editeazaClient(Client c,Sesiune ses) {
		return conexiuneBD.editeazaClient(c,ses);
	}
	public int locuriLibere(String data) {
		return conexiuneBD.locuriLibere(data);
	}
	public boolean adaugaRezervare(String data, String zonaAleasa, String nrPers,Sesiune ses) {
		return conexiuneBD.adaugaRezervare(data,zonaAleasa,nrPers,ses);
	}
	public void adaugaFeedback(String feedback, Sesiune ses) {
		adaugaFeedback(feedback,ses);
	}
	public ArrayList<Feedback> veziFeedback() {
		return conexiuneBD.veziFeedback();
	}
	public ArrayList<Zone> veziRaport(String data){
		return conexiuneBD.veziRaport(data);
	}

	public void close() {
		conexiuneBD.close();
	}
	
	
	
}
