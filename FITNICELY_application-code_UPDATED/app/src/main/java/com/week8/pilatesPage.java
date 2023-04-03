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
