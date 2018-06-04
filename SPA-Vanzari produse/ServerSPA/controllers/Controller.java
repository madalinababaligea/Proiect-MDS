package spa.controllers;

import spa.Model.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Controller {

    private DatabaseController databaseController;
    private ClientConnection connection;
    private MessageInterpreter messageInterpreter;

    public Controller(Socket socket){
        databaseController = new DatabaseController();
        connection = new ClientConnection(this, socket);
    }

    public static Socket acceptConnection( ServerSocket serverSocket){
        try {
            return serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setUpMessage(ObjectInputStream input, ObjectOutputStream output){
        messageInterpreter = new MessageInterpreter(input, output);
    }

    public String read(){
        return messageInterpreter.getMessage();
    }

    public int readInt(){return messageInterpreter.getInt();}

    public double readDouble(){return messageInterpreter.getDouble();}

    public void write(Object object){
        if(!messageInterpreter.writeObject(object))
            System.out.println(" - Message sent failed");
        else System.out.println(" - Message sent successful ");
    }

    public ArrayList<Client> getCustomers(){
        return databaseController.getCustomers();
    }

    public ArrayList<Product> getProducts(){
        return databaseController.getProducts();
    }

    public boolean wantsClientList(String message){
        return messageInterpreter.wantsClientList(message);
    }

    public boolean wantsProductList(String message){
        return messageInterpreter.wantsProductList(message);
    }

    public void sendsClientList(){
        write(getCustomers());
    }

    public void sendsProductList(){
        write(getProducts());
    }

    public void addCustomer(Customer customer){
        databaseController.exportCustomerList(customer);
    }

    public void addCompany(Company company){
        databaseController.exportCompanyList(company);
    }

    public void addProduct(Product product){databaseController.exportProductList(product);}

    public void addFactura(Factura factura, int idClient){databaseController.exportFacturaList(factura, idClient);}

    public boolean clientDisconected(){
        return messageInterpreter.isClientDisconected();
    }

    public boolean wantsToAddCustomer(String message){
        return messageInterpreter.wantsToAddCustomer(message);
    }

    public boolean wantsToAddCompany(String message){
        return messageInterpreter.wantsToAddCompany(message);
    }

    public boolean wantsToAddProduct(String message){
        return messageInterpreter.wantsToAddProduct(message);
    }

    public boolean wantsToAddFactura(String message){
        return messageInterpreter.wantsToAddFactura(message);
    }

    public boolean wantsRaportForPerson(String message){
        return messageInterpreter.wantsRaportForPerson(message);
    }

    public boolean wantsToEditProducts(String message){
        return messageInterpreter.wantsToEditProducts(message);
    }

    public boolean wantsToDelete(String message){
        return messageInterpreter.wantsToDelete(message);
    }

    public boolean wantsProductRaport(String message){
        return messageInterpreter.wantsProductRaport(message);
    }

    public boolean wantsToEditClient(String message){
        return messageInterpreter.wantsToEditClient(message);
    }

    public void getRaport(int client){
        write(databaseController.getRaport(client));
    }

    public void getRaportProduct(int product){
        write(databaseController.getRaportProduct(product));
    }

    public void editProduct(int idProduct, double stock, double pret){
        if(databaseController.editProduct(idProduct, stock, pret))
            System.out.println("EDITAREA S-A REALIZAT CU SUCCES");
        else System.out.println("EROARE LA EDITARE");
    }

    public Customer readCustomer(){
        return messageInterpreter.getReadCustomer();
    }

    public Company readCompany(){
        return messageInterpreter.getReadCompany();
    }

    public Product readProduct(){return messageInterpreter.getReadProduct();}

    public Factura readFactura(){return messageInterpreter.getReadFactura();}

    public boolean existsProduct(String message){
        return messageInterpreter.existsProduct(message);
    }

    public void hasProduct(String message){
         write(databaseController.hasProduct(message));
    }

    public void deleteProduct(int idProdus){
        databaseController.deleteProduct(idProdus);
    }

    public void editCustomer(int idClient, String name, String surname){
        databaseController.editCustomer(idClient, name, surname);
    }

    public void editCompany(int idClient, String name){
        databaseController.editCompany(idClient, name);
    }

    public void close(){
        databaseController.close();
        connection.close();
    }
}
