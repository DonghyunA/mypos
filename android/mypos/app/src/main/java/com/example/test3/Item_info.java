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

public class Item_info extends Activity {

	String item_weight = null;
	String item_volume = null;
	String item_code = null;
	EditText item_name = null;
	EditText item_count = null;
	Button btn_item_next = null;
	Button btn_restrict_item = null;
	Button btn_insurance_item = null;
	SharedPreferences item_info = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_info);
		item_info = getSharedPreferences("item_info", MODE_PRIVATE);
		
		final Spinner spinner1 = (Spinner)findViewById(R.id.snipper_item_weight);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.item_weight, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter1);
        
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            	item_weight = (String) spinner1.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

               // sometimes you need nothing here
            }
        });
        
        final Spinner spinner2 = (Spinner)findViewById(R.id.snipper_item_volume);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.item_volume, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner2.setAdapter(adapter2);
        
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            	item_volume = (String) spinner2.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

               // sometimes you need nothing here
            }
        });
        
        final Spinner spinner3 = (Spinner)findViewById(R.id.snipper_item_code);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.item_code, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner3.setAdapter(adapter3);
        
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            	item_code = (String) spinner3.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

               // sometimes you need nothing here
            }
        });
        item_name = (EditText)findViewById(R.id.item_name);
        item_count = (EditText)findViewById(R.id.item_count);

     
        
        btn_item_next = (Button)findViewById(R.id.btn_item_next);
        btn_item_next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), Resive_info.class);
				SharedPreferences.Editor editor = item_info.edit();
				editor.putString("item_weight", item_weight);
				editor.putString("item_volume", item_volume);
				editor.putString("item_code", item_code);
				editor.putString("item_name", item_name.getText().toString());
				editor.putString("item_count", item_count.getText().toString());
				editor.commit();
				startActivity(intent);
			}
		});
        
        
        btn_restrict_item = (Button)findViewById(R.id.btn_restrict_item);
        btn_restrict_item.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
				intent.putExtra("item_info_type","restrict");
				startActivity(intent);
				
			}
		});
        
        btn_insurance_item = (Button)findViewById(R.id.btn_insurance_item);
        btn_insurance_item.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
				intent.putExtra("item_info_type","insurance");
				startActivity(intent);
				
			}
		});
        
        
	}
}
