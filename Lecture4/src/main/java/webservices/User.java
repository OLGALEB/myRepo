package webservices;

public class User {
    private String email;
    private String password;
    private int id;
    private String registeredAt;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getRegisteredAt() {
        return registeredAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", registeredAt='" + registeredAt + '\'' +
                '}';
    }
}