package com.takuya.cosmiccalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView takuview;

    String Mainpage = "file:///android_asset/index.html";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        takuview = (WebView)findViewById(R.id.webview);
        takuview.setWebViewClient(new TakuBrowser());
        takuview.getSettings().setJavaScriptEnabled(true);
        takuview.getSettings().setUseWideViewPort(true);
        takuview.getSettings().setLoadWithOverviewMode(true);
        takuview.getSettings().setBuiltInZoomControls(true);
        takuview.getSettings().setDisplayZoomControls(false);
        takuview.getSettings().setAllowFileAccessFromFileURLs(true);
        takuview.getSettings().setAllowUniversalAccessFromFileURLs(true);
        takuview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        takuview.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        takuview.loadUrl(Mainpage);
    }

    private class TakuBrowser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(final WebView view, final String url){
            view.loadUrl(url);
            return true;
        }
    }
}
