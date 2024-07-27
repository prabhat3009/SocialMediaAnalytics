package authentication;

public class UserAuthentication {
    private String[][] users;

    public UserAuthentication() {
        users = new String[][]{
            {"user1", "password1"},
            {"user2", "password2"}
        };
    }

    public boolean authenticateUser(String username, String password) throws AuthenticationException {
        for (String[] user : users) {
            if (user[0].equals(username)) {
                if (user[1].equals(password)) {
                    return true;
                } else {
                    throw new AuthenticationException("Incorrect password");
                }
            }
        }
        throw new AuthenticationException("User does not exist");
    }
}
