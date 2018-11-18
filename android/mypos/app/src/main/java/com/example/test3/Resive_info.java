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

public class Resive_info extends Activity {
	Button btn_r_addr;
	Button btn_resive_next;
	EditText txt_r_addr1;
	EditText txt_r_addr2;
	EditText txt_r_name;
	EditText txt_r_phone;
	SharedPreferences resiver_info = null;
	String tel_front_str = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_resive_info);
		/* 주소 초기화  */
		resiver_info = getSharedPreferences("resiver", MODE_PRIVATE);
		SharedPreferences.Editor editor = resiver_info.edit();
		editor.clear();
		editor.commit();
		txt_r_addr1 = (EditText)findViewById(R.id.txt_r_addr1);
		txt_r_addr1.setText("");
		txt_r_addr2 = (EditText)findViewById(R.id.txt_r_addr2);
		txt_r_addr2.setText("");

		txt_r_name = (EditText)findViewById(R.id.txt_r_name);
		txt_r_phone = (EditText)findViewById(R.id.txt_r_phone);

		btn_r_addr = (Button)findViewById(R.id.btn_r_addr);

		final Spinner spinner1 = (Spinner)findViewById(R.id.snipper1);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.tel_first, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		spinner1.setAdapter(adapter1);

		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				tel_front_str = (String) spinner1.getSelectedItem();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

				// sometimes you need nothing here
			}
		});

		btn_r_addr.setOnClickListener( new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), Daum_web_view_activity.class);
				intent.putExtra("before_activity","Resive_info");
				startActivity(intent);
			}

		});

		btn_resive_next = (Button)findViewById(R.id.btn_resive_next);
		btn_resive_next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), InsertAndShowQRCode.class);
				SharedPreferences.Editor editor = resiver_info.edit();
				editor.putString("name", txt_r_name.getText().toString());
				String tel_num = tel_front_str + txt_r_phone.getText().toString();
				editor.putString("phone", tel_num);
				editor.putString("addrDetail", txt_r_addr2.getText().toString());
				editor.commit();
				startActivity(intent);
			}
		});
	}
	protected void onStart(){
		super.onStart();
		resiver_info = getSharedPreferences("resiver", MODE_PRIVATE);
		txt_r_addr1 = (EditText)findViewById(R.id.txt_r_addr1);
		txt_r_addr1.setText(resiver_info.getString("post_num", "")
				+resiver_info.getString("road_addr", "")
				+resiver_info.getString("building_name", ""));
	}
}
