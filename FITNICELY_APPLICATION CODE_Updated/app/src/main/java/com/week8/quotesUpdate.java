package com.week8;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.week8.databinding.ActivityQuotesUpdateBinding;


public class quotesUpdate extends AppCompatActivity {

    ActivityQuotesUpdateBinding binding;
    quotesInformation quotesList = new quotesInformation();
    String userInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuotesUpdateBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnAddQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add
                getQuote();
                quotesList.updateQuotes(userInput);
                Toast.makeText(quotesUpdate.this, "quote has been added", Toast.LENGTH_SHORT).show();
                binding.quotesEditText.setText(quotesList.displayQuotesList());
            }
        });

        binding.btnDeleteQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //delete code
                getQuote();
                quotesList.removeQuotes(userInput);
                Toast.makeText(quotesUpdate.this, "quote has been deleted", Toast.LENGTH_SHORT).show();
                binding.quotesEditText.setText(quotesList.displayQuotesList());
            }
        });
    }
    public void getQuote(){
        userInput = binding.quotesEditText.getText().toString();
    }

}