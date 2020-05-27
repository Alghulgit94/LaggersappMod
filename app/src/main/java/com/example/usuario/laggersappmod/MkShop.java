package com.example.usuario.laggersappmod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MkShop extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mk_shop);
        mWebView = findViewById(R.id.activity_main_webview);
// Activamos jаvascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Configurar zoom y desactivar botones de zoom
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        //porcentaje de zoom que le queremos hacer.
        mWebView.setInitialScale(1);
       // se utiliza para que si la web tiene un meta tag
        // con el valor "viewport" coge ese valor y lo utiliza
        // para mostrar el WebView con el tamaño que hay en ese meta tag.
        webSettings.setUseWideViewPort(true);
        //web sin zoom
        webSettings.setLoadWithOverviewMode(true);
// Url que carga la app (webview)
        mWebView.loadUrl("https://mk11-tracker.herokuapp.com/shop/");
// Forzamos el webview para que abra los enlaces internos dentro de la la APP
        mWebView.setWebViewClient(new WebViewClient());
    }
    @Override
    public void onBackPressed() { if(mWebView.canGoBack()) {
        mWebView.goBack();
    } else {
        super.onBackPressed();
    }

    }
}
