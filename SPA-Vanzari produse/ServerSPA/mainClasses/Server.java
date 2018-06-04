package spa.mainClasses;

import spa.ConnectionData;
import spa.controllers.Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket serverSocket;

    public void start(){
        try {
            serverSocket = new ServerSocket(ConnectionData.port);
            while (true){
                Socket socket = Controller.acceptConnection(serverSocket);
                ClientThread clientThread = new ClientThread(socket);
                clientThread.run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
