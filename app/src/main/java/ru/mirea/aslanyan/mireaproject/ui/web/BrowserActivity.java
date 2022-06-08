package ru.mirea.aslanyan.mireaproject.ui.web;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

import ru.mirea.aslanyan.mireaproject.R;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        WebView webView = (WebView)findViewById(R.id.webView);
        Uri data = getIntent().getData();
        webView.loadUrl(data.toString());

    }
}