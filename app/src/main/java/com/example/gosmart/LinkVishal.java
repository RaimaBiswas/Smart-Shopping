package com.example.gosmart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class LinkVishal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bigbazaar);
        WebView myWebView = (WebView) findViewById(R.id.bigbazaar);
        myWebView.loadUrl("https://www.myvishal.com/fashion");
    }
}