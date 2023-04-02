package com.week8;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.week8.databinding.ActivityProfileUserBinding;

import java.sql.*;

import static com.week8.MainActivity.*;

public class profileUser extends AppCompatActivity {
    ActivityProfileUserBinding binding;

    // the name must be the same as in the database column
    String name = "";
    String PhoneNumber = "";
    String Email = "";
    String Username = "";
    String Password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileUserBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //connection with database takes time, when it get result to change into interface, it will not work
        new Thread(() -> {
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
                    PhoneNumber = rs.getString("PhoneNumber");
                    Email = rs.getString("Email");
                    Username = rs.getString("Username");
                    Password = rs.getString("Password");
                }

                runOnUiThread(() -> {
                    if (exists) {
                        binding.showName.setText(name);
                        binding.showPhone.setText(PhoneNumber);
                        binding.showEmail.setText(Email);
                        binding.showUsername.setText(Username);
                        binding.showPassword.setText(Password);
                    }
                });
                con.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }).start();

        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}