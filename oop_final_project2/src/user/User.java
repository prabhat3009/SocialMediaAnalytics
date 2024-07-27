package user;
public abstract class User {
 
    //public final Number total_followers = null;
	public String uniqueId;
    public double asiausers;
    public double europeusers;
    public double northamericausers;
    public double southamericausers;
    public double africausers;
    
    public abstract double getfollowers() ;
    
    public abstract double userEngagement();  
    public User(){
    	
    }

    
}