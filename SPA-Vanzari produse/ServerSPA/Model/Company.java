package spa.Model;

import java.io.Serializable;

public class Company extends Client implements Serializable{

    private String name;
    transient private static final int minID = 0;
    transient private static final int maxID = 1000;

    public static boolean isCompany(int id){
        if(minID < id && id < maxID)
            return true;
        return false;
    }

    public static int generateID(){
        int range = (maxID - minID) + 1;
        return (int)(Math.random() * range) + minID;
    }

    public Company(String name, int id){
        super();
        this.name = name;
        setID(id);
    }

    public String getFullName() {
        return name;
    }
}
