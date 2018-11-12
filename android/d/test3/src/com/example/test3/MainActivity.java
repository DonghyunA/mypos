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
//    Button mButton = new Button(this); //버튼을 선언
// 
//    LayoutParams pm = new LayoutParams(); //레이아웃파라미터 생성
//    pm.width = LayoutParams.WRAP_CONTENT; //버튼의 너비를 설정(픽셀단위로도 지정가능)
//    pm.height = LayoutParams.WRAP_CONTENT; //버튼의 높이를 설정(픽셀단위로도 지정 가능)
//    pm.gravity = Gravity.CENTER; //버튼의 Gravity를 지정
// 
//    mButton.setText("button"); //버튼에 들어갈 텍스트를 지정(String)
//    mButton.setBackgroundResource(R.drawable.button_selector); //버튼 이미지를 지정(int)
//    mButton.setLayoutParams(pm); //앞서 설정한 레이아웃파라미터를 버튼에 적용
//    mButton.setOnClickListener(mOnClick); //버튼에 OnClickListener를 지정(OnClickListener)
// 
//    mView.addView(mButton); //지정된 뷰에 셋팅완료된 mButton을 추가
//}
//
//
//출처: http://webcache.googleusercontent.com/search?q=cache:eGOWu3UMky8J:proletariat.tistory.com/49+&cd=4&hl=ko&ct=clnk&gl=kr [프롤레타리아, IT에 범접하다.]