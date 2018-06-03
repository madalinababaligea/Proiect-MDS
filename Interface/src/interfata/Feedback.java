package interfata;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import client.Controller;

public class Feedback {

	private Controller control;
	private JFrame frame;

	public Feedback(Controller c) {
		control=c;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPentruAImbunatatii = new JLabel("Pentru a imbunatatii calitatea serviciilor noastre, \r\n");
		lblPentruAImbunatatii.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPentruAImbunatatii.setBounds(10, 10, 364, 29);
		frame.getContentPane().add(lblPentruAImbunatatii);
		
		JLabel lblVaRugamLasativa = new JLabel("va rugam lasati-va opiniile mai jos.\r\n(max 100 caractere)");
		lblVaRugamLasativa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVaRugamLasativa.setBounds(10, 37, 405, 29);
		frame.getContentPane().add(lblVaRugamLasativa);
		
		JTextArea text = new JTextArea();
		text.setBounds(10, 76, 393, 141);
		frame.getContentPane().add(text);
		
		JButton trimitere = new JButton("Trimite");
		trimitere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				String x=text.getText();
				control.addFeedBack(x);
				
			}
		});
		trimitere.setFont(new Font("Tahoma", Font.PLAIN, 15));
		trimitere.setBounds(302, 227, 101, 24);
		frame.getContentPane().add(trimitere);
		frame.setVisible(true);
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}
}
