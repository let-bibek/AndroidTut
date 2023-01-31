package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebViewEx extends AppCompatActivity {
WebView wbWebView;
ProgressBar pbWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        wbWebView=findViewById(R.id.wbWebView);
        wbWebView.loadUrl("https://khalte.com");

        pbWebView=findViewById(R.id.pbWebView);
        wbWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                pbWebView.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                pbWebView.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(wbWebView.canGoBack()){
            wbWebView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}