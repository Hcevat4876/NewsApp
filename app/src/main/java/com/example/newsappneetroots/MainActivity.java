package com.example.newsappneetroots; // NOT: Eğer paket adın farklıysa bu satırı değiştirme!

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.myWebView);
        
        // Web ayarlarını yapılandırıyoruz
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Harita ve dinamik içerikler için şart
        webSettings.setDomStorageEnabled(true); // Netlify sitelerinin düzgün yüklenmesi için gerekli
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        // Linklerin uygulamanın içinde kalmasını sağlıyoruz
        webView.setWebViewClient(new WebViewClient()); 

        // Senin Netlify linkin:
        webView.loadUrl("https://yol-takip.netlify.app"); 
    }

    // Telefonda geri tuşuna basınca uygulamadan çıkmasın, site içinde geri gitsin:
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
