package com.week8;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class yogaPage extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_easy);

        //level easy
        YogaData yoga_easy = new YogaData();
        yoga_easy.playVidEasy(findViewById(R.id.mWebView));

        //intermediate level
        YogaData yoga_intermediate = new YogaData();
        yoga_intermediate.playVidInter(findViewById(R.id.int_Yoga));

        //expert level
        YogaData yoga_expert = new YogaData();
        yoga_expert.playVidExp(findViewById(R.id.expYoga));

    }

}