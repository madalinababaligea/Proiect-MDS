package interfata;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import client.Controller;

public class Login {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	private Controller control;
	
	public Login(Controller c) {
		control=c;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNume = new JLabel("Username");
		lblNume.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNume.setBounds(10, 72, 90, 37);
		frame.getContentPane().add(lblNume);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(10, 138, 90, 30);
		frame.getContentPane().add(lblPassword);
		
		username = new JTextField();
		username.setBounds(127, 72, 151, 32);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = username.getText();
				char[] pass= password.getPassword();
				String p= new String();
				for(int i=0;i<pass.length;i++)
				{
					p=p+pass[i];
				}
				int nr=control.verificaUser(user,p);
				if(nr==1) {
					frame.dispose();
					Client c=new Client(control);
					System.out.println("Clinet");
				}
				else
				{
					if(nr==2)
					{
						frame.dispose();
						Manager m= new Manager(control);
						System.out.println("Manager");
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Username/Parola incorecte","Login nereusit",JOptionPane.ERROR_MESSAGE);
						
					}
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(283, 196, 107, 37);
		frame.getContentPane().add(btnLogin);
		
		password = new JPasswordField();
		password.setBounds(127, 137, 151, 30);
		frame.getContentPane().add(password);
		
		frame.setVisible(true);
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		
		
		}
}
