package spa.Model;

import java.io.Serializable;


public class Client implements Serializable {

    private int id;
    private int numberFacturi;

    public static int generateID(){
        return 0;
    }

    public String getFullName(){
        return "Null";
    }
    public int getId(){
        return id;
    }

    protected void setID(int id){
        this.id = id;
    }

    public void setNumberFacturi(int number){
        numberFacturi = number;
    }

}
