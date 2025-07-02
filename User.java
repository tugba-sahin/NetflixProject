public class User extends Person {
    private String userName;
    private String password;

    public User(int id, String firstName, String lastName, String userName, String password) {
        super(id, firstName, lastName, 0); // Age not strictly needed for User, set to 0
        this.userName = userName;
        this.password = password;
    }

    // Getters
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User: " + userName + ", Name: " + getFirstName() + " " + getLastName();
    }
}