package interfata;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.jfree.ui.RefineryUtilities;

import com.toedter.calendar.JDateChooser;

import clase.Zona;
import client.Controller;

public class VeziRaport {

	private JFrame frame;
	private Controller control;
	public VeziRaport(Controller c) {
		control=c;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JDateChooser d=new JDateChooser();
		d.setBounds(46, 53, 298, 104);
		frame.getContentPane().add(d);
		
		JButton btnVeziRaport = new JButton("Vezi Raport");
		btnVeziRaport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df= new SimpleDateFormat("yyyy-mm-dd");
				String s= df.format(d.getDate());
				Zona z= control.VeziRaport(s);
				PieChart_AWT demo = new PieChart_AWT( "Preferinte clienti",z.getZonaA(),z.getZonaB(),z.getZonaC() );  
			      demo.setSize( 560 , 367 );    
			      RefineryUtilities.centerFrameOnScreen( demo );    
			      demo.setVisible( true );
			}
		});
		btnVeziRaport.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVeziRaport.setBounds(269, 194, 125, 42);
		frame.getContentPane().add(btnVeziRaport);
		
		frame.setVisible(true);
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}

}
