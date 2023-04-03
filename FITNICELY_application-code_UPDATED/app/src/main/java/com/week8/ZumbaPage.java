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
}