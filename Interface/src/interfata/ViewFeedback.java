package interfata;

import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clase.Feed;
import client.Controller;
import java.awt.BorderLayout;

public class ViewFeedback {

	private JFrame frame;
	private Controller control;
	private JTable table;

	public ViewFeedback(Controller c) {
		
		control=c;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 100, 436, 161);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"FeedBack", "id_client"
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel model= (DefaultTableModel)table.getModel();
		ArrayList<Feed> feedback=control.veziFeedback();
		Object rowData[] = new Object[4];
		for(int i=0;i<feedback.size();i++)
		{
			rowData[0]=feedback.get(i).getFeedback();
			rowData[1]=feedback.get(i).getId();
			model.addRow(rowData);
		}
		frame.setVisible(true);
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}

}
