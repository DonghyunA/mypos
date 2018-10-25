package com.example.test3;

import android.app.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import com.example.test3.Send_info;

public class Daum_web_view_activity extends Activity {
		private WebView daum_webView;    
		private TextView daum_result;    
		private Handler handler;   
		private TextView txt_addr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_daum_web_view_activity);
		daum_result = (TextView) findViewById(R.id.daum_result);        // WebView �ʱ�ȭ       
		init_webView();        // �ڵ鷯�� ���� JavaScript �̺�Ʈ ����       
		handler = new Handler();
	}
	public void init_webView() {        
		   // WebView ����       
		   daum_webView = (WebView) findViewById(R.id.daum_webview);        
		   // JavaScript ���       
		   daum_webView.getSettings().setJavaScriptEnabled(true);        
		   // JavaScript�� window.open ���        
		   daum_webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);        
		   // JavaScript�̺�Ʈ�� ������ �Լ��� ���� �� Ŭ������ �ٿ���       
		   daum_webView.addJavascriptInterface(new AndroidBridge(), "TestApp");        
		   // web client �� chrome ���� ����       
		   daum_webView.setWebChromeClient(new WebChromeClient());        
		   // webview url load. php ���� �ּ�        
		   daum_webView.loadUrl("http://10.1.31.157/daum_address.php");    
	}    
	private class AndroidBridge {       
		@JavascriptInterface        
		public void setAddress(final String arg1, final String arg2, final String arg3) {            
			handler.post(new Runnable() {                
				@Override                
				public void run() {
					Intent intent = getIntent();
					SharedPreferences addr_info = null;
					if(intent.getExtras().getString("before_activity").compareTo("Send_info")==0)
					{
						addr_info = getSharedPreferences("sender", MODE_PRIVATE);
					}
					else if(intent.getExtras().getString("before_activity").compareTo("Resive_info")==0)
					{
						addr_info = getSharedPreferences("resiver", MODE_PRIVATE);
					}
					else
					{
						//����ó��
						addr_info = getSharedPreferences("sender", MODE_PRIVATE);
					}
					
					SharedPreferences.Editor editor = addr_info.edit();
					editor.putString("post_num",arg1);
					editor.putString("road_addr",arg2);
					editor.putString("building_name",arg3);
					editor.commit();
					
					//txt_addr = (TextView) findViewById(R.id.txt_addr1);
					//txt_addr.setText(arg1+arg2+arg3);
					//daum_result.setText(String.format("(%s) %s %s", arg1, arg2, arg3));                   
					// WebView�� �ʱ�ȭ ���������� ������ �� ����                   
					finish();
					//init_webView();                
				}            
			});       
		}
	}
}
