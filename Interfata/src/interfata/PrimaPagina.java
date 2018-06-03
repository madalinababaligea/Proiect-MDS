package interfata;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//import client.Controller;

public class PrimaPagina {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	public PrimaPagina() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JButton btnVeziOferta = new JButton("Vezi Oferta");
		btnVeziOferta.setForeground(Color.BLACK);
		btnVeziOferta.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnVeziOferta.setBackground(Color.BLACK);
		btnVeziOferta.setBounds(58, 74, 151, 66);
		btnVeziOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VeziOferta x = new VeziOferta ();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnVeziOferta);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(230, 74, 141, 35);
		frame.getContentPane().add(btnLogin);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.setBounds(230, 107, 141, 35);
		frame.getContentPane().add(btnSignup);
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}
}
