package com.week8;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.week8.databinding.ActivityLoginAdminBinding;
import com.week8.databinding.ActivityLoginBinding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.week8.MainActivity.*;

public class loginAdmin extends AppCompatActivity {
    public static final String USERNAME_ADMIN = "fitnicelyadmin";
    public static final String PASSWORD_ADMIN = "Fitnicelypwd11";
    static String username="";
    static String password="";
    ActivityLoginAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginAdminBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                username = binding.adminUsername.getText().toString();
                password = binding.txtPassword.getText().toString();

                // Show the progress bar
                binding.progressBar2.setVisibility(View.VISIBLE);

                // Perform validation checks on the input values
                if (password.isEmpty() || username.isEmpty()) { //CHECK IF HAVE VALUES OR NOT
                    Toast.makeText(getApplicationContext(), "Please fill all the required fields", Toast.LENGTH_SHORT).show(); //ERROR MESSAGE
                    binding.progressBar2.setVisibility(View.INVISIBLE);
                } else {

                    if (username.equals(USERNAME_ADMIN) && password.equals(PASSWORD_ADMIN)) {
                    //Hide the progress bar
                    binding.progressBar2.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "Admin Signed In Successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), AdminPage.class);
                    startActivity(i);

                } else {
                  //  binding.progressBar2.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "Error occurred", Toast.LENGTH_SHORT).show();
                }

            }

        }
        });
    }

}