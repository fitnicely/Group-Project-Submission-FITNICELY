package com.week8;

import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ZumbaPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zumba_easy);

        ZumbaData zumba_easy = new ZumbaData();
        MediaController mediaController = new MediaController(this);
        zumba_easy.playVidEasy(findViewById(R.id.video_view),"android.resource://" + getPackageName() + "/" + R.raw.zumba, mediaController );

        ZumbaData zumba_intermediate = new ZumbaData();
        MediaController mediaController2 = new MediaController(this);
        zumba_intermediate.playVidIntermediate(findViewById(R.id.video_view2), "android.resource://" + getPackageName() + "/" + R.raw.zumba2, mediaController2);

        ZumbaData zumba_expert = new ZumbaData();
        MediaController mediaController3 = new MediaController(this);
        zumba_expert.playVidExpert(findViewById(R.id.video_view3),"android.resource://" + getPackageName() + "/" + R.raw.zumba3, mediaController3 );

    }


   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zumba_easy);

        VideoView zumba_easy = findViewById(R.id.video_view);
        VideoView zumba_intermediate = findViewById(R.id.video_view2);
        VideoView zumba_expert = findViewById(R.id.video_view3);

        zumba_easy.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.zumba));
        zumba_easy.start();

        zumba_intermediate.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.zumba2));

        zumba_expert.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.zumba3));

        MediaController mediaController = new MediaController(this);
        zumba_easy.setMediaController(mediaController);
        mediaController.setAnchorView(zumba_easy);

        MediaController mediaController2 = new MediaController(this);
        zumba_intermediate.setMediaController(mediaController2);
        mediaController2.setAnchorView(zumba_intermediate);

        MediaController mediaController3 = new MediaController(this);
        zumba_expert.setMediaController(mediaController3);
        mediaController3.setAnchorView(zumba_expert);


    }*/
}