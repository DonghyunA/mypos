package com.example.test3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Send_info extends Activity {
	Button btn_addr;
	Button btn_send_next;
	EditText txt_s_addr1;
	EditText txt_s_addr2;
	EditText txt_s_name;
	EditText txt_s_phone;
	SharedPreferences sender_info = null;
	String tel_front_str = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_info);

		/* 주소 초기화  */
		sender_info = getSharedPreferences("sender", MODE_PRIVATE);
		SharedPreferences.Editor editor = sender_info.edit();
		editor.clear();
		editor.commit();
		txt_s_addr1 = (EditText)findViewById(R.id.txt_s_addr1);
		txt_s_addr1.setText("");
		txt_s_addr2 = (EditText)findViewById(R.id.txt_s_addr2);
		txt_s_addr2.setText("");

		txt_s_name = (EditText)findViewById(R.id.txt_s_name);
		txt_s_phone = (EditText)findViewById(R.id.txt_s_phone);

		btn_addr = (Button)findViewById(R.id.btn_s_addr);

		final Spinner spinner2 = (Spinner)findViewById(R.id.snipper2);
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.tel_first, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		spinner2.setAdapter(adapter2);

		spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				tel_front_str = (String) spinner2.getSelectedItem();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

				// sometimes you need nothing here
			}
		});

		btn_addr.setOnClickListener( new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), Daum_web_view_activity.class);
				intent.putExtra("before_activity","Send_info");
				startActivity(intent);
			}

		});

		btn_send_next = (Button)findViewById(R.id.btn_send_next);
		btn_send_next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), Item_info.class);
				SharedPreferences.Editor editor = sender_info.edit();
				editor.putString("name", txt_s_name.getText().toString());
				String tel_num = tel_front_str + txt_s_phone.getText().toString();
				editor.putString("phone", tel_num);
				editor.putString("addrDetail", txt_s_addr2.getText().toString());
				editor.commit();
				startActivity(intent);
			}
		});
	}
	protected void onStart(){
		super.onStart();
		sender_info = getSharedPreferences("sender", MODE_PRIVATE);
		txt_s_addr1 = (EditText)findViewById(R.id.txt_s_addr1);
		txt_s_addr1.setText(sender_info.getString("post_num", "")
				+sender_info.getString("road_addr", "")
				+sender_info.getString("building_name", ""));
	}
}
