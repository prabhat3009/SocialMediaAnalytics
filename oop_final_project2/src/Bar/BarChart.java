package Bar;
import user.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;

public class BarChart extends ApplicationFrame{
	

      
       
	   public BarChart( String applicationTitle , String chartTitle,String UniqueId,User user1,User user2,User user3 ) {
	      super( applicationTitle );        
	      if(UniqueId.endsWith("f")) 
	      {
	    	  JFreeChart barChart = ChartFactory.createBarChart(  
	         chartTitle,           
	         "Platform",            
	         "User Engagement Rate in %, Total No.Of Users in billions",            
	         createDatasetfacebook(user2),          
	         PlotOrientation.VERTICAL,           
	         true, true, false);
	         
	      ChartPanel chartPanel = new ChartPanel( barChart );        
	      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
	      setContentPane( chartPanel ); 
	      }
	      else if(UniqueId.endsWith("y")) {
	    	  JFreeChart barChart = ChartFactory.createBarChart(  
	    		         chartTitle,           
	    		         "Platform",            
	    		         "User Engagement Rate in %, Total No.Of Users in billions",            
	    		         createDatasetyoutube(user1),          
	    		         PlotOrientation.VERTICAL,           
	    		         true, true, false);
	    		         
	    		      ChartPanel chartPanel = new ChartPanel( barChart );        
	    		      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
	    		      setContentPane( chartPanel ); 
	      }
	      else  {
	    	  JFreeChart barChart = ChartFactory.createBarChart(  
	    		         chartTitle,           
	    		         "Platform",            
	    		         "User Engagement Rate in %, Total No.Of Users in billions",            
	    		         createDatasetinstagram(user3),          
	    		         PlotOrientation.VERTICAL,           
	    		         true, true, false);
	    		         
	    		      ChartPanel chartPanel = new ChartPanel( barChart );        
	    		      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
	    		      setContentPane( chartPanel ); 
	      }
	   }
   
	   public CategoryDataset createDatasetfacebook(User user2) {
	          
	      final String Facebook = "Facebook";        
	      final String UserEngagement = "User Engagement Rate";        
	      final String Total_Noof_Followers = "Total No.of Followers";               
	      final DefaultCategoryDataset dataset = 
	      new DefaultCategoryDataset( );  

	          
	      
	      dataset.addValue( user2.userEngagement() , Facebook,UserEngagement);        
	      dataset.addValue( user2.getfollowers() ,Facebook, Total_Noof_Followers);        
            

	      return dataset; 
	   }
	   public CategoryDataset createDatasetyoutube(User user1) {
		      final String Youtube = "Youtube";        
		             
		      final String UserEngagement = "User Engagement Rate";        
		      final String Total_Noof_Followers = "Total No.of Followers";               
		      final DefaultCategoryDataset dataset = 
		      new DefaultCategoryDataset( );  

		      dataset.addValue( user1.userEngagement() , Youtube, UserEngagement);        
		      dataset.addValue(  user1.getfollowers(), Youtube , Total_Noof_Followers);                  

		           
	            

		      return dataset; 
		   }
	   public CategoryDataset createDatasetinstagram(User user3) {
		      
		      final String Instagram = "Instagram"   ;   
		      
		      final String UserEngagement = "User Engagement Rate";        
		      final String Total_Noof_Followers = "Total No.of Followers";               
		      final DefaultCategoryDataset dataset = 
		      new DefaultCategoryDataset( );  
        

		      dataset.addValue( user3.userEngagement() , Instagram , UserEngagement );        
		      dataset.addValue( user3.getfollowers() ,Instagram , Total_Noof_Followers);      
		      
	            

		      return dataset; 
		   }
	
	   
}