package spa.controllers;

import spa.Model.*;
import spa.dao.DataBaseConnection;

import java.util.ArrayList;


public class DatabaseController {

    DataBaseConnection dataBaseConnection;

    public DatabaseController(){
        dataBaseConnection = new DataBaseConnection();
    }

    public ArrayList<Client> getCustomers(){
            return dataBaseConnection.selectClients();
    }

    public ArrayList<Product> getProducts(){
        return dataBaseConnection.selectProducts();
    }

    public void exportCustomerList(Customer customer) {
        dataBaseConnection.insertCustomer(customer);
        System.out.println("Serialized data is saved in the database");
    }

    public void exportCompanyList(Company company) {
        dataBaseConnection.insertCompany(company);
        System.out.println("Serialized data is saved in the database");
    }

    public void exportProductList(Product product) {
        dataBaseConnection.insertProduct(product);
        System.out.println("Serialized data is saved in the database");
    }

    public void exportFacturaList(Factura factura, int idClient) {
        dataBaseConnection.insertFactura(factura, idClient);
        System.out.println("Serialized data is saved in the database");
    }

    public Product hasProduct(String message){
        return dataBaseConnection.hasProduct(message);
    }

    public Product hasProduct(int product){
        return dataBaseConnection.hasProduct(product);
    }

    public ArrayList<Factura> getRaport(int client){
        return dataBaseConnection.getRaport(client);
    }

    public ArrayList<Sale> getRaportProduct(int product){
        return dataBaseConnection.getRaportProduct(product);
    }

    public boolean editProduct(int idProduct, double stock, double pret){
        boolean bool = dataBaseConnection.editProduct(idProduct, stock, pret);
        if(stock != 0)
            dataBaseConnection.addSale(idProduct, stock, pret, "APROVIZIONARE");
        return bool;
    }

    public void deleteProduct(int idProdus){
        dataBaseConnection.deleteProduct(idProdus);
    }

    public void editCustomer(int idClient, String name, String surname){
        dataBaseConnection.editCustomer(idClient, name, surname);
    }

    public void editCompany(int idClient, String name){
        dataBaseConnection.editCompany(idClient, name);
    }

    public void close(){
        dataBaseConnection.close();
    }

}
