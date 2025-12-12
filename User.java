import java.util.Scanner;
import java.io.Serializable;

public abstract class User implements Serializable {
    protected String userId, name, email, password;

    public User(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getPassword() { return password; }

    public abstract void displayMenu(Scanner scanner, ComplaintManager manager);
}