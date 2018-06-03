package interfata;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client.Controller;

public class SignUp {

	private JFrame frame;
	
	private JTextField nume;
	private JTextField prenume;
	private JTextField username;
	private JTextField password;
	private Controller control;

	public SignUp(Controller c) {
		control=c;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Idnume = new JLabel("Nume");
		Idnume.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Idnume.setBounds(20, 46, 83, 22);
		frame.getContentPane().add(Idnume);
		
		JLabel Idprenume = new JLabel("Prenume");
		Idprenume.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Idprenume.setBounds(20, 100, 83, 27);
		frame.getContentPane().add(Idprenume);
		
		JLabel Idusername = new JLabel("Username");
		Idusername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Idusername.setBounds(20, 150, 83, 22);
		frame.getContentPane().add(Idusername);
		
		JLabel Idpassword = new JLabel("Password");
		Idpassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Idpassword.setBounds(20, 196, 83, 22);
		frame.getContentPane().add(Idpassword);
		
		nume = new JTextField();
		nume.setBounds(118, 47, 119, 27);
		frame.getContentPane().add(nume);
		nume.setColumns(10);
		
		prenume = new JTextField();
		prenume.setBounds(118, 100, 119, 26);
		frame.getContentPane().add(prenume);
		prenume.setColumns(10);
		
		username = new JTextField();
		username.setBounds(118, 152, 122, 26);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(118, 196, 122, 27);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name= nume.getText();
				String pren=prenume.getText();
				String user = username.getText();
				String pass= password.getText();
				
				boolean nr=control.addClient(name, pren,user,pass);
				if (nr==true) 
				{
					frame.dispose();
					Client cl= new Client(control);
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Username/Parola incorecte","Login nereusit",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSignUp.setBounds(293, 184, 109, 47);
		frame.getContentPane().add(btnSignUp);
		
		frame.setVisible(true);
		
	}

}
