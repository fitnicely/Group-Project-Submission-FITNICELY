import java.util.Scanner;
import java.sql.*;

public class LoginUser{
        static final String DB_URL = "jdbc:mysql://db4free.net:3306/fitnicely";
        static final String DB_USER = "fitnicelyadmin";
        static final String DB_PASSWORD = "Fitnicelypwd11";
        static String user_id = "0";
        static private String username;
        static private String password;

        public LoginUser() {
        }

        public void Access(){
                Scanner in = new Scanner(System.in);

                System.out.println("\nEnter username: ");
                username = in.nextLine();

                System.out.println("\nEnter password: ");
                password = in.nextLine();

        }

        public void checkInDatabase(String username, String password){
                this.username = username;
                this.password = password;
                System.out.println("\nLoading..");
                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM user_details ");
                        while (resultSet.next()){
                                String verifyUsername = resultSet.getString(5);
                                String verifyPassword = resultSet.getString(6);
                                if (verifyUsername.equals(username) && verifyPassword.equals(password)){
                                        System.out.println("Successful login");
                                        break;}
                        }
                        connection.close();
                } catch (Exception e) {
                        System.out.println(e);
                }

        }
        public static void main(String[] args) {
                LoginUser user1 = new LoginUser();
                user1.Access();
                user1.checkInDatabase(username, password);

        }

}