package com.week8;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.week8.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //ATTRIBUTE FOR LOGIN USER CLASS (DATABASE)
    static final String DB_URL = "jdbc:mysql://db4free.net:3306/fitnicely";
    static final String DB_USER = "fitnicelyadmin";
    static final String DB_PASSWORD = "Fitnicelypwd11";

    //ATTRIBUTE FOR LOGIN ADMIN CLASS(MAIN ACCOUNT)
    static final String USERNAME_ADMIN = "fitnicelyadmin";
    static final String PASSWORD_ADMIN = "Fitnicelypwd11";

    //ATTRIBUTE FOR PROFILE USER CLASS(USER ID)
    static String user_id = "0";
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.startButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),adminUser.class);
                startActivity(i);
            }
        }));
    }

}