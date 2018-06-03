package deschidere;

import java.net.Socket;

import clase.Client;
import clase.Sesiune;
import controllers.Controller;

public class FirClient implements Runnable{

	Thread t;
	private Controller instanta;
	private Sesiune ses;
	public FirClient(Socket socket) {
		instanta=new Controller(socket);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//aici in principiu se primesc mesajele de la client si se apeleaza functiile necesare pentru
		//prelucrarea informatiilor 
		
		
		while(!instanta.clientDeconectat()) {
			String mesaj=instanta.read();
			if(mesaj.equals("Verifica user") && !instanta.clientDeconectat()) {
				ses.getInstance().clear();
				String user=instanta.read();
				String parola=instanta.read();
				System.out.println("verifica user "+user+" "+parola);
				instanta.verifUser(user,parola,ses);
				System.out.println("a verificat user");
				
				//System.out.println(ses.getInstance().getUsername()+" "+ses.getInstance().getId());
			}
			else if(mesaj.equals("Creeaza cont") && !instanta.clientDeconectat()) {
				//ses.getInstance().clear();
				//System.out.println(ses.getInstance().getUsername()+" "+ses.getInstance().getId());
				String nume=instanta.read();
				String prenume=instanta.read();
				String username=instanta.read();
				String password=instanta.read();
				Client c=new Client(nume, prenume, username, password);
				instanta.addClient(c);
			}
			else if(mesaj.equals("Editeaza client") && !instanta.clientDeconectat()) {
				String nume=instanta.read();
				String prenume=instanta.read();
				String username=instanta.read();
				String password=instanta.read();
				Client c=new Client(nume, prenume, username, password);
				instanta.editeazaClient(c,ses);
			}
			//pentru alege oferta trebuie si un calendar, se va trimite in ordinea asta: mesaj, data, zona aleasa
			else if(mesaj.equals("Adauga rezervare") && !instanta.clientDeconectat()) {
				String data= instanta.read();
				String zonaAleasa=instanta.read();
				String nrPers=instanta.read();
				boolean locuriLibere=instanta.locuriLibere(data);
				if(locuriLibere) {
					instanta.adaugaRezervare(data, zonaAleasa,nrPers,ses);
				}
			}
			else if(mesaj.equals("Adauga feedback") && !instanta.clientDeconectat()) {
				String feedback=instanta.read();
				instanta.adaugaFeedback(feedback, ses);
			}
			else if(mesaj.equals("Vezi feedback") && !instanta.clientDeconectat()) {
				instanta.veziFeedback();
			}
			else if(mesaj.equals("Vezi raport") &&!instanta.clientDeconectat()) {
				String data=instanta.read();
				instanta.veziRaport(data);
			}
		}
	}
	

}
