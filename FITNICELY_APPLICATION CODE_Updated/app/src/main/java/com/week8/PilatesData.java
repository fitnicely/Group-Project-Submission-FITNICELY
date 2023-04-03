package com.week8;

import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;
public class PilatesData {
    public void playVidEasy(VideoView findView, String uri, MediaController md){
        VideoView PilatesEasy = findView;

        PilatesEasy.setVideoURI(Uri.parse(uri));
        PilatesEasy.start();

        PilatesEasy.setMediaController(md);
        md.setAnchorView(PilatesEasy);
    }

    public void playVidIntermediate(VideoView findView, String uri, MediaController md){
        VideoView PilatesIntermediate = findView;

        PilatesIntermediate.setVideoURI(Uri.parse(uri));

        PilatesIntermediate.setMediaController(md);
        md.setAnchorView(PilatesIntermediate);
    }

    public void playVidExpert(VideoView findView, String uri, MediaController md){
        VideoView PilatesExpert = findView;

        PilatesExpert.setVideoURI(Uri.parse(uri));

        PilatesExpert.setMediaController(md);
        md.setAnchorView(PilatesExpert);
    }

}
