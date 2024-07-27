package Pie;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import user.User;

public class PieChart extends ApplicationFrame {
	   
	public PieChart(String title,String uniqueID,User user1,User user2,User user3) {
	      super( title ); 
	      if(uniqueID.endsWith("y")) {
	      setContentPane(createDemoPanel( user1));
	      }
	      if(uniqueID.endsWith("f")) {
		      setContentPane(createDemoPanel( user2));
		      }
	      if(uniqueID.endsWith("i")) {
		      setContentPane(createDemoPanel( user3));
		      }
	      
	   }
	   
	   private static PieDataset createDataset(User user) {
	      DefaultPieDataset dataset = new DefaultPieDataset( );
	      dataset.setValue( "Asia" , user.asiausers );  
	      dataset.setValue( "Europe" , user.europeusers );   
	      dataset.setValue( "North America" , user.northamericausers );    
	      dataset.setValue( "South America" , user.southamericausers);
	      dataset.setValue( "Africa" , user.africausers);

	      return dataset;         
	   }
	   
	   private static JFreeChart createChart( PieDataset dataset ) {
		      JFreeChart chart = ChartFactory.createPieChart(      
		         "Mobile Sales",   // chart title 
		         dataset,          // data    
		         true,             // include legend   
		         true, 
		         false);

		      return chart;
		   }
	   public static JPanel createDemoPanel(User user) {
		      JFreeChart chart = createChart(createDataset( user) );  
		      return new ChartPanel( chart ); 
		   }
}
