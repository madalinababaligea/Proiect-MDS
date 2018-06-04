package spa.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;


public class ProductUI {

    private JFrame jframe;
    Controller control;
    MainUI mainUI;
    boolean type = false;

    ProductUI(Controller control, MainUI ui){
        this.control = control;
        this.mainUI = ui;
        startWindow();

    }

    private void startWindow() {
        jframe = new JFrame("Produs Nou");
        jframe.setPreferredSize(new Dimension(400, 450));
        jframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jframe.add(productForm());
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }

    private JPanel productForm() {
        JPanel productForm = new JPanel(new BorderLayout());

        //WINDOW TITLE
        JLabel newProductText = new JLabel("Adaugati Produs Nou");
        newProductText.setBorder(new EmptyBorder(20, 20, 10, 20));
        productForm.add(newProductText, BorderLayout.NORTH);

        //FORM INFOMATION
        JPanel form = new JPanel();
        BoxLayout boxlayout = new BoxLayout(form, BoxLayout.Y_AXIS);
        form.setLayout(boxlayout);

        //NAME PANE
        FlowLayout experimentLayout = new FlowLayout(FlowLayout.LEFT);

        JPanel nameProductPane = new JPanel();
        nameProductPane.setLayout(experimentLayout);
        nameProductPane.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel nameProduct = new JLabel("Numele Produsului:");
        JTextField nameProductTextField = new JTextField();
        nameProductTextField.setPreferredSize(new Dimension(200, 24));

        nameProductPane.add(nameProduct);
        nameProductPane.add(nameProductTextField);

        //QUANTITY PANE

        JPanel productQuantityPane = new JPanel();
        productQuantityPane.setLayout(experimentLayout);
        productQuantityPane.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel productQuantity = new JLabel("Cantitate:");
        JTextField productQuantityTextField = new JTextField();
        productQuantityTextField.setPreferredSize(new Dimension(200,24));

        productQuantityPane.add(productQuantity);
        productQuantityPane.add(productQuantityTextField);


        //PRICE PANE

        JPanel pricePane = new JPanel();
        pricePane.setLayout(experimentLayout);
        pricePane.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel productPrice = new JLabel("Pret:");
        JTextField productPriceTextField = new JTextField();
        productPriceTextField.setPreferredSize(new Dimension(100,24));
        JLabel productRON = new JLabel ("RON");

        pricePane.add(productPrice);
        pricePane.add(productPriceTextField);
        pricePane.add(productRON);



        // PRODUCT OR SERVICE PANE

        JPanel servicePane = new JPanel(new FlowLayout());

        servicePane.add(new JLabel("Serviciu:"));
        final JCheckBox chkService = new JCheckBox("Serviciu");

        chkService.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                type = true;
            }
        });

        servicePane.add(chkService);

        form.add(nameProductPane);
        form.add(productQuantityPane);
        form.add(pricePane);
        form.add(servicePane);

        productForm.add(form, BorderLayout.CENTER);



        //CLEAR AND SAVE BUTTONS
        JPanel operationButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        operationButtons.setBorder(new EmptyBorder(5, 0, 20, 20));
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean valid = true;
                if(nameProductTextField.getText().equals("")){
                    valid = false;
                    JOptionPane.showMessageDialog(jframe,
                            "Campul Numele Produsului invalid",
                            "Eroare validare",
                            JOptionPane.ERROR_MESSAGE);
                }
                if(!type && productQuantityTextField.getText().equals("")){
                    valid = false;
                    JOptionPane.showMessageDialog(jframe,
                            "Campul Cantitate invalid",
                            "Eroare validare",
                            JOptionPane.ERROR_MESSAGE);
                }
                if(productPriceTextField.getText().equals("")) {
                    valid = false;
                    JOptionPane.showMessageDialog(jframe,
                            "In viata nimic nu este gratis.",
                            "Eroare validare",
                            JOptionPane.ERROR_MESSAGE);
                }
                if(valid) {
                    if (control.checkProductExistance(nameProductTextField.getText())) {
                        if(type == true){
                            control.addProduct(nameProductTextField.getText(), "0.0", productPriceTextField.getText(), type);
                        }
                        else {
                            control.addProduct(nameProductTextField.getText(), productQuantityTextField.getText(), productPriceTextField.getText(), type);
                        }
                        jframe.dispose();
                    }
                }

            }
        });
        operationButtons.add(saveButton);

        productForm.add(operationButtons, BorderLayout.SOUTH);

        return productForm;

    }
}
