package com.week8;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.week8.databinding.ActivityMainPage1Binding;

public class mainPage1 extends AppCompatActivity {
    ActivityMainPage1Binding binding;
    quotesInformation quotes = new quotesInformation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainPage1Binding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        binding.btnPilates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), pilatesPage.class);
                startActivity(i);
            }
        });

        binding.btnYoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), yogaPage.class);
                startActivity(i);
            }
        });

        binding.btnZumba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ZumbaPage.class);
                startActivity(i);
            }
        });

        binding.btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),profileUser.class);
                startActivity(i);
            }
        });
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SearchBar.class);
                startActivity(i);
            }
        });

        binding.btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mainPage1.this, "you are at home page", Toast.LENGTH_SHORT).show();
            }
        });
        //to display random quotes in textView
        TextView textView = findViewById(R.id.textFacts);
        String randomQuote = quotes.getRandomElement();
        textView.setText(randomQuote);

    }

    //application code : to execute without the GUI
    /*public static void main(String args[]){

        quotesInformation quotes = new quotesInformation();
        //creating a new object for quotesInformation class

        //executing the random quotes list that is displayed on the textView in mainPage1
        System.out.println("Quotes: ");
        System.out.println(quotes.getRandomElement()) ;
    }
    }*/
}