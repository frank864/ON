package com.example.julietonlineshop;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class XActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);

        webView= findViewById(R.id.webviewx);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://x.com/Lavnexgnrall?t=WUBnLaN0FDZric8rIAQg2A&s=09");
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent= new Intent(XActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}