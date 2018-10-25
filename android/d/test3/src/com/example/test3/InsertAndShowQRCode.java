package com.example.test3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Button;
import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.URL;

public class InsertAndShowQRCode extends Activity {

	private static String IP_ADDRESS = "10.1.31.157";
    private static String TAG = "phptest";

    private Button btn_insert;
    SharedPreferences sender_info = null;
    SharedPreferences resiver_info = null;
    SharedPreferences item_info = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertandshowqrcode);

    	sender_info = getSharedPreferences("sender", MODE_PRIVATE);
        
        String s_addr =  sender_info.getString("road_addr", "")
        		+sender_info.getString("building_name", "")
        		+sender_info.getString("addrDetail","");
        String s_addrNum = sender_info.getString("post_num", "");
        String s_name = sender_info.getString("name", "");
        String s_phone = sender_info.getString("phone", "");
        
        
        resiver_info = getSharedPreferences("resiver", MODE_PRIVATE);
        String r_addr =  resiver_info.getString("road_addr", "")
        		+resiver_info.getString("building_name", "")
        		+resiver_info.getString("addrDetail","");
        String r_addrNum = resiver_info.getString("post_num", ""); 
        String r_name = resiver_info.getString("name", "");
        String r_phone = resiver_info.getString("phone", "");

        item_info = getSharedPreferences("item_info", MODE_PRIVATE);
        String m_name = item_info.getString("item_name", "");
        String m_weight = item_info.getString("item_weight", "");
        String m_volume = item_info.getString("item_volume", "");
        String m_code = item_info.getString("item_code", "");
        String m_count = item_info.getString("item_count", "");
        InsertData task = new InsertData();
        task.execute("http://" + IP_ADDRESS + "/insert.php", s_addr,s_addrNum,s_name,s_phone, r_addr, r_addrNum, r_name, r_phone
        		, m_name, m_weight, m_volume, m_code, m_count);
        
        

        btn_insert = (Button)findViewById(R.id.btn_item_insert);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	sender_info = getSharedPreferences("sender", MODE_PRIVATE);
                
                String s_addr =  sender_info.getString("road_addr", "")
                		+sender_info.getString("building_name", "")
                		+sender_info.getString("addrDetail","");
                String s_addrNum = sender_info.getString("post_num", "");
                String s_name = sender_info.getString("name", "");
                String s_phone = sender_info.getString("phone", "");
                
                
                resiver_info = getSharedPreferences("resiver", MODE_PRIVATE);
                String r_addr =  resiver_info.getString("road_addr", "")
                		+resiver_info.getString("building_name", "")
                		+resiver_info.getString("addrDetail","");
                String r_addrNum = resiver_info.getString("post_num", ""); 
                String r_name = resiver_info.getString("name", "");
                String r_phone = resiver_info.getString("phone", "");

                item_info = getSharedPreferences("item_info", MODE_PRIVATE);
                String m_name = item_info.getString("item_name", "");
                String m_weight = item_info.getString("item_weight", "");
                String m_volume = item_info.getString("item_volume", "");
                String m_code = item_info.getString("item_code", "");
                String m_count = item_info.getString("item_count", "");
                InsertData task = new InsertData();
                task.execute("http://" + IP_ADDRESS + "/insert.php", s_addr,s_addrNum,s_name,s_phone, r_addr, r_addrNum, r_name, r_phone
                		, m_name, m_weight, m_volume, m_code, m_count);

                //저장 초기화 해야함
            }
        });

    }

    class InsertData extends AsyncTask<String, Void, String>{
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(InsertAndShowQRCode.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            //mTextViewResult.setText(result);
            Log.d(TAG, "POST response  - " + result);
            
			Intent intent = new Intent(getApplicationContext(), Qr_maker.class);
			startActivity(intent);
        }


        @Override
        protected String doInBackground(String... params) {

            String s_addr = (String)params[1];
            String s_addrNum = (String)params[2];
            String s_name = (String)params[3];
            String s_phone = (String)params[4];
            
            String r_addr = (String)params[5];
            String r_addrNum = (String)params[6];
            String r_name = (String)params[7];
            String r_phone = (String)params[8];
            
            String m_name = (String)params[9];
            String m_weight = (String)params[10];
            String m_volume = (String)params[11];
            String m_code = (String)params[12];
            String m_count = (String)params[13];

            String serverURL = (String)params[0];
            String postParameters = "s_addr=" + s_addr + "&s_addrNum=" + s_addrNum + "&s_name=" + s_name+ "&s_phone=" + s_phone+ 
            		"&r_addr=" + r_addr+ "&r_addrNum=" + r_addrNum + "&r_name=" + r_name+ "&r_phone=" + r_phone+
            		"&m_name=" + m_name+ "&m_weight=" + m_weight + "&m_volume=" + m_volume+ "&m_code=" + m_code+ "&m_count=" + m_count;

            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "POST response code - " + responseStatusCode);

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
                String line = null;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);

                return new String("Error: " + e.getMessage());
            }

        }
    }


}