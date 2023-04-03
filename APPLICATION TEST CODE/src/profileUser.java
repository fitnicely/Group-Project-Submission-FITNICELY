import java.sql.*;

public class profileUser {

    private static String name;
    private static String phoneNumber;
    private static String email;
    private static String username;
    private static String password;
    static final String DB_URL = "jdbc:mysql://db4free.net:3306/fitnicely";
    static final String DB_USER = "fitnicelyadmin";
    static final String DB_PASSWORD = "Fitnicelypwd11";

    private static String user_id = " ";

    public void Database(){
        try {
            //load the MySQL JDBC driver class dynamically at runtime
            Class.forName("com.mysql.jdbc.Driver");

            //establish a connection to a MySQL database using the JDBC driver
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String query = "SELECT * FROM user_details WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, user_id);

            ResultSet rs = stmt.executeQuery();
            boolean exists = rs.next();
            if (exists) {
                name = rs.getString("Name");
                phoneNumber = rs.getString("PhoneNumber");
                email = rs.getString("Email");
                username = rs.getString("Username");
                password = rs.getString("Password");
            }

            if (exists) {
                System.out.println(name);
                System.out.println(phoneNumber);
                System.out.println(email);
                System.out.println(username);
                System.out.println(password);
            }
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        username = "saf1";
        password = "12345678";
        user_id = "1";

        profileUser profile = new profileUser();
        profile.Database();

    }
}