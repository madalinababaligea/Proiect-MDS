/*package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import retea.ConnectionController;

public class Controller {
	
//	private Fereastra f=new Fereastra(this);
	//private PrimaPagina p1 = new PrimaPagina(this);
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private static Controller instance;
	
	public Controller() {
			ConnectionController.getInstance();
		//	socket=new Socket("192.168.2.119",81);
		//	out= new ObjectOutputStream(socket.getOutputStream());
		//	out.writeObject("Buna server");
		//	in= new ObjectInputStream(socket.getInputStream());
			//out.flush();
			//out.close();	
	}
	
	//aici nici noi nu prea am inteles utilitatea clasei asteia. dar in principiu controllerul apeleaza
	//metodele din clasa ConnectionController iar in connteciontCotroller se intampla prelucrarea
	//efectiva
	
	//au acelasi nume toate functiile de prelucrare din controller si ConnectionController pentru a 
	//nu ne incurca
	
	//addProf
	
	/*public int verificaUser(String username, String password) {
		return ConnectionController.getInstance().verifUser(username,password);
	
	}
	
	
	
	
	public void addProf(String numeProf, String prenumeProf){     
        ConnectionController.getInstance().sendProfesor(numeProf,prenumeProf);       
        // importProfList(); // face un refresh - vedem daca e nevoie de el sau nu // eventual pt see profi
    }
	public void delogare(){     
        ConnectionController.getInstance().sendDelogare();       
       
    }
	public ArrayList<Profesor> veziProf(){
		return ConnectionController.getInstance().veziProf();
	}
	public ArrayList<Elev> veziElev(){
		return ConnectionController.getInstance().veziElev();
	}
	public Elev veziElevC(String idElev){
		return ConnectionController.getInstance().veziElevC(idElev);
	}
	public ArrayList<Nota> veziNota(){
		return ConnectionController.getInstance().veziNota();
	}
	public ArrayList<Absenta> veziAbsenta(){
		return ConnectionController.getInstance().veziAbsenta();
	}
	// add Elev
    public void addElev(String numeElev, String prenumeElev){
       // Elev e = new Elev(numeElev, prenumeElev,discipline);
        ConnectionController.getInstance().sendElev(numeElev,prenumeElev);
   ///     importProductList();
    }
	// add Discipline
    public boolean addDisciplina(String nume, String id) {
		return ConnectionController.getInstance().addDisciplina(nume,id);
	}
    
    public boolean addNota(String nota, String id) {
		return ConnectionController.getInstance().addNota(nota,id);
	}
    public boolean veriElev(String idElev) {
    	return ConnectionController.getInstance().veriElev(idElev);
    }
    public boolean addAbs(String id, String data) {
		return ConnectionController.getInstance().addAbs(id,data);
	}
    
    //Note
    //Absente
	*/
    /*
    
 
    
    
    
    
    
    
	
	public static Controller getInstance() {
		if(instance==null)
			instance= new Controller();
		return instance;
	}*/
	/*public Socket getSocket() {
		return socket;
	}
	public ObjectInputStream getIn() {
		return in;
	}
	public ObjectOutputStream getOut() {
		return out;
	}
	/*public void close() {
		try {
			socket.close();
			in.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	


