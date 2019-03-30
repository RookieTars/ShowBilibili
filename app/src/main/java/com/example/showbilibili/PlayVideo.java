package com.example.showbilibili;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PlayVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        Intent intent=getIntent();
        String adress=intent.getStringExtra("videoSite");
        WebView playVideo=findViewById(R.id.play_video);
        playVideo.getSettings().setJavaScriptEnabled(true);
        playVideo.getSettings().setUseWideViewPort(true);
        playVideo.getSettings().setDomStorageEnabled(true);
//        playVideo.setWebViewClient(new WebViewClient());
        playVideo.loadUrl("https://m.bilibili.com/video/av"+adress+".html");
    }
}
