package com.example.test3;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.test3.InsertAndShowQRCode.InsertData;

//import com.example.test3.Qr_maker.LoadImage;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Qr_maker extends Activity {
    public static final String TAG = null;
	Button mDown;
    ImageView mImgTrans;
    Uri imageUri;
    Bitmap mBitmap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qr_maker);
		//mDown = (Button) findViewById(R.id.btn_down);
        mImgTrans = (ImageView) findViewById(R.id.imgTranslate);
    	phpdo task = new phpdo();
    	task.execute();
    	
    	Button share_btn = (Button) findViewById(R.id.share_button);
    	
    	share_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				shareImage(imageUri);
			}
    	});
	}
	
	public void shareImage(Uri imageUri)
	{
		String path = Images.Media.insertImage(getContentResolver(), mBitmap, "", null);
		Uri uri = Uri.parse(path);
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("image/*");
		intent.putExtra(Intent.EXTRA_STREAM, uri);
		startActivity(Intent.createChooser(intent, "Choose"));
		
	}

	private class phpdo extends AsyncTask<String, Void, String> {
		
			public String result;
			
	        protected void onPreExecute(){
	 
	        }
	        protected String doInBackground(String... arg) {
	 
	            try 
	            {
	                String link = "http://10.1.31.157/get_id.php";
	                URL url = new URL(link);
	                HttpClient client = new DefaultHttpClient();
	                HttpGet request = new HttpGet();
	                request.setURI(new URI(link));
	                HttpResponse response = client.execute(request);
	                BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	 
	                StringBuffer sb = new StringBuffer("");
	                String line = "";
	 
	                while ((line = in.readLine()) != null) {
	                    sb.append(line);
	                    break;
	                }
	                in.close();
	                result = sb.toString();
	                Log.d(TAG, "qrStr: " + result);
	                
	                return sb.toString();
	            } catch (Exception e) {
	                return new String("Exception: " + e.getMessage());
	            }
	 
	        }
	 
	        protected void onPostExecute(String result){
	        	String qrcodeStr = "";
	        	qrcodeStr = result;
	        	Log.d(TAG, "result : "+ qrcodeStr);
                new LoadImage().execute("http://chart.apis.google.com/chart?cht=qr&chs=350x350&chl="+qrcodeStr);
                
	        }
	    }
	 
	private class LoadImage extends AsyncTask<String, String, Bitmap> {
		 
        ProgressDialog pDialog;
 
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Qr_maker.this);
            pDialog.setMessage("load img...");
            pDialog.show();
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Uri ImgUri = Uri.parse(urldisplay);
            imageUri = ImgUri;
            //mImgTrans.setImageURI(ImgUri);
            Bitmap qrcode_img = null;           
         try {
              InputStream in_strm= new java.net.URL(urldisplay).openStream();
              qrcode_img = BitmapFactory.decodeStream(in_strm);

         } catch (Exception e) {
             e.printStackTrace();
         }
         return qrcode_img;
     }

 
     protected void onPostExecute(Bitmap image) {
 
            if (image != null) {
            	mBitmap = image;
                mImgTrans.setImageBitmap(image);
                pDialog.dismiss();
 
            } else {
                pDialog.dismiss();
                Toast.makeText(Qr_maker.this, "img not found",
                        Toast.LENGTH_SHORT).show();
 
            }
        }
    }
}
