package userInterface.userAuthentication;

public class User {
    private String id;
    private String password;
    private double point = 0;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPoint(double point) {
        this.point += point;
    }
}
