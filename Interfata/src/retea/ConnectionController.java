/*package retea;

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
			socket = new Socket("10.10.5.228", 81);
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
	
	//Aici vor fi functiile care trimit mesaje catre server si , cand este cazul, preia date de la
	//server. Mai jos sunt modele de functii
	//sendProfesor->instiinteaza serverul ca vrea sa adauge un profesor si ii trmite dupa si datele 
	//extrase din text field-uri, in cazul asta doar numele si prenumele.
	
	//sendElev, ca la sendProfesor
	
	//sendDelogare doar il instiintez ca vreau sa ma deloghez
	
	//verifUser verifica daca datele introduse la logare sunt corecte, si in cazul asta, clientul va 
	//primi mesaj de la server daca este sau nu corect. daca nu este corect, se va afisa o alerta
	
	//la veriElev am vrut sa vedem informatii despre anumiti elevi si clientul trimitea id-ul pentru 
	//a vedea daca exista acel elev
	
	//addDisciplina, addNota: adauga note si discipline
	
	//veziAbsenta:server trimite toate absentele unui elev, clientul le pune intr-un arrayList, ca 
	//ulterior sa le afiseze in tabel
	//veziProf, veziElev si veziNota, ca la veziAbsenta
	
	
	/*public void sendProfesor(String n,String p) {
		try {
			output.writeObject("Adauga profesor");
			output.writeObject(n);
			output.writeObject(p);
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}
	public void sendElev(String n,String p) {
		try {
			output.writeObject("Adauga elev");
			output.writeObject(n);
			output.writeObject(p);
		}catch(IOException ee) {
			ee.printStackTrace();
		}
	
	}
	
	public void sendDelogare() {
		try {
			output.writeObject("Delogare");
		}catch(IOException ee) {
			ee.printStackTrace();
		}
	
	}
	
	
	public int verifUser(String user,String parola) {
		try {
			output.writeObject("Verifica user");
			output.writeObject(user);
			output.writeObject(parola); 
			String mesaj=(String) input.readObject();
			if(mesaj!=null && mesaj.equals("Profesor"))return 1;
			else if(mesaj!=null && mesaj.equals("Director")) return 2;
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
	public boolean veriElev(String id) {
		try {
			output.writeObject("Vezi detalii");
			output.writeObject(id);
			boolean mesaj=(boolean) input.readObject();
			System.out.println("Am ajuns in veriElev din CC "+mesaj);
			if(mesaj==true)
				return true;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean addDisciplina(String nume, String id) {
		try {
			output.writeObject("Adauga disciplina");
			output.writeObject(nume);
			output.writeObject(id); 
			boolean mesaj=(boolean) input.readObject();
			if(mesaj==true) return true;
			return false;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public boolean addNota(String nota, String id) {
		try {
			output.writeObject("Adauga nota");
			output.writeObject(nota);
			output.writeObject(id); 
			boolean mesaj=(boolean) input.readObject();
			if(mesaj==true) 
				  {
				boolean mesaj2=(boolean) input.readObject();
				 if(mesaj2==true) return true;
			 }

			return false;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	public Elev veziElevC(String idElev) {
		Elev el=new Elev();
		try {
			System.out.println("A ajuns in veziElevC inainte sa citeasca nume si prenum");
			String nume=(String) input.readObject();
			String prenume=(String) input.readObject();
			el.setNume(nume);
			el.setPrenume(prenume);
			System.out.println("Am ajuns in vezi elevC din CC "+nume+" " +prenume);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return el;
		
	}
	public ArrayList<Absenta> veziAbsenta(){
		ArrayList<Absenta> abs=new ArrayList<Absenta>();
		String data;
		try {
			data = (String) input.readObject();
			while(!data.equals("&")) {
				String disciplina=(String) input.readObject();
				Absenta a=new Absenta(disciplina,data);
				abs.add(a);
				data=(String)input.readObject();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return abs;
	}
	public ArrayList<Profesor> veziProf(){
		
		ArrayList<Profesor> profi=new ArrayList<Profesor>();
		try {
			output.writeObject("Vezi profi");
			String nume=(String)input.readObject();
			while(!nume.equals("%")) {
				String prenume=(String)input.readObject();
				String disciplina=(String) input.readObject();
				Profesor p=new Profesor(nume,prenume,disciplina);
				profi.add(p);
				nume=(String)input.readObject();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profi;
		
	}
	public ArrayList<Elev> veziElev(){
		
		ArrayList<Elev> elevi=new ArrayList<Elev>();
		try {
			output.writeObject("Vezi elevi");
			String nume=(String)input.readObject();
			int id=1;
			while(!nume.equals("%")) {
				String prenume=(String)input.readObject();
				Elev e=new Elev(nume,prenume,id);
				elevi.add(e);
				nume=(String)input.readObject();
				id++;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elevi;
	}
	public ArrayList<Nota> veziNota(){
		ArrayList<Nota> note=new ArrayList<Nota>();
		try {
			String idP=(String) input.readObject();
			while(!idP.equals("%")) {
				String n=(String) input.readObject();
				float nota=Float.parseFloat(n);
				String disciplina=(String) input.readObject();
				Nota nt=new Nota(idP,nota, disciplina);
				note.add(nt);
				idP=(String) input.readObject();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return note;
	}
	public boolean addAbs(String id, String data) {
		try {
			output.writeObject("Adauga absenta");
			output.writeObject(id);
			output.writeObject(data); 
			boolean mesaj=(boolean) input.readObject();
			if(mesaj==true) 
				  {
				boolean mesaj2=(boolean) input.readObject();
				 if(mesaj2==true) return true;
			 }

			return false;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*public ArrayList<Profesor> veziProf(){
		try {
			ArrayList <Profesor> lista=new ArrayList<Profesor>();
			output.writeObject("Vezi profi");
			System.out.println("A ajuns in vezi prof");
			lista=(ArrayList<Profesor>) input.readObject();
			System.out.println("A facut readObject");
			for(Profesor i:lista)
				System.out.println(i.getNume()+" "+i.getPrenume());
			return lista;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/

