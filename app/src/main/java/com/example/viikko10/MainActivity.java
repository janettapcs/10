package com.example.viikko10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView browser;
    EditText text;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.editText);
        browser = findViewById(R.id.webView);
        browser.setWebViewClient(new WebViewClient());
        browser.getSettings().setJavaScriptEnabled(true);


    }

    public void onClick(View v) {
        String url = "http://" + text.getText().toString();
        browser.loadUrl(url);

        if ( url.equals("http://index.html") ) {
            browser.loadUrl("file:///android_asset/index.html");
        }
        else {
            browser.loadUrl(url);
        }
    }

    public void refresh(View v) {
        String url = "http://" + text.getText().toString();
        browser.loadUrl(url);
    }

    public void shoutout(View v) {
        browser.evaluateJavascript("javascript:shoutOut()", null);
    }

    public void initialize(View v) {
        browser.evaluateJavascript("javascript:initialize()", null);
    }




}