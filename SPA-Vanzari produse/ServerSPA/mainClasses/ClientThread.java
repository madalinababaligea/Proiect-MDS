package spa.mainClasses;

import spa.Model.Company;
import spa.Model.Customer;
import spa.Model.Factura;
import spa.Model.Product;
import spa.controllers.Controller;

import java.net.Socket;


public class ClientThread implements Runnable {

    Thread t;
    private Controller instance;

    public ClientThread(Socket socket){
        instance = new Controller(socket);
    }

    @Override
    public void run() {
        while(!instance.clientDisconected()){
            String message = instance.read();
            System.out.println(message);
            if(instance.wantsClientList(message) && !instance.clientDisconected()){
                instance.sendsClientList();
            }
            else if(instance.wantsToAddCustomer(message) && !instance.clientDisconected()){
                Customer customer = instance.readCustomer();
                instance.addCustomer(customer);
            }
            else if(instance.wantsToAddCompany(message) && !instance.clientDisconected()){
                Company company = instance.readCompany();
                instance.addCompany(company);
            }
            else if(instance.wantsProductList(message) && !instance.clientDisconected()){
                instance.sendsProductList();
            }
            else if(instance.wantsToAddProduct(message) && !instance.clientDisconected()){
                Product product = instance.readProduct();
                instance.addProduct(product);
            }
            else if(instance.wantsRaportForPerson(message) && !instance.clientDisconected()){
                int client = instance.readInt();
                instance.getRaport(client);
            }
            else if(instance.existsProduct(message) && !instance.clientDisconected()){
                String product = instance.read();
                System.out.println(product);
                instance.hasProduct(product);
            }
            else if(instance.wantsToAddFactura(message) && !instance.clientDisconected()){
                Factura factura = instance.readFactura();
                int idClient = instance.readInt();
                instance.addFactura(factura, idClient);
            }
            else if(instance.wantsToEditProducts(message) && !instance.clientDisconected()){
                int idProduct = instance.readInt();
                double stock = instance.readDouble();
                double pret = instance.readDouble();
                System.out.println(stock);
                System.out.println(pret);
                instance.editProduct(idProduct, stock, pret);
            }
            else if (instance.wantsToDelete(message) && !instance.clientDisconected()){
                int idProdus = instance.readInt();
                instance.deleteProduct(idProdus);
            }
            else if (instance.wantsToEditClient(message) && !instance.clientDisconected()){
                int id = instance.readInt();
                if(Company.isCompany(id)){
                    String name = instance.read();
                    instance.editCompany(id, name);
                }
                else if(Customer.isCustomer(id)){
                    String name = instance.read();
                    String surname = instance.read();
                    instance.editCustomer(id, name, surname);
                }
            }
            else if(instance.wantsProductRaport(message) && !instance.clientDisconected()){
                int product = instance.readInt();
                instance.getRaportProduct(product);
            }
        }
        close();
    }

    public void close(){
        instance.close();
    }
}
