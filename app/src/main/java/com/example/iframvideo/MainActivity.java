package com.example.iframvideo;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity  {


    private WebView webView;
    String youTubeUrl = "https://www.youtube.com/embed/47yJ2XCRLZs";

    String frameVideo = "<html><body>Video From YouTube<br><iframe width=\"420\" height=\"315\" " +
            "src='" + youTubeUrl + "' frameborder=\"0\" allowfullscreen>" +
            "</iframe></body></html>";


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);

        String regexYoutUbe = "^(http(s)?:\\/\\/)?((w){3}.)?youtu(be|.be)?(\\.com)?\\/.+";
        if (youTubeUrl.matches(regexYoutUbe)) {

            //setting web client
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    return false;
                }
            });
            //web settings for JavaScript Mode
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setDomStorageEnabled(true);
            webView.loadData(frameVideo, "text/html", "utf-8");


        } else {
            Toast.makeText(MainActivity.this, "This is other video",
                    Toast.LENGTH_SHORT).show();
        }
    }
}