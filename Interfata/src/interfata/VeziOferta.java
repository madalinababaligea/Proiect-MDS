package interfata;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.BorderLayout;

public class VeziOferta {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	public VeziOferta() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(255, 222, 173));
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(150, 150, 300, 200);
		frame.getContentPane().add(textPane);
		
		JTextPane txtpnOfertaAllInclusive = new JTextPane();
		txtpnOfertaAllInclusive.setBackground(new Color(245, 222, 179));
		txtpnOfertaAllInclusive.setBounds(20, 21, 201, 43);
		txtpnOfertaAllInclusive.setText("Oferta All Inclusive");
		frame.getContentPane().add(txtpnOfertaAllInclusive);
		
		JTextPane txtpnOfertaFamily = new JTextPane();
		txtpnOfertaFamily.setBackground(new Color(245, 222, 179));
		txtpnOfertaFamily.setText("Oferta Family");
		txtpnOfertaFamily.setBounds(20, 65, 201, 32);
		frame.getContentPane().add(txtpnOfertaFamily);
		
		JTextPane txtpnOferta = new JTextPane();
		txtpnOferta.setBackground(new Color(245, 222, 179));
		txtpnOferta.setText("Oferta Student");
		txtpnOferta.setBounds(21, 107, 159, 32);
		frame.getContentPane().add(txtpnOferta);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}
}
