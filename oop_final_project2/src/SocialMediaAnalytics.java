import java.util.Scanner;
import user.*;
import Pie.*;
import Bar.*;
import authentication.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import authentication.AuthenticationException;

import javax.swing.JPanel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class SocialMediaAnalytics {
	
	    public static void main(String[] args) {
	    	String uniqueId=null;
	    	UserAuthentication auth = new UserAuthentication();
	        Scanner scanner = new Scanner(System.in);//creating a scanner object to take input data
	        try {
	            System.out.print("Enter username: ");
	            String username = scanner.nextLine();
	            System.out.print("Enter password: ");
	            String password = scanner.nextLine();
	            System.out.print("Enter uniqueId: ");
	            uniqueId = scanner.nextLine();
	            
	            boolean isAuthenticated = auth.authenticateUser(username, password);
	            if (isAuthenticated) {
	                System.out.println("Authentication successful");
	            } else {
	                System.out.println("Authentication failed");
	            }
	        } catch (AuthenticationException e) {
	            System.out.println("Authentication error: " + e.getMessage());//catching an error if any
	        } finally {
	            scanner.close();
	        }
	        System.out.println("Scanned uniqueId:"+uniqueId);
            
	    
	        
        	User user1 = new Youtube(uniqueId, 20,20,20,20,20, 5000, 2000, 700, 150,150);
        	User user2 = new Facebook(uniqueId, 10,20,30,20,20, 5000, 2000, 700, 150,150);
         	User user3= new Instagram(uniqueId, 15,25,15,25,20, 5000, 2000, 700, 150);


	        BarChart chart = new BarChart("Bar Graph","User Engagement Rates and Total No.Of Users of the creator",uniqueId,user1,user2,user3);
            chart.pack( );        
            RefineryUtilities.centerFrameOnScreen( chart );        
            chart.setVisible( true );
            PieChart chartpie = new PieChart("Audience Demographics",uniqueId,user1,user2,user3);  
            chartpie.setSize( 560 , 367 );    
            RefineryUtilities.centerFrameOnScreen( chartpie );    
            chartpie.setVisible( true );
            report.GeneratePdf();
	    }
	    }


	       /* BarChart chart = new BarChart("Bar Graph","User Engagement Rates and Total No.Of Users of the creator");
	             chart.pack( );        
	             RefineryUtilities.centerFrameOnScreen( chart );        
	             chart.setVisible( true ); 
	             User_pie demo = new User_pie( "User demographics" );  
	             demo.setSize( 560 , 367 );    
	             RefineryUtilities.centerFrameOnScreen( demo );    
	             demo.setVisible(true);*/
