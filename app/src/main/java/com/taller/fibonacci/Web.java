package com.taller.fibonacci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView myWebView = findViewById(R.id.webview);
        myWebView.loadUrl("https://en.wikipedia.org/wiki/Fibonacci");
    }
}
