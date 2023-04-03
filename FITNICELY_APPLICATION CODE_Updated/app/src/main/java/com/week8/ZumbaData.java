package com.week8;

import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;

public class ZumbaData {
    public void playVidEasy(VideoView findView, String uri, MediaController md){
        VideoView ZumbaEasy = findView;
        ZumbaEasy.start();

        ZumbaEasy.setVideoURI(Uri.parse(uri));

        ZumbaEasy.setMediaController(md);
        md.setAnchorView(ZumbaEasy);
    }

    public void playVidIntermediate(VideoView findView, String uri, MediaController md){
        VideoView ZumbaIntermediate = findView;

        ZumbaIntermediate.setVideoURI(Uri.parse(uri));

        ZumbaIntermediate.setMediaController(md);
        md.setAnchorView(ZumbaIntermediate);
    }

    public void playVidExpert(VideoView findView, String uri, MediaController md){
        VideoView ZumbaExpert = findView;

        ZumbaExpert.setVideoURI(Uri.parse(uri));

        ZumbaExpert.setMediaController(md);
        md.setAnchorView(ZumbaExpert);
    }
}