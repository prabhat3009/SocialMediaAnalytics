package user;



public class Youtube extends User {

    public int no_of_views;
    public int no_of_likes;
    public int no_of_dislikes;
    public int no_of_comments;
	public int total_followers;

    public Youtube(String uniqueId, double asiausers,double europeusers,double africausers,double southamericausers,double northamericausers) {
        this.uniqueId = uniqueId;
        this.asiausers = asiausers;
        this.southamericausers=southamericausers;
        this.africausers=africausers;
        this.europeusers=europeusers;
        this.northamericausers=northamericausers;
        // Set default values for engagement metrics
        this.no_of_views = 0;
        this.no_of_likes = 0;
        this.no_of_dislikes = 0;
        this.no_of_comments = 0;
    }

    public Youtube(String uniqueId,double asiausers,double europeusers,double africausers,double southamericausers,double northamericausers, int no_of_views, int no_of_likes, int no_of_dislikes, int no_of_comments,int total_followers) {
        this.uniqueId = uniqueId;
        this.asiausers = asiausers;
        this.southamericausers=southamericausers;
        this.africausers=africausers;
        this.europeusers=europeusers;
        this.northamericausers=northamericausers;
        this.no_of_views = no_of_views;
        this.no_of_likes = no_of_likes;
        this.no_of_dislikes = no_of_dislikes;
        this.no_of_comments = no_of_comments;
        this.total_followers=total_followers;
    }

    public double userEngagement(int no_of_views,int no_of_likes,int no_of_dislikes, int no_of_comments) {
        double userEngagement = (double) (no_of_likes + no_of_dislikes + no_of_comments) / no_of_views;
        return userEngagement;
    }

    // Overloaded userEngagement() method - exclude dislikes (optional)
    public double userEngagement(int no_of_views,int no_of_likes,int no_of_comments) {
        double userEngagement = (double) (no_of_likes + no_of_comments) / no_of_views;
        return userEngagement;
    }

    // Overloaded userEngagement() method - minimum view threshold (optional)
    public double userEngagement(int minViews) {
        if (no_of_views >= minViews) {
            double userEngagement = (double) (no_of_likes + no_of_dislikes + no_of_comments) / no_of_views;
            return userEngagement;
        } else {
            // Handle case where views are less than minimum threshold (optional: return default value, throw exception, etc.)
            System.out.println("Video has less than " + minViews + " views. Engagement calculation not applicable.");
            return 0.0; // Or any placeholder value you prefer
        }
    }

	@Override
	public double userEngagement() {
		double userEngagement = (double) (no_of_likes + no_of_dislikes + no_of_comments) / no_of_views;
        return userEngagement;
	}

	@Override
	public double getfollowers() {
		
		return this.total_followers;
	}
}
