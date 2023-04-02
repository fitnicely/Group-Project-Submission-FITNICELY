package com.week8;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.week8.databinding.ActivitySignUpUserBinding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.util.regex.*;

import static com.week8.MainActivity.*;

public class SignUpUser extends AppCompatActivity {

    ActivitySignUpUserBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSignUp.setOnClickListener(view -> {

            // Get the input values from the EditText
            String name = binding.txtName.getText().toString();
            String phoneNum = binding.txtPhoneNum.getText().toString();
            String email = binding.txtEmail.getText().toString();
            String username = binding.txtUsername.getText().toString();
            String password = binding.txtPassword.getText().toString();

            // Perform validation checks on the input values
            if (name.isEmpty()||email.isEmpty()||password.isEmpty()||username.isEmpty()||phoneNum.isEmpty()) { //CHECK IF HAVE VALUES OR NOT
                Toast.makeText(getApplicationContext(), "Please fill all the required fields", Toast.LENGTH_SHORT).show(); //ERROR MESSAGE
            } else if (isValidEmail(email)==false && isValidPhoneNum(phoneNum)==false) {
                Toast.makeText(getApplicationContext(), "Invalid email and phone number", Toast.LENGTH_SHORT).show();
            } else if (isValidEmail(email)==false){
                Toast.makeText(getApplicationContext(), "Please enter valid email", Toast.LENGTH_SHORT).show();
            }else if (isValidPhoneNum(phoneNum)==false) {
                Toast.makeText(getApplicationContext(), "Please enter valid phone number", Toast.LENGTH_SHORT).show();
            } else {
                // Show the progress bar
                binding.progressBar.setVisibility(View.VISIBLE);
                new Thread(() -> {
                    try {
                        //load the MySQL JDBC driver class dynamically at runtime
                        Class.forName("com.mysql.jdbc.Driver");
                        //establish a connection to a MySQL database using the JDBC driver.
                        Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                        // Create a prepared statement to insert the user data
                        String query = "INSERT INTO user_details (Name, PhoneNumber, Email, Username, Password) VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement stmt = con.prepareStatement(query);
                        stmt.setString(1, name);
                        stmt.setString(2, phoneNum);
                        stmt.setString(3, email);
                        stmt.setString(4, username);
                        stmt.setString(5, password);

                        // Execute the prepared statement to insert the data
                        int rows = stmt.executeUpdate();
                        runOnUiThread(() -> {
                            //Hide the progress bar
                            binding.progressBar.setVisibility(View.INVISIBLE);
                            if (rows > 0) {
                                Toast.makeText(getApplicationContext(), "User Signed Up Successfully", Toast.LENGTH_SHORT).show();
                                //Successful registration leads to user login page
                                Intent i = new Intent(getApplicationContext(), Login.class);
                                startActivity(i);

                            } else {
                                Toast.makeText(getApplicationContext(), "Error occurred", Toast.LENGTH_SHORT).show();
                            }
                        });
                        con.close();
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }).start();

            }


        });


        binding.LoginText.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Login.class);
                startActivity(i);
                finish();
            }
        }));

    }
    private boolean isValidEmail(String email){

        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
                + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";

        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();

    }

    private static boolean isValidPhoneNum(String phoneNumber) {
        //validates phone numbers having 10 digits or numbers having digits, - or spaces
        if (phoneNumber.matches("\\d{10}") || phoneNumber.matches("\\d{3}[-\\.\\s]\\d{7}"))
            return true;
            //return false if any of the input matches is not found
        else
            return false;
    }
}