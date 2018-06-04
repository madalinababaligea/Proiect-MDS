package interfata;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class PieChart_AWT extends ApplicationFrame {
   
   public PieChart_AWT( String title,int A,int B,int C) {
      super( title ); 
      setContentPane(createDemoPanel( A,B,C));
   }
   
   private static PieDataset createDataset( int A, int B,int C ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "Zona A" , A);  
      dataset.setValue( "Zona B" , B );   
      dataset.setValue( "Zona C" , C );    
     
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Preferinte clienti",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public static JPanel createDemoPanel( int A, int B, int C) {
      JFreeChart chart = createChart(createDataset(A,B,C ) );  
      return new ChartPanel( chart ); 
   }
   }
