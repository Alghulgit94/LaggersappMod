package com.example.usuario.laggersappmod;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FortShop extends AppCompatActivity {

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fort_shop);

        mWebView = (WebView) findViewById(R.id.activity_main_webview);
// Activamos jаvascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Configurar zoom y desactivar botones de zoom
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
// Url que carga la app (webview)
        mWebView.loadUrl("https://fnbr.co/shop");
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
