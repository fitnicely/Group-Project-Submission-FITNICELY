package com.week8;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.week8.databinding.ActivitySearchBarBinding;

public class SearchBar extends AppCompatActivity {
ActivitySearchBarBinding binding;
Keyword navigation = new Navigation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBarBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
        navigation.setInitialNavigationKeyword();
        navigation.setInitialVideoKeyword();

        binding.btnSearchKeyword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keywordEntered = binding.keywordEntered.getText().toString().toLowerCase().trim();

                    boolean find = navigation.findNavigation(keywordEntered);
                    if (keywordEntered.isEmpty()) {
                    Toast.makeText(SearchBar.this, "Please enter the keyword first!", Toast.LENGTH_SHORT).show();
                    }
                    if (find == true) {
                        binding.result1.setText("FOUND!");
                    } else {
                        binding.result1.setText("NOT FOUND");
                    }

                    binding.btnGoTo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (keywordEntered.contains("yoga")) {
                                Intent i = new Intent(getApplicationContext(), yogaPage.class);
                                startActivity(i);
                            } else if (keywordEntered.contains("zumba")) {
                                Intent i = new Intent(getApplicationContext(), ZumbaPage.class);
                                startActivity(i);
                            } else if (keywordEntered.contains("pilates")) {
                                Intent i = new Intent(getApplicationContext(), pilatesPage.class);
                                startActivity(i);
                            } else if (keywordEntered.contains("profile") || keywordEntered.contains("logout")) {
                                Intent i = new Intent(getApplicationContext(), profileUser.class);
                                startActivity(i);
                            }
                        }
                    });

            }
        });
    }
}