package interfata;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import client.Controller;

public class Manager {

	private JFrame frame;
	private Controller control;
	
	public Manager(Controller c) {
		control=c;
	
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnFeed = new JButton("Feedback");
		btnFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewFeedback x= new ViewFeedback(control);
			}
		});
		btnFeed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFeed.setBounds(38, 102, 147, 46);
		frame.getContentPane().add(btnFeed);
		
		JButton btnVeziRaport = new JButton("Vezi Raport");
		btnVeziRaport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VeziRaport x= new VeziRaport(control);
			}
		});
		btnVeziRaport.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVeziRaport.setBounds(239, 103, 154, 45);
		frame.getContentPane().add(btnVeziRaport);
		
		frame.setVisible(true);
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}

}
