package com.week8;

import android.webkit.WebSettings;
import android.webkit.WebView;
public class YogaData {

//beginner level yoga
private String url_easy = "https://www.youtube.com/embed/d8QqXLV3tWM";
    private String dataUrl_easy =
            "<html>" +
                    "<body>" +
                    "<iframe width=\"100%\" height=\"100%\" src=\""+url_easy+"\" frameborder=\"0\" " +
                    "allowfullscreen/>" +
                    "</body>" +
                    "</html>";

    public void playVidEasy(WebView findView) {
        WebView YogaEasy = findView;

        WebSettings webSettings = YogaEasy.getSettings();

        webSettings.setJavaScriptEnabled(true);
        YogaEasy.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        YogaEasy.getSettings().setLoadWithOverviewMode(true);
        YogaEasy.getSettings().setUseWideViewPort(true);
        YogaEasy.loadData(dataUrl_easy, "text/html", "utf-8");
    }


//intermediate level yoga

    private String url_intermediate = "https://www.youtube.com/embed/6AtaS8xJG4E";

    private String dataUrl =
            "<html>" +
                    "<body>" +
                    "<iframe width=\"100%\" height=\"100%\" src=\""+url_intermediate+"\" frameborder=\"0\" allowfullscreen/>" +
                    "</body>" +
                    "</html>";

    public void playVidInter(WebView findView) {
        WebView YogaInt = findView;

        WebSettings webSettings = YogaInt.getSettings();

        webSettings.setJavaScriptEnabled(true);
        YogaInt.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        YogaInt.getSettings().setLoadWithOverviewMode(true);
        YogaInt.getSettings().setUseWideViewPort(true);
        YogaInt.loadData(dataUrl, "text/html", "utf-8");
    }

    //expert level
    private String url_expert = "https://www.youtube.com/embed/18mnOUa482Y?start=141";

    private String dataUrl_exp =
            "<html>" +
                    "<body>" +
                    "<iframe width=\"100%\" height=\"100%\" src=\""+url_expert+"\" frameborder=\"0\" allowfullscreen/>" +
                    "</body>" +
                    "</html>";

    public void playVidExp(WebView findView) {
        WebView YogaExp = findView;

        WebSettings webSettings = YogaExp.getSettings();

        webSettings.setJavaScriptEnabled(true);
        YogaExp.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        YogaExp.getSettings().setLoadWithOverviewMode(true);
        YogaExp.getSettings().setUseWideViewPort(true);
        YogaExp.loadData(dataUrl_exp, "text/html", "utf-8");
    }
}

