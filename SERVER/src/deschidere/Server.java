package deschidere;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//import clase.Sesiune;

//aici e conexiunea serverului cu clientul
//se porneste un nou fiClient pentru clientul nou car foloseste aplicatia

public class Server {
	ServerSocket serverSocket;
	//Sesiune ses;
	public void start() {
		
		try {
			serverSocket=new ServerSocket(81); // avem nevoie de port
		//	while(true) {
				Socket socket=serverSocket.accept();
				FirClient client=new FirClient(socket);
				client.run();
			//}
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				serverSocket.close();
			}catch(IOException e) {
				e.printStackTrace();
		    }	
		}
	}
}
