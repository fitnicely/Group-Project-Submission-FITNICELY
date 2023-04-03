import java.util.Scanner;
import java.sql.*;

public class LoginAdmin {
    static final String usernameAdmin = "fitnicelyadmin"; ;
    static final String passwordAdmin = "Fitnicelypwd11"; ;
    static String username;
    static String password;

    //CONSTRUCTOR
    public LoginAdmin() {  }

    public LoginAdmin(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public void Access(){
        Scanner in = new Scanner(System.in);

        System.out.println("\nEnter username: ");
        username = in.nextLine();

        System.out.println("\nEnter password: ");
        password = in.nextLine();

    }
    public void validateAdmin(String username, String password){

        if(username.equals(usernameAdmin) && password.equals(password))
            System.out.println("\nAdmin Signed In Successfully ");

        else if(username.equals(usernameAdmin) || password.equals(password))
            System.out.println("\nWrong username or password");

        else
            System.out.println("\nError occurred");

    }

    public static void main(String[] args) {
        LoginAdmin admin1 = new LoginAdmin();
        admin1.Access();
        admin1.validateAdmin(username, password);

    }
}