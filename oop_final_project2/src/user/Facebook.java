package user;
public class Facebook extends User {

    public int no_of_posts;
    public int no_of_reactions;
    public int no_of_shares;
    public int no_of_comments;
	public int total_followers;

    public Facebook(String uniqueId, double asiausers,double europeusers,double africausers,double southamericausers,double northamericausers) {
        this.uniqueId = uniqueId;
        this.asiausers = asiausers;
        this.southamericausers=southamericausers;
        this.africausers=africausers;
        this.europeusers=europeusers;
        this.northamericausers=northamericausers;
        this.no_of_reactions = 0           ;                                                                // Set default values for engagement metrics
        this.no_of_posts = 0;
        ;
        this.no_of_shares = 0;
        this.no_of_comments = 0;
    }

    public Facebook(String uniqueId, double asiausers,double europeusers,double africausers,double southamericausers,double northamericausers, int no_of_posts, int no_of_reactions, int no_of_shares, int no_of_comments, int total_followers) {
        this.uniqueId = uniqueId;
            this.no_of_reactions = no_of_reactions;
        this.no_of_shares = no_of_shares;
        this.asiausers = asiausers;
        this.southamericausers=southamericausers;
        this.africausers=africausers;
        this.europeusers=europeusers;
        this.northamericausers=northamericausers;
        this.no_of_posts = no_of_posts;
        this.total_followers=total_followers;
        this.no_of_comments = no_of_comments;
    }

    @Override
    public double userEngagement() {
        double userEngagement = (double) (no_of_reactions + no_of_comments + no_of_shares) / no_of_posts;
        return userEngagement;
    }

    public double userEngagement(double reactionWeight, double commentWeight, double shareWeight) {
        double userEngagement = (double) (no_of_reactions * reactionWeight + no_of_comments * commentWeight + no_of_shares * shareWeight) / no_of_posts;    // Overloaded userEngagement() method - weighted engagement (optional)
        return userEngagement;
    }
    
    

    // Overloaded userEngagement() method - minimum post threshold (optional)
    public double userEngagement(int minPosts) {
        if (no_of_posts >= minPosts) {
            double userEngagement = (double) (no_of_reactions + no_of_comments + no_of_shares) / no_of_posts;
            return userEngagement;
        } else {
            // Handle case where posts are less than minimum threshold (optional: return default value, throw exception, etc.)
            System.out.println("User has less than " + minPosts + " posts. Engagement calculation not applicable.");
            return 0.0;
    }
}

	@Override
	public double getfollowers() {
		
		return this.total_followers;
	}
}