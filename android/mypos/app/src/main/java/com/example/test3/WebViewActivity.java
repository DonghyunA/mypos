package com.example.test3;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class WebViewActivity extends Activity{
	private WebView post_webView;
	private Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);
		init_webView();        // 핸들러를 통한 JavaScript 이벤트 반응
		handler = new Handler();
	}
	public void init_webView() {
		// WebView 설정
		post_webView = (WebView) findViewById(R.id.daum_webview);
		// JavaScript 허용
		post_webView.getSettings().setJavaScriptEnabled(true);
		// JavaScript의 window.open 허용
		post_webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		// web client 를 chrome 으로 설정
		post_webView.setWebChromeClient(new WebChromeClient());
		// webview url load. php 파일 주소
		Intent intent = getIntent();
		if(intent.getExtras().getString("item_info_type").compareTo("restrict")==0)
		{
			post_webView.loadUrl("http://parcel.epost.go.kr/parcel/use_guide/limititem_cont.jsp");
		}
		else if(intent.getExtras().getString("item_info_type").compareTo("insurance")==0)
		{
			post_webView.loadUrl("http://parcel.epost.go.kr/parcel/use_guide/insuranceView.jsp");
		}
	}
}

