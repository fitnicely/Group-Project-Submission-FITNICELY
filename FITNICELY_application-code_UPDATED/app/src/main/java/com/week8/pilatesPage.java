package com.week8;

import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class pilatesPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilates_easy);

        PilatesData pilates_easy = new PilatesData();
        MediaController mediaController = new MediaController(this);
        pilates_easy.playVidEasy(findViewById(R.id.video_view),"android.resource://" + getPackageName() + "/" + R.raw.video, mediaController );

        PilatesData pilates_intermediate = new PilatesData();
        MediaController mediaController2 = new MediaController(this);
        pilates_intermediate.playVidIntermediate(findViewById(R.id.video_view2), "android.resource://" + getPackageName() + "/" + R.raw.video2, mediaController2);

        PilatesData pilates_expert = new PilatesData();
        MediaController mediaController3 = new MediaController(this);
        pilates_expert.playVidExpert(findViewById(R.id.video_view3),"android.resource://" + getPackageName() + "/" + R.raw.video3, mediaController3 );

    }
}


   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilates_easy);

        VideoView pilates_easy = findViewById(R.id.video_view);
        VideoView pilates_intermediate = findViewById(R.id.video_view2);
        VideoView pilates_expert = findViewById(R.id.video_view3);

        pilates_easy.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));
        pilates_easy.start();

        pilates_intermediate.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video2));
        // pilates_intermediate.start();

        pilates_expert.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video3));

        MediaController mediaController = new MediaController(this);
        pilates_easy.setMediaController(mediaController);
        mediaController.setAnchorView(pilates_easy);

        MediaController mediaController2 = new MediaController(this);
        pilates_intermediate.setMediaController(mediaController2);
        mediaController2.setAnchorView(pilates_intermediate);

        MediaController mediaController3 = new MediaController(this);
        pilates_expert.setMediaController(mediaController3);
        mediaController3.setAnchorView(pilates_expert);
    }
}*/