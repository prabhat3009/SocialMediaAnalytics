package user;
public class Instagram extends User {

    public int no_of_shares;
    public int no_of_likes;
    public int total_no_of_followers;
    public int no_of_comments;

    public Instagram(String uniqueId, double asiausers,double europeusers,double africausers,double southamericausers,double northamericausers) {
        this.uniqueId = uniqueId;
        this.asiausers = asiausers;
        this.southamericausers=southamericausers;
        this.africausers=africausers;
        this.europeusers=europeusers;
        this.northamericausers=northamericausers;
        // Set default values for engagement metrics
        this.no_of_shares = 0;
        this.no_of_likes = 0;
        this.total_no_of_followers = 0;
        this.no_of_comments = 0;
    }

    public Instagram(String uniqueId, double asiausers,double europeusers,double africausers,double southamericausers,double northamericausers, int total_no_of_followers, int no_of_likes, int no_of_comments, int no_of_shares) {
        this.uniqueId = uniqueId;
        this.asiausers = asiausers;
        this.southamericausers=southamericausers;
        this.africausers=africausers;
        this.europeusers=europeusers;
        this.northamericausers=northamericausers;
        this.total_no_of_followers = total_no_of_followers;
        this.no_of_likes = no_of_likes;
        this.no_of_comments = no_of_comments;
        this.no_of_shares = no_of_shares;
    }

    @Override
    public double userEngagement() {
        double userEngagement = (double) (no_of_likes + no_of_comments + no_of_shares) / total_no_of_followers;
        return userEngagement;
    }

    // Overloaded userEngagement() method - optional calculation based on minimum followers
    public double userEngagement(int minFollowers) {
        if (total_no_of_followers >= minFollowers) {
            double userEngagement = (double) (no_of_likes + no_of_comments + no_of_shares) / total_no_of_followers;
            return userEngagement;
        } else {
            // Handle case where followers are less than minimum threshold (optional: return default value, throw exception, etc.)
            System.out.println("User has less than " + minFollowers + " followers. Engagement calculation not applicable.");
            return 0.0; // Or any placeholder value you prefer
        }
    }

	@Override
	public double getfollowers() {
		return this.total_no_of_followers;
	}}