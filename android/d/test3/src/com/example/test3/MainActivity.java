package com.example.test3;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.InputStream;
import java.net.URL;
 
import android.app.ActionBar.LayoutParams;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;

import android.util.Log;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.Toast;

import android.widget.LinearLayout;

import android.widget.TextView;
 
import com.example.test3.R;
 
public class MainActivity extends Activity {
	Button btn_show;
	String user_id= "kdhkdk89@naver.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_show = (Button)findViewById(R.id.btn_show);
        btn_show.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), Select_Item_Activity.class);
				intent.putExtra("user_id",user_id);
				startActivity(intent);
				
			}
		});
    }
}



//onCreate(){
//	 
//    Button mButton = new Button(this); //��ư�� ����
// 
//    LayoutParams pm = new LayoutParams(); //���̾ƿ��Ķ���� ����
//    pm.width = LayoutParams.WRAP_CONTENT; //��ư�� �ʺ� ����(�ȼ������ε� ��������)
//    pm.height = LayoutParams.WRAP_CONTENT; //��ư�� ���̸� ����(�ȼ������ε� ���� ����)
//    pm.gravity = Gravity.CENTER; //��ư�� Gravity�� ����
// 
//    mButton.setText("button"); //��ư�� �� �ؽ�Ʈ�� ����(String)
//    mButton.setBackgroundResource(R.drawable.button_selector); //��ư �̹����� ����(int)
//    mButton.setLayoutParams(pm); //�ռ� ������ ���̾ƿ��Ķ���͸� ��ư�� ����
//    mButton.setOnClickListener(mOnClick); //��ư�� OnClickListener�� ����(OnClickListener)
// 
//    mView.addView(mButton); //������ �信 ���ÿϷ�� mButton�� �߰�
//}
//
//
//��ó: http://webcache.googleusercontent.com/search?q=cache:eGOWu3UMky8J:proletariat.tistory.com/49+&cd=4&hl=ko&ct=clnk&gl=kr [���ѷ�Ÿ����, IT�� �����ϴ�.]