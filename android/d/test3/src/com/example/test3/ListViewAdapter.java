package com.example.test3;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
		
		ListviewItem listViewItem = listViewItemList.get(position);
		
		name_view.setText(listViewItem.getList_i_name());
		producer_view.setText(listViewItem.getList_i_producer());
		quality_view.setText(listViewItem.getList_i_quality());
		purchased_view.setText(listViewItem.getList_i_purchased());
		date_view.setText(listViewItem.getList_i_date());
		
		
		return convertView;
	}
	public void addItem(String name, String producer, String quality, String purchased, String date)
	{
		ListviewItem item = new ListviewItem();
		
		item.setList_i_name(name);
		item.setList_i_producer(producer);
		item.setList_i_quality(quality);
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
