package interfata;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import client.Controller;

public class AlegeOferta {

	private JFrame frame;
	private Controller control;
	private JTextField nrloc;
	public AlegeOferta(Controller c) {
	
		control=c;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		frame.getContentPane().setLayout(null);
		
		JDateChooser d=new JDateChooser();
		d.setBounds(128, 31, 129, 46);
		frame.getContentPane().add(d);
		
		JLabel lblAlegeData = new JLabel("Alege Data:");
		lblAlegeData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAlegeData.setBounds(10, 38, 121, 39);
		frame.getContentPane().add(lblAlegeData);
		
		JLabel lblNrDeLocuri = new JLabel("Nr. de locuri");
		lblNrDeLocuri.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNrDeLocuri.setBounds(10, 87, 112, 30);
		frame.getContentPane().add(lblNrDeLocuri);
		
		nrloc = new JTextField();
		nrloc.setBounds(132, 96, 96, 19);
		frame.getContentPane().add(nrloc);
		nrloc.setColumns(10);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.setBounds(132, 145, 67, 81);
		
		DefaultListModel x= new DefaultListModel();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Zona A", "", "Zona B", "", "Zona C"};
			public int getSize() {
				return values.length;
				}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		frame.getContentPane().add(list);
		
		JButton btnRezerva = new JButton("Rezerva");
		btnRezerva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df= new SimpleDateFormat("yyyy-mm-dd");
				String s= df.format(d.getDate());
				String nloc=nrloc.getText();
				String zona=(String) list.getSelectedValue();
				System.out.println(zona);
				boolean mesaj2=control.adaugaRezervare(s,zona,nloc);
				if (mesaj2==true)
					{System.out.println("Rezervare cu succes");
					frame.dispose();
					}
				else JOptionPane.showMessageDialog(frame, "Nu exista locuri suficiente.","Rezervare nereusita.",JOptionPane.ERROR_MESSAGE);
				
			}
		
		});
		
		btnRezerva.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRezerva.setBounds(288, 193, 112, 39);
		frame.getContentPane().add(btnRezerva);
		
	}
}
