package com.example.test3;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
	private ArrayList<ListviewItem> listViewItemList = new ArrayList<ListviewItem>();
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listViewItemList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listViewItemList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	public ArrayList<ListviewItem> getArrayItem()
	{
		return listViewItemList;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//final int pos = position;
		
		final Context context = parent.getContext();
		if(convertView == null)
		{
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.listview_item,parent,false);
		}
		TextView name_view = (TextView)convertView.findViewById(R.id.list_i_name);
		TextView producer_view = (TextView)convertView.findViewById(R.id.list_i_producer);
		TextView quality_view = (TextView)convertView.findViewById(R.id.list_i_quality);
		TextView purchased_view = (TextView)convertView.findViewById(R.id.list_i_purchased);
		TextView date_view = (TextView)convertView.findViewById(R.id.list_i_date);
		final EditText number_text = (EditText)convertView.findViewById(R.id.list_i_number);
		Button btn_up = (Button)convertView.findViewById(R.id.list_i_btn_up);
		Button btn_down = (Button)convertView.findViewById(R.id.list_i_btn_down);
		
		final ListviewItem listViewItem = listViewItemList.get(position);
		
		name_view.setText(listViewItem.getList_i_name());
		producer_view.setText(listViewItem.getList_i_producer());
		quality_view.setText(listViewItem.getList_i_quality());
		purchased_view.setText(listViewItem.getList_i_purchased());
		date_view.setText(listViewItem.getList_i_date());
		
		btn_up.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int num = 0;
				if(number_text.getText().toString() != null)
				{
					num = Integer.parseInt(number_text.getText().toString());	
					if(num <Integer.parseInt(listViewItem.getList_i_quantity()))
					{
						num++;
					}
				}
				number_text.setText(String.valueOf(num));
				
			}
		});
		
		btn_down.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int num = 0;
				Log.d("gaga", number_text.getText().toString());
				if(number_text.getText().toString() != null)
				{Log.d("gaga1", number_text.getText().toString());
					num = Integer.parseInt(number_text.getText().toString());	
					if(num >0)
					{
						num--;
					}
				}
				number_text.setText(String.valueOf(num));
			}
		});
		
		return convertView;
	}
	public void addItem(String name, String producer, String quality, String quantity, String purchased, String date)
	{
		ListviewItem item = new ListviewItem();
		
		item.setList_i_name(name);
		item.setList_i_producer(producer);
		item.setList_i_quality(quality);
		item.setList_i_quantity(quantity);
		item.setList_i_purchased(purchased);
		item.setList_i_date(date);
		
		listViewItemList.add(item);
	}
	public void addItem(Object obj)
	{
		ListviewItem item = (ListviewItem) obj;
		listViewItemList.add(item);
	}
	public void clear()
	{
		listViewItemList.clear();
	}


}
