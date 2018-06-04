package interfata;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clase.Utilizator;
import client.Controller;

public class EditareProfil {

	private JFrame frame;
	private JTextField nume;
	private JTextField prenume;
	private JTextField username;
	private JTextField parola;
	private Controller control;

	public EditareProfil(Controller c, Utilizator cl) {
		control=c;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNume.setBounds(25, 47, 66, 22);
		frame.getContentPane().add(lblNume);
		
		JLabel lblPrenume = new JLabel("Prenume");
		lblPrenume.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrenume.setBounds(25, 97, 80, 22);
		frame.getContentPane().add(lblPrenume);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblParola.setBounds(25, 198, 66, 22);
		frame.getContentPane().add(lblParola);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(25, 146, 90, 25);
		frame.getContentPane().add(lblUsername);
		
		nume = new JTextField();
		nume.setBounds(134, 52, 110, 19);
		frame.getContentPane().add(nume);
		nume.setColumns(10);
		
		nume.setText(cl.getNume());
		
		prenume = new JTextField();
		prenume.setBounds(134, 102, 110, 19);
		frame.getContentPane().add(prenume);
		prenume.setColumns(10);
		prenume.setText(cl.getPrenume());
		
		username = new JTextField();
		username.setEditable(false);
		username.setBounds(134, 152, 110, 19);
		frame.getContentPane().add(username);
		username.setColumns(10);
		username.setText(cl.getUsername());
		
		parola = new JTextField();
		parola.setBounds(134, 203, 110, 19);
		frame.getContentPane().add(parola);
		parola.setColumns(10);
		parola.setText(cl.getPassword());
		
		JButton btnEditare = new JButton("Editare");
		btnEditare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String	name= nume.getText();
			String user= username.getText();
			String pren= prenume.getText();
			String pass= parola.getText();
			
			control.EditeazaClient(name, pren, user,pass);
			frame.dispose();
			}
		});
		btnEditare.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEditare.setBounds(303, 198, 104, 38);
		frame.getContentPane().add(btnEditare);
		
		frame.setVisible(true);
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}
}
