import java.sql.*;
import java.util.Scanner;

public class SignUpUser {

    //ATTRIBUTES
    private static String name;
    private static String email;
    private static String phone;
    private static String username;
    private static String password;

    //METHODS
    //constructor
    public SignUpUser() {}
    public SignUpUser(String name, String email, String phone, String username, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void userInput(){
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter name: ");
        name = in.nextLine();

        System.out.println("\nEnter email: ");
        email = in.nextLine();

        System.out.println("\nEnter phone: ");
        phone = in.nextLine();

        System.out.println("\nEnter username: ");
        username = in.nextLine();

        System.out.println("\nEnter password: ");
        password = in.nextLine();

        in.close();
    }

    public void Database(String name, String email, String phone, String username, String password){
        String url ="jdbc:mysql://db4free.net:3306/fitnicely";
        String DB_user = "fitnicelyadmin";
        String DB_password = "Fitnicelypwd11";

        //STEP 1:
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            //STEP 2: CREATE CONNECTION
            Connection connection = DriverManager.getConnection(url, DB_user, DB_password);

            System.out.println("Connection is created successfully:");

            //STEP 3:
            String query = "INSERT INTO user_details (Name, Email, PhoneNumber, Username, Password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, phone);
            statement.setString(3, email);
            statement.setString(4, username);
            statement.setString(5, password);

            statement.executeUpdate();
            System.out.println("Record is inserted in the table successfully..................");

            //STEP 5: CLOSE CONNECTION
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        SignUpUser user = new SignUpUser();
        user.userInput();
        user.Database(name,email,phone,username,password);


    }
}