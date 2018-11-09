package com.example.test3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class Item_list extends Activity {
	private static String IP_ADDRESS = "10.1.31.177";
    private static String TAG = "phptest";
    private String mJsonString;
    //private ArrayList<ListviewItem> mArrayList;
    private static final char[] INITIAL_SOUND = { '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��' };
	ArrayList<ListviewItem> temp_iteminfo = new ArrayList<ListviewItem>();
	ListViewAdapter adapter = new ListViewAdapter();
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        GetData task = new GetData();
        Intent intent = getIntent();
        task.execute( "http://" + IP_ADDRESS + "/getjson.php", intent.getExtras().getString("user_id"));
        
        Button btn_total = (Button) findViewById(R.id.total);
        btn_total.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				adapter.clear();
            	for(int i= 0; i < temp_iteminfo.size();i++)
            	{
        			adapter.addItem(temp_iteminfo.get(i));
        			adapter.notifyDataSetChanged();
            	}
			}
		});

    }
    
    
    private class GetData extends AsyncTask<String, Void, String>{
    	ProgressDialog progressDialog;
    	String errorString = null;

		@Override
		protected String doInBackground(String... params) {
			
			String serverURL = params[0];
            String postParameters = "i_whos=" + params[1];


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "response code - " + responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }

                bufferedReader.close();

                return sb.toString().trim();


            } catch (Exception e) {

                Log.d(TAG, "GetData : Error ", e);
                errorString = e.toString();

                return null;
            }
			
		}
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
			progressDialog = ProgressDialog.show(Item_list.this,"Please Wait", null, true, true);
		}
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			progressDialog.dismiss();
			Log.d(TAG, "response - " + result);
			if( result == null){
				
			}
			else{
				mJsonString = result;
				showResult();
				//�ӽ� ����ü�� ����
            	temp_iteminfo.addAll(adapter.getArrayItem());
			}
		}
		private void showResult(){

	        String TAG_JSON="i_list";
	        String TAG_NAME = "i_name";
	        String TAG_PRODUCER = "i_producer";
	        String TAG_QUALITY ="i_quality";
	        String TAG_QUANTITY = "i_quantity";
	        String TAG_PURCHASED ="i_purchased";
	        String TAG_DATE ="i_date";
	        final LinearLayout lm = (LinearLayout) findViewById(R.id.l_layout);
	        ListView listview;
	        
	        
	        listview = (ListView)findViewById(R.id.item_list);
	        listview.setAdapter(adapter);
	        boolean [] chosung = new boolean[19]; 
	        try {
	            JSONObject jsonObject = new JSONObject(mJsonString);
	            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);
	            
	             // linearLayout params ����
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                for(int j=0;j<INITIAL_SOUND.length;j++)
                {
                	for(int k=0;k<jsonArray.length();k++)
                	{
    	                JSONObject item = jsonArray.getJSONObject(k);

    	                String i_name = item.getString(TAG_NAME);
    	                String i_producer = item.getString(TAG_PRODUCER);
    	                String i_quality = item.getString(TAG_QUALITY);
    	                String i_quantity = item.getString(TAG_QUANTITY);
    	                String i_purchased = item.getString(TAG_PURCHASED);
    	                String i_date = item.getString(TAG_DATE);
    	                //����ü�� �ֱ�
    	                if(j==0)
    	                {
    	                	adapter.addItem(i_name, i_producer, i_quality, i_quantity, i_purchased, i_date);
    	                }
    	                
    	                //System.out.println("j=" + j + "    k="+ k + "bool = " + SoundSearcher.matchfirstchar(jsonArray.getJSONObject(k).getString(TAG_NAME), INITIAL_SOUND[j]));
                		if(SoundSearcher.matchfirstchar(jsonArray.getJSONObject(k).getString(TAG_NAME), INITIAL_SOUND[j]) ==true)
                		{
                			chosung[j] = true;
                		}
                	}
                	if(chosung[j] == true)
                	{
//       	             // LinearLayout ����
    	                LinearLayout ll = new LinearLayout(Item_list.this);
    	                ll.setOrientation(LinearLayout.HORIZONTAL);
                		// ��ư ����
    	                
    	                final Button btn = new Button(Item_list.this);
    	                // setId ��ư�� ���� Ű��
    	                btn.setId(j + 1);
    	                btn.setText(Character.toString(INITIAL_SOUND[j]));
    	                btn.setLayoutParams(params);

    	                final int position = j;

    	                btn.setOnClickListener(new OnClickListener() {
    	                    public void onClick(View v) {
    	                    	
    	                    	adapter.clear();
    	                    	for(int i= 0; i < temp_iteminfo.size();i++)
    	                    	{
    	                    		if(SoundSearcher.matchfirstchar(temp_iteminfo.get(i).getList_i_name(),INITIAL_SOUND[position]))
    	                    		{
    	                    			adapter.addItem(temp_iteminfo.get(i));
    	                    			adapter.notifyDataSetChanged();
    	                    		}
    	                    	}
    	                        Log.d("log", "position :" + position);
    	                        Toast.makeText(getApplicationContext(), "Ŭ���� position:" + position, Toast.LENGTH_LONG).show();
    	                    }
    	                });

    	                //��ư add
    	                ll.addView(btn);
    	                //LinearLayout ���ǵȰ� add
    	                lm.addView(ll);
                	}
                }
//	            for(int i=0;i<jsonArray.length();i++){
//
//	                JSONObject item = jsonArray.getJSONObject(i);
//
//	                String i_name = item.getString(TAG_NAME);
//	                String i_producer = item.getString(TAG_PRODUCER);
//	                String i_quality = item.getString(TAG_QUALITY);
//	                String i_purchased = item.getString(TAG_PURCHASED);
//	                String i_date = item.getString(TAG_DATE);
//
//	                //����ü�� �ֱ�
//	                adapter.addItem(i_name, i_producer, i_quality, i_purchased, i_date);
//	                
//	                
//	             // LinearLayout ����
//	                LinearLayout ll = new LinearLayout(Item_list.this);
//	                ll.setOrientation(LinearLayout.HORIZONTAL);
//
//	                // TextView ����
//	                TextView tvName = new TextView(Item_list.this);
//	                tvName.setText("Name : " + i_name + " ");
//	                ll.addView(tvName);
//
//	                // TextView ����
//	                TextView tvProducer = new TextView(Item_list.this);
//	                tvProducer.setText("i_producer : " + i_producer + "  ");
//	                ll.addView(tvProducer);
//	                
//	                // TextView ����
//	                TextView tvQuality = new TextView(Item_list.this);
//	                tvQuality.setText("i_quality : " + i_quality + "  ");
//	                ll.addView(tvQuality);
//	                
//	                // TextView ����
//	                TextView tvpurchased = new TextView(Item_list.this);
//	                tvpurchased.setText("i_purchased : " + i_purchased + "  ");
//	                ll.addView(tvpurchased);
//	                
//	                // TextView ����
//	                TextView tvDate = new TextView(Item_list.this);
//	                tvDate.setText("i_date : " + i_date + "  ");
//	                ll.addView(tvDate);

	                // ��ư ����
	                
//	                final Button btn = new Button(Item_list.this);
//	                // setId ��ư�� ���� Ű��
//	                btn.setId(i + 1);
//	                btn.setText("Apply");
//	                btn.setLayoutParams(params);
//
//	                final int position = i;
//
//	                btn.setOnClickListener(new OnClickListener() {
//	                    public void onClick(View v) {
//	                        Log.d("log", "position :" + position);
//	                        Toast.makeText(getApplicationContext(), "Ŭ���� position:" + position, Toast.LENGTH_LONG).show();
//	                    }
//	                });
//
//	                //��ư add
//	                ll.addView(btn);
//	                //LinearLayout ���ǵȰ� add
//	                lm.addView(ll);
	                
	                
//	                PersonalData personalData = new PersonalData();
//
//	                personalData.setMember_id(id);
//	                personalData.setMember_name(name);
//	                personalData.setMember_country(country);
//
//	                mArrayList.add(personalData);
//	                mAdapter.notifyDataSetChanged();
//	            }



	        } catch (JSONException e) {

	            Log.d(TAG, "showResult : ", e);
	        }

	    }
    	
    }
}
//http://recipes4dev.tistory.com/42#3-fragment%EC%97%90%EC%84%9C-listview-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0
//webnautes.tistory.com/829
//protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_item_list);
//
//    final LinearLayout lm = (LinearLayout) findViewById(R.id.l_layout);
//
//    // linearLayout params ����
//    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//            LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//    for (int j = 0; j <= 5; j++) {
//        // LinearLayout ����
//        LinearLayout ll = new LinearLayout(this);
//        ll.setOrientation(LinearLayout.HORIZONTAL);
//
//        // TextView ����
//        TextView tvProdc = new TextView(this);
//        tvProdc.setText("Name" + j + " ");
//        ll.addView(tvProdc);
//
//        // TextView ����
//        TextView tvAge = new TextView(this);
//        tvAge.setText("   Age" + j + "  ");
//        ll.addView(tvAge);
//
//        // ��ư ����
//        final Button btn = new Button(this);
//        // setId ��ư�� ���� Ű��
//        btn.setId(j + 1);
//        btn.setText("Apply");
//        btn.setLayoutParams(params);
//
//        final int position = j;
//
//        btn.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//                Log.d("log", "position :" + position);
//                Toast.makeText(getApplicationContext(), "Ŭ���� position:" + position, Toast.LENGTH_LONG).show();
//            }
//        });
//
//        //��ư add
//        ll.addView(btn);
//        //LinearLayout ���ǵȰ� add
//        lm.addView(ll);
//    }
//}

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
