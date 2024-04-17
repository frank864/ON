package com.example.julietonlineshop;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InstagramActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);

        webView= findViewById(R.id.webviewinstagram);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.instagram.com/francislavnex?igsh=bnFnN3gxcjBvdjhz");
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent= new Intent(InstagramActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}