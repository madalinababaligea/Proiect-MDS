package spa.View;

import javax.swing.*;

public class DialogsViews extends JFrame {

    private static DialogsViews instance = null;

    public static DialogsViews getInstance(){
        if(instance == null){
            return new DialogsViews();
        }
        return instance;
    }

    public void connectionErrorDialog(){
        JOptionPane.showMessageDialog(this, "Connection Failed");
    }
}
