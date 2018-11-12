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

public class Select_Item_Adapter extends BaseAdapter {
	private ArrayList<Select_Items> listViewItemList = new ArrayList<Select_Items>();
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
	public ArrayList<Select_Items> getArrayItem()
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
		
		final Select_Items listViewItem = listViewItemList.get(position);
		
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
				if(!number_text.getText().toString().equals(""))
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
				if(!number_text.getText().toString().equals(""))
				{
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
	public void addItem(int id, String name, String producer, String quality, String quantity, String purchased, int price, String date)
	{
		Select_Items item = new Select_Items();
		
		item.setList_i_id(id);
		item.setList_i_name(name);
		item.setList_i_producer(producer);
		item.setList_i_quality(quality);
		item.setList_i_quantity(quantity);
		item.setList_i_purchased(purchased);
		item.setList_i_price(price);
		item.setList_i_date(date);
		
		listViewItemList.add(item);
	}
	public void addItem(Object obj)
	{
		Select_Items item = (Select_Items) obj;
		listViewItemList.add(item);
	}
	public void clear()
	{
		listViewItemList.clear();
	}


}
