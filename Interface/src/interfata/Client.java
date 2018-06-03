package interfata;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import client.Controller;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	private Controller control;
	
	public Client(Controller c) {
		control=c;
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAlegeOferta = new JButton("Alege Oferta");
		btnAlegeOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlegeOferta x=new AlegeOferta(control);
			}
		});
		btnAlegeOferta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlegeOferta.setBounds(35, 72, 149, 58);
		frame.getContentPane().add(btnAlegeOferta);
		
		JButton btnEditareProfil = new JButton("Editare Profil");
		btnEditareProfil.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEditareProfil.setBounds(237, 72, 149, 58);
		frame.getContentPane().add(btnEditareProfil);
		
		JButton btnFeedback = new JButton("Feedback");
		btnFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Feedback x= new Feedback(control);
				
			}
		});
		
		btnFeedback.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFeedback.setBounds(277, 205, 149, 46);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnFeedback);
		
		frame.setVisible(true);
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();

}
}
