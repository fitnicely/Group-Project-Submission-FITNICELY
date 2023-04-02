package com.week8;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.week8.databinding.ActivityLoginBinding;

import java.sql.*;
import java.util.regex.*;

import static com.week8.MainActivity.*;

public class Login extends AppCompatActivity {
    static final String DB_URL = "jdbc:mysql://db4free.net:3306/fitnicely";
    static final String DB_USER = "fitnicelyadmin";
    static final String DB_PASSWORD = "Fitnicelypwd11";
    static String username ="";
    static String password ="";
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnLoginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get the input values from the EditText
                username = binding.txtUsername.getText().toString().toLowerCase(); //lowercase the email
                password = binding.txtPassword.getText().toString();

                if (username.length()>0 && password.length() > 0) {
                    // Show the progress bar
                    binding.progressBarLogin.setVisibility(View.VISIBLE); //when click

                    new Thread(() -> {
                        try {
                            //load the MySQL JDBC driver class dynamically at runtime
                            Class.forName("com.mysql.jdbc.Driver");

                            //establish a connection to a MySQL database using the JDBC driver
                            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // attributes from MainActivity

                            String query = "SELECT * FROM user_details WHERE Username = ? AND Password = ?"; //select all from table user_details
                            PreparedStatement stmt = con.prepareStatement(query);
                            stmt.setString(1, username);
                            stmt.setString(2, password);

                            ResultSet rs = stmt.executeQuery();
                            boolean exists = rs.next();

                            if (exists) {
                                //set new user_id in MainActivity taken from id database
                                MainActivity.user_id = rs.getString("id");
                            }

                            runOnUiThread(() -> {
                                //Hide the progress bar
                                binding.progressBarLogin.setVisibility(View.INVISIBLE);
                                if (exists) {
                                    Toast.makeText(getApplicationContext(), "Successful login", Toast.LENGTH_SHORT).show();
                                    //Successful login leads to user Main Page
                                    Intent i = new Intent(getApplicationContext(), mainPage1.class);
                                    startActivity(i);
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_SHORT).show();
                                }
                            });
                            con.close();
                        } catch (SQLException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }).start();

                } else { //display toast error
                    Toast.makeText(getApplicationContext(), "Please enter a valid email and password", Toast.LENGTH_SHORT).show();
                }
            }

        });
        binding.signupText.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SignUpUser.class);
                startActivity(i);
                finish();
            }
        }));
    }


}