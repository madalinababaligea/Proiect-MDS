package spa.View;

import spa.Model.Sale;
import spa.Model.Sale;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;


public class RaportProdus {
    private JFrame jframe;
    ArrayList<Sale> saleList;
    String nameProduct = " ";

    RaportProdus(ArrayList<Sale> saleList, String nameProduct){
        this.saleList = saleList;
        this.nameProduct = nameProduct;
        startWindow();
    }

    private void startWindow() {
        jframe = new JFrame("Raport Produs");
        jframe.setPreferredSize(new Dimension(400, 300));
        jframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jframe.add(raportView());
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }

    private JPanel raportView(){
        JPanel form = new JPanel(new BorderLayout());

        JPanel productNamePane = new JPanel();
        productNamePane.setLayout(new FlowLayout(FlowLayout.LEFT));
        productNamePane.setBorder(new EmptyBorder(20, 20, 5, 0));

        JLabel nameLabel = new JLabel("Numele Produsului: " + nameProduct);
        productNamePane.add(nameLabel);

        form.add(productNamePane,BorderLayout.NORTH);


        JScrollPane productScrollList = new JScrollPane(saleTable());
        productScrollList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        productScrollList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        productScrollList.setViewportBorder(new LineBorder(Color.BLACK));

        form.add(productScrollList,BorderLayout.CENTER);

        return form;
    }

    private JPanel saleTable(){

        JPanel salelist = new JPanel();
        BoxLayout boxlayout = new BoxLayout(salelist, BoxLayout.Y_AXIS);
        salelist.setLayout(boxlayout);
        for(int i = 0; i < saleList.size(); i++){
            JPanel saleEntry = new JPanel(new FlowLayout(FlowLayout.LEFT));
            saleEntry.add(new JLabel("Cumparator: "+String.valueOf(saleList.get(i).getBuyer())));
            saleEntry.add(new JLabel("Pret: "+String.valueOf(saleList.get(i).getPret())));
            saleEntry.add(new JLabel("Stoc"+String.valueOf(saleList.get(i).getStock())));
            salelist.add(saleEntry);
        }

        return salelist;

    }

}
