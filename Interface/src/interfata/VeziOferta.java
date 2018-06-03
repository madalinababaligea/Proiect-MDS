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
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnOfertaAllInclusive = new JTextPane();
		txtpnOfertaAllInclusive.setEditable(false);
		txtpnOfertaAllInclusive.setBackground(new Color(245, 222, 179));
		txtpnOfertaAllInclusive.setBounds(20, 21, 201, 43);
		txtpnOfertaAllInclusive.setText("Oferta All Inclusive");
		frame.getContentPane().add(txtpnOfertaAllInclusive);
		
		JTextPane txtpnOfertaFamily = new JTextPane();
		txtpnOfertaFamily.setEditable(false);
		txtpnOfertaFamily.setBackground(new Color(245, 222, 179));
		txtpnOfertaFamily.setText("Oferta Family");
		txtpnOfertaFamily.setBounds(20, 65, 201, 32);
		frame.getContentPane().add(txtpnOfertaFamily);
		
		JTextPane txtpnOferta = new JTextPane();
		txtpnOferta.setEditable(false);
		txtpnOferta.setBackground(new Color(245, 222, 179));
		txtpnOferta.setText("Oferta Student");
		txtpnOferta.setBounds(21, 107, 159, 32);
		frame.getContentPane().add(txtpnOferta);
		frame.setBounds(150, 150, 300, 200);
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}
}
